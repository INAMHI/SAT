/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Umbsat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego
 */
@Stateless
public class UmbsatFacade extends AbstractFacade<Umbsat> {
    @PersistenceContext(unitName = "SATPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UmbsatFacade() {
        super(Umbsat.class);
    }
    
     public List<Umbsat> buscarLimites(int esta,int copa) {
        return getEntityManager().createNativeQuery("SELECT * FROM umbsat WHERE esta__id="+esta+" and copa__id="+copa+"", Umbsat.class).getResultList();
    }
    
}
