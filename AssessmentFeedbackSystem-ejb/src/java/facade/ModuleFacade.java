/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

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
public class ModuleFacade extends AbstractFacade<Module> {

    @PersistenceContext(unitName = "AssessmentFeedbackSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModuleFacade() {
        super(Module.class);
    }
    public List<Long> getmoduleIDs() {
    return em.createQuery(
        "SELECT u.id FROM Module u",
        Long.class
    ).getResultList();
}
    
     public Module findByID(Long id) {
    try {
        return em.createQuery("SELECT u FROM Module u WHERE u.id = :id", Module.class)
            .setParameter("id", id)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
    
}
