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
}
