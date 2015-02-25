package beans;

import entities.Data;
import entities.Umbsat;
import entities.VtaUnidadMedidaParametrosTiemposEstadisticos;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import sessions.DataFacade;

@ManagedBean(name = "dataController")
@SessionScoped
public class DataController extends AbstractController<Data> implements Serializable {
    
    @EJB
    private DataFacade ejbFacade;
    @ManagedProperty(value = "#{umbsatController}")
    private UmbsatController umbsat;
    @ManagedProperty(value = "#{vtaUnidadMedidaParametrosTiemposEstadisticosController}")
    private VtaUnidadMedidaParametrosTiemposEstadisticosController vista;
    private List<Data> items1;
    private List<Umbsat> items2;
    private Double yMax;
    private Double alerta;
    private Double aviso;
    private String datosX;
    private String datosY;
    private String nombreEstacion;
    private String estacion;
    private int copa;
    private int esta;
    private String nombreSerie;
    private String sufijo;
    private String parametro;
    
    public DataController() {
        super(Data.class);
    }
    
    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    public UmbsatController getUmbsat() {
        return umbsat;
    }
    
    public void setUmbsat(UmbsatController umbsat) {
        this.umbsat = umbsat;
    }
    
    public VtaUnidadMedidaParametrosTiemposEstadisticosController getVista() {
        return vista;
    }
    
    public void setVista(VtaUnidadMedidaParametrosTiemposEstadisticosController vista) {
        this.vista = vista;
    }
    
    public String getDatosX() {
        return datosX;
    }
    
    public void setDatosX(String datosX) {
        this.datosX = datosX;
    }
    
    public String getDatosY() {
        return datosY;
    }
    
