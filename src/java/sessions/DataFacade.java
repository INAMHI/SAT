/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Data;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego
 */
@Stateless
public class DataFacade extends AbstractFacade<Data> {

    @PersistenceContext(unitName = "SATPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DataFacade() {
        super(Data.class);
    }

    public List<Data> datosDia(String fecha1, String fecha2, String estacion, int copa) {
        List lista = getEntityManager().createNativeQuery("SELECT esta__id FROM esta WHERE estacodi='" + estacion + "'").getResultList();
        Object o = lista.get(0);
        int codigoEstacion = Integer.parseInt(o.toString());
        return getEntityManager().createNativeQuery("SELECT * FROM data WHERE datafetd between'" + fecha1 + "' and '" + fecha2 + "'  and esta__id=" + codigoEstacion + " and copa__id=" + copa + " and cali1__id=8 ORDER BY datafetd", Data.class).getResultList();
    }

    public int idEstacion(String estacion) {
        List lista = getEntityManager().createNativeQuery("SELECT esta__id FROM esta WHERE estacodi='" + estacion + "'").getResultList();
        Object o = lista.get(0);
        int codigoEstacion = Integer.parseInt(o.toString());
        return codigoEstacion;
    }
}
