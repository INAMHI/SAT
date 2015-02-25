/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Sist;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego
 */
@Stateless
public class SistFacade extends AbstractFacade<Sist> {
    @PersistenceContext(unitName = "SATPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SistFacade() {
        super(Sist.class);
    }
    
    public List<Sist> buscarTodos() {
        return getEntityManager().createNativeQuery("SELECT * FROM sist", Sist.class).getResultList();
    }
    
}
