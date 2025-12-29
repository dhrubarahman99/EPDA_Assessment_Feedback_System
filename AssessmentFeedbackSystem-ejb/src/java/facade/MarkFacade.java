/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

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


}
