package beans;

import entities.Sist;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sessions.SistFacade;

@ManagedBean(name = "sistController")
@RequestScoped
public class SistController extends AbstractController<Sist> implements Serializable {

    @EJB
    private SistFacade ejbFacade;
    private List<Sist> items1;

    public SistController() {
        super(Sist.class);

    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);

    }

    public List<Sist> getItems1() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Successful", "Hello "));
        items1 = ejbFacade.buscarTodos();
        return items1;
    }

    public void setItems1(List<Sist> items1) {

        this.items1 = items1;
    }

    public void poll() {
        this.setItems1(null);
        getItems1();

    }
}
