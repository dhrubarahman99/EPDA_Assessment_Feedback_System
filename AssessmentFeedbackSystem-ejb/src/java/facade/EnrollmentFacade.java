/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Enrollment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dhruba
 */
@Stateless
public class EnrollmentFacade extends AbstractFacade<Enrollment> {

    @PersistenceContext(unitName = "AssessmentFeedbackSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Long countStudentsByModule(Long moduleId) {
        try {
            return em.createQuery(
                    "SELECT COUNT(DISTINCT e.student.id) " +
                    "FROM Enrollment e " +
                    "WHERE e.classGroup.module.id = :mid",
                    Long.class
            )
            .setParameter("mid", moduleId)
            .getSingleResult();
        } catch (Exception e) {
            return 0L;
        }
    }


    public EnrollmentFacade() {
        super(Enrollment.class);
    }
    
}
