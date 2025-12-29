/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.GradeScheme;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dhruba
 */
@Stateless
public class GradeSchemeFacade extends AbstractFacade<GradeScheme> {

    @PersistenceContext(unitName = "AssessmentFeedbackSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GradeSchemeFacade() {
        super(GradeScheme.class);
    }
    public void deleteGradeScheme(Long GradeSchemeId) {
    em.createQuery(
        "DELETE FROM GradeScheme u WHERE u.id = :GradeSchemeId"
    ).setParameter("GradeSchemeId", GradeSchemeId).executeUpdate();
}
    
       public GradeScheme findByID(Long id) {
    try {
        return em.createQuery("SELECT u FROM GradeScheme u WHERE u.id = :id", GradeScheme.class)
            .setParameter("id", id)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
       
        public void updateGradeScheme( Long Id, String name, int aMin, int bMin, int cMin, int dMin) {
    
    em.createQuery(
        "UPDATE GradeScheme u SET u.schemeName = :name, u.aMin = :aMin, u.bMin = :bMin, u.cMin = :cMin, u.dMin = :dMin  WHERE u.id = :Id"
    )
    .setParameter("Id", Id)
    .setParameter("name", name)
    .setParameter("aMin", aMin)
    .setParameter("bMin", bMin)
    .setParameter("cMin", cMin)
    .setParameter("dMin", dMin)
    .executeUpdate();
}
        
        public List<Long> getIDs() {
    return em.createQuery(
        "SELECT u.id FROM GradeScheme u",
        Long.class
    ).getResultList();
}
}
