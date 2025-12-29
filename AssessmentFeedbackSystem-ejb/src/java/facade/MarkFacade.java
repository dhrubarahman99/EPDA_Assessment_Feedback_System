/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Assessment;
import entity.Enrollment;
import entity.Mark;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dhruba
 */
@Stateless
public class MarkFacade extends AbstractFacade<Mark> {

    @PersistenceContext(unitName = "AssessmentFeedbackSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarkFacade() {
        super(Mark.class);
    }
    
    
    public List<Mark> findByStudentId(Long sid) {
        return em.createQuery(
            "SELECT m FROM Mark m " +
            "WHERE m.enrollment.student.id = :sid " +
            "ORDER BY m.assessment.module.moduleName ASC, m.assessment.title ASC",
            Mark.class
        )
        .setParameter("sid", sid)
        .getResultList();
    }
    
public List<Long> getIDs() {
    return em.createQuery(
        "SELECT u.id FROM Mark u",
        Long.class
    ).getResultList();
}
    public void deleteMark(Long Id) {
    em.createQuery(
        "DELETE FROM Mark u WHERE u.id = :Id"
    ).setParameter("Id", Id).executeUpdate();
}
    public Mark findByID(Long id) {
    try {
        return em.createQuery("SELECT u FROM Mark u WHERE u.id = :id", Mark.class)
            .setParameter("id", id)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
    public void updateMark( Long Id, int score, String feedback, Long enrollementIds, Long assessmentIds) {
    Enrollment enrollment = em.find(Enrollment.class, enrollementIds);
    Assessment assessment = em.find(Assessment.class, assessmentIds);
    
    em.createQuery(
        "UPDATE Mark u SET u.score = :score , u.feedback = :feedback , u.enrollment = :enrollment, u.assessment = :assessment  WHERE u.id = :Id"
    )
    .setParameter("Id", Id)
    .setParameter("score", score)
    .setParameter("feedback", feedback)
    .setParameter("enrollment", enrollment)
    .setParameter("assessment", assessment)
    .executeUpdate();
}

}