    public void setDatosY(String datosY) {
        this.datosY = datosY;
    }
    
    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }
    
    public String getNombreEstacion() {
        return nombreEstacion;
    }
    
    public String getEstacion() {
        return estacion;
    }
    
    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }
    
    public int getCopa() {
        return copa;
    }
    
    public void setCopa(int copa) {
        this.copa = copa;
    }
    
    public String getNombreSerie() {
        return nombreSerie;
    }
    
    public void setNombreSerie(String nombreSerie) {
        this.nombreSerie = nombreSerie;
    }
    
    public String getSufijo() {
        return sufijo;
    }
    
    public void setSufijo(String sufijo) {
        this.sufijo = sufijo;
    }
    
    public String getParametro() {
        return parametro;
    }
    
    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    public void createLinearModelPoll() {
        items1 = null;
        items2 = null;
        yMax = null;
        alerta = null;
        aviso = null;
        datosX = null;
        datosY = null;
        esta = 0;
        nombreSerie = null;
        sufijo = null;
        parametro = null;
        
        List<VtaUnidadMedidaParametrosTiemposEstadisticos> param = vista.getItems1(copa);
        Iterator iterador = param.iterator();
        while (iterador.hasNext()) {
            VtaUnidadMedidaParametrosTiemposEstadisticos aux = (VtaUnidadMedidaParametrosTiemposEstadisticos) iterador.next();
            setParametro(aux.getNombreParametro() + " " + aux.getNombreEstadistico() + "(" + aux.getSimboloUnidadMedida() + ")");
            setNombreSerie(aux.getNombreParametro());
            setSufijo(aux.getNombreUnidadMedida());
        }
        setItems1();
        esta = this.ejbFacade.idEstacion(estacion);
        setyMax();
        Iterator it = items1.iterator();
        String X = "[";
        String Y = "[";
        boolean bandera = true;
        while (it.hasNext()) {
            Data d = (Data) it.next();
            int horas = d.getDatafetd().getHours();
            int minutos = d.getDatafetd().getMinutes();
            String horaString = horas + "";
            String minutoString = minutos + "";
            if (horaString.length() == 1) {
                horaString = "0" + horaString;
            }
            if (minutoString.length() == 1) {
                minutoString = "0" + minutoString;
            }
            String horaMuestra = horaString + ":" + minutoString;
            if (bandera) {
                X = X + d.getDatavalo();
                Y = Y + "'" + horaMuestra + "'";
                bandera = false;
            } else {
                X = X + "," + d.getDatavalo();
                Y = Y + "," + "'" + horaMuestra + "'";
            }
        }
        X = X + "]";
        setDatosX(X);
        Y = Y + "]";
        setDatosY(Y);
        
        setItems2();
        
        Iterator it2 = items2.iterator();
        
        if (it2.hasNext()) {
            while (it2.hasNext()) {
                Umbsat u = (Umbsat) it2.next();
                setAlerta(u.getUmbsatalt());
                setAviso(u.getUmbsatavi());
            }
        }
        items1 = null;
        items2 = null;
    }
    
    public void createLinearModel() {
        items1 = null;
        items2 = null;
        yMax = null;
        alerta = null;
        aviso = null;
        datosX = null;
        datosY = null;
        esta = 0;
        nombreSerie = null;
        sufijo = null;
        parametro = null;
        if (estacion.compareToIgnoreCase("") != 0) {
            List<VtaUnidadMedidaParametrosTiemposEstadisticos> param = vista.getItems1(copa);
            Iterator iterador = param.iterator();
            while (iterador.hasNext()) {
                VtaUnidadMedidaParametrosTiemposEstadisticos aux = (VtaUnidadMedidaParametrosTiemposEstadisticos) iterador.next();
                setParametro(aux.getNombreParametro() + " " + aux.getNombreEstadistico() + "(" + aux.getSimboloUnidadMedida() + ")");
                setNombreSerie(aux.getNombreParametro());
                setSufijo(aux.getNombreUnidadMedida());
            }
            setItems1();
            esta = this.ejbFacade.idEstacion(estacion);
            setyMax();
            Iterator it = items1.iterator();
            String X = "[";
            String Y = "[";
            boolean bandera = true;
            while (it.hasNext()) {
                Data d = (Data) it.next();
                int horas = d.getDatafetd().getHours();
                int minutos = d.getDatafetd().getMinutes();
                String horaString = horas + "";
                String minutoString = minutos + "";
                if (horaString.length() == 1) {
                    horaString = "0" + horaString;
                }
                if (minutoString.length() == 1) {
                    minutoString = "0" + minutoString;
                }
                String horaMuestra = horaString + ":" + minutoString;
                if (bandera) {
                    X = X + d.getDatavalo();
                    Y = Y + "'" + horaMuestra + "'";
                    bandera = false;
                } else {
                    X = X + "," + d.getDatavalo();
                    Y = Y + "," + "'" + horaMuestra + "'";
                }
            }
            X = X + "]";
            setDatosX(X);
            Y = Y + "]";
            setDatosY(Y);
            
            setItems2();
            
            Iterator it2 = items2.iterator();
            
            if (it2.hasNext()) {
                while (it2.hasNext()) {
                    Umbsat u = (Umbsat) it2.next();
                    setAlerta(u.getUmbsatalt());
                    setAviso(u.getUmbsatavi());
                }
            }
            items1 = null;
            items2 = null;
        }
    }
    
    public List<Data> getItems1() {
        return items1;
    }
    
    public List<Umbsat> getItems2() {
        setItems2();
        return items2;
    }
    
    public void setItems2() {
        this.items2 = umbsat.getItems1(esta, copa);
    }
    
    public void setItems1() {
        String fecha1 = getCurrentTimeStamp() + " 00:00:00";
        String fecha2 = getCurrentTimeStamp() + " 23:59:59";
        items1 = this.ejbFacade.datosDia(fecha1, fecha2, estacion, copa);
        
    }
    
    public Double getyMax() {
        return yMax;
    }
    
    public void setyMax(Double yMax) {
        this.yMax = yMax;
    }
    
    public void setyMax() {
        setItems2();
        Iterator it = items2.iterator();
        if (it.hasNext()) {
            while (it.hasNext()) {
                Umbsat u = (Umbsat) it.next();
                yMax = u.getUmbsatmax();
            }
        }
        items2 = null;
    }
    
    public void setAlerta(Double alerta) {
        this.alerta = alerta;
    }
    
    public Double getAlerta() {
        return alerta;
    }
    
    public void setAviso(Double aviso) {
        this.aviso = aviso;
    }
    
    public Double getAviso() {
        return aviso;
    }
    
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
    
    public String atras(String sistema) {
        items1 = null;
        items2 = null;
        yMax = null;
        alerta = null;
        aviso = null;
        datosX = null;
        datosY = null;
        nombreEstacion = null;
        estacion = null;
        copa = 0;
        esta = 0;
        nombreSerie = null;
        sufijo = null;
        parametro = null;
        return "/" + sistema + "/" + sistema + ".xhtml?faces-redirect=true";
    }
}
