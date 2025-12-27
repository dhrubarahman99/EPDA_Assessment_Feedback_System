/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.ClassGroup;
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
public class ClassGroupFacade extends AbstractFacade<ClassGroup> {

    @PersistenceContext(unitName = "AssessmentFeedbackSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClassGroupFacade() {
        super(ClassGroup.class);
    }
    public List<Long> getclassgroupIDs() {
    return em.createQuery(
        "SELECT u.id FROM ClassGroup u",
        Long.class
    ).getResultList();
}
    
        public void deleteClassgroup(Long classgroupId) {
    em.createQuery(
        "DELETE FROM ClassGroup u WHERE u.id = :classgroupId"
    ).setParameter("classgroupId", classgroupId).executeUpdate();
}
        
   public void updateClassgroup( Long classgroupId, String name, Long moduleId) {
    Module module = em.find(Module.class, moduleId);
    
    em.createQuery(
        "UPDATE ClassGroup u SET u.className = :name , u.module= :module WHERE u.id = :classgroupId"
    )
    .setParameter("classgroupId", classgroupId)
    .setParameter("name", name)
    .setParameter("module", module)
    .executeUpdate();
}
}
