package beans;

import entities.VtaUnidadMedidaParametrosTiemposEstadisticos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessions.VtaUnidadMedidaParametrosTiemposEstadisticosFacade;

@ManagedBean(name = "vtaUnidadMedidaParametrosTiemposEstadisticosController")
@SessionScoped
public class VtaUnidadMedidaParametrosTiemposEstadisticosController extends AbstractController<VtaUnidadMedidaParametrosTiemposEstadisticos> implements Serializable {

    @EJB
    private VtaUnidadMedidaParametrosTiemposEstadisticosFacade ejbFacade;
    private List<VtaUnidadMedidaParametrosTiemposEstadisticos> items;

    public VtaUnidadMedidaParametrosTiemposEstadisticosController() {
        super(VtaUnidadMedidaParametrosTiemposEstadisticos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public List<VtaUnidadMedidaParametrosTiemposEstadisticos> getItems1(int copa) {
        items = ejbFacade.buscarPorCopa(copa);
        return items;
    }
}
