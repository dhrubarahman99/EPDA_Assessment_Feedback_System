/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Assessment;
import entity.Module;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dhruba
 */
@Stateless
public class AssessmentFacade extends AbstractFacade<Assessment> {

    @PersistenceContext(unitName = "AssessmentFeedbackSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AssessmentFacade() {
        super(Assessment.class);
    }
        public List<Long> getIDs() {
    return em.createQuery(
        "SELECT u.id FROM Assessment u",
        Long.class
    ).getResultList();
}
    public void deleteAssessment(Long Id) {
    em.createQuery(
        "DELETE FROM Assessment u WHERE u.id = :Id"
    ).setParameter("Id", Id).executeUpdate();
}
        public Assessment findByID(Long id) {
    try {
        return em.createQuery("SELECT u FROM Assessment u WHERE u.id = :id", Assessment.class)
            .setParameter("id", id)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
        public void updateAssessment( Long Id, String title, int weightage, Long moduleId) {
    Module module = em.find(Module.class, moduleId);
    
    em.createQuery(
        "UPDATE Assessment u SET u.title = :title , u.weightage = :weightage , u.module = :module WHERE u.id = :Id"
    )
    .setParameter("Id", Id)
    .setParameter("title", title)
    .setParameter("weightage", weightage)
    .setParameter("module", module)
    .executeUpdate();
}
}
