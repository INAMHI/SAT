/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Umbsat;
import entities.VtaUnidadMedidaParametrosTiemposEstadisticos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego
 */
@Stateless
public class VtaUnidadMedidaParametrosTiemposEstadisticosFacade extends AbstractFacade<VtaUnidadMedidaParametrosTiemposEstadisticos> {
    @PersistenceContext(unitName = "SATPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VtaUnidadMedidaParametrosTiemposEstadisticosFacade() {
        super(VtaUnidadMedidaParametrosTiemposEstadisticos.class);
    }
    
    public List<VtaUnidadMedidaParametrosTiemposEstadisticos> buscarPorCopa(int copa) {
        return getEntityManager().createNativeQuery("SELECT * FROM vta__unidad_medida_parametros_tiempos_estadisticos WHERE id_copa="+copa+"", VtaUnidadMedidaParametrosTiemposEstadisticos.class).getResultList();
    }
    
}
