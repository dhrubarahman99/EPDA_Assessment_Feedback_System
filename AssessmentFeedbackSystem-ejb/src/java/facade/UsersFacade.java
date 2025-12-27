/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dhruba
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "AssessmentFeedbackSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public Users findByEmail(String email) {
    try {
        return em.createQuery("SELECT u FROM Users u WHERE u.email = :email", Users.class)
            .setParameter("email", email)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
    
    public List<Long> findUserIdsByRole(String role) {
    return em.createQuery(
        "SELECT u.id FROM Users u WHERE u.role = :role",
        Long.class
    )
    .setParameter("role", role)
    .getResultList();
}

    public void setLeaderID(Long leaderID, Long lecturerID) {
    Users leaderUser = em.find(Users.class, leaderID);
    
    em.createQuery(
        "UPDATE Users u SET u.leader = :leader WHERE u.id = :lecturerID"
    )
    .setParameter("leader", leaderUser)
    .setParameter("lecturerID", lecturerID)
    .executeUpdate();
}
    
    public List<Long> getuserIDs() {
    return em.createQuery(
        "SELECT u.id FROM Users u",
        Long.class
    ).getResultList();
}
    public void deleteUser(Long userId) {
    em.createQuery(
        "DELETE FROM Users u WHERE u.id = :userId"
    ).setParameter("userId", userId).executeUpdate();
}
    public Users findByID(Long id) {
    try {
        return em.createQuery("SELECT u FROM Users u WHERE u.id = :id", Users.class)
            .setParameter("id", id)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
    
    public void updateUser( Long userId, String email, String name, String password, String role) {
    
    em.createQuery(
        "UPDATE Users u SET u.email = :email , u.name = :name , u.password = :password , u.role = :role WHERE u.id = :userId"
    )
    .setParameter("userId", userId)
    .setParameter("email", email)
    .setParameter("name", name)
    .setParameter("password", password)
    .setParameter("role", role)
    .executeUpdate();
}
}
