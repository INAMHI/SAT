package beans;

import entities.Umbsat;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessions.UmbsatFacade;

@ManagedBean(name = "umbsatController")
@SessionScoped
public class UmbsatController extends AbstractController<Umbsat> implements Serializable {

    @EJB
    private UmbsatFacade ejbFacade;
    private List<Umbsat> items1;

    public UmbsatController() {
        super(Umbsat.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public List<Umbsat> getItems1(int esta, int copa) {
        items1 = ejbFacade.buscarLimites(esta, copa);
        return items1;
    }

    public void setItems1(List<Umbsat> items1) {
        this.items1 = items1;
    }
}
