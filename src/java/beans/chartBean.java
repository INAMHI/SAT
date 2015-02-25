package beans;

import entities.Rios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

public class chartBean implements Serializable {

    private CartesianChartModel categoryModel;
    private CartesianChartModel linearModel;
    private List<Rios> rios;

    public chartBean() {
        createCategoryModel();
        createLinearModel();
    }

    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public CartesianChartModel getLinearModel() {
        return linearModel;
    }

    public void setRios(List<Rios> propiedades) {
        this.rios = propiedades;
    }

    public List<Rios> getRios() {
        rios=new ArrayList<Rios>();
        Rios r=new Rios();
        r.setId(1L);
        r.setNivmax("20");
        r.setNombre("Río Patul");
        r.setProvincia("Cañar");
        r.setUbicacion("Cañar");
        rios.add(r);
        return rios;
    }
    

    private void createCategoryModel() {
        categoryModel = new CartesianChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");

        boys.set("2004", 120);
        boys.set("2005", 120);
        boys.set("2006", 120);
        boys.set("2007", 120);
        boys.set("2008", 120);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");

        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);

        categoryModel.addSeries(boys);
        categoryModel.addSeries(girls);
    }

    private void createLinearModel() {
        linearModel = new CartesianChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Observado");
        series1.setShowLine(false);
     
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        
        
        LineChartSeries aviso = new LineChartSeries();
        aviso.setLabel("Aviso");
        aviso.setMarkerStyle(null);
        aviso.set(1, 7);
        aviso.set(2, 7);
        aviso.set(3, 7);
        aviso.set(4, 7);
        aviso.set(5, 7);
        
        LineChartSeries alerta = new LineChartSeries();
        alerta.setLabel("Alerta");
        alerta.set(1, 9);
        alerta.set(2, 9);
        alerta.set(3, 9);
        alerta.set(4, 9);
        alerta.set(5, 9);

        linearModel.addSeries(series1);
        linearModel.addSeries(aviso);
        linearModel.addSeries(alerta);
    }
}
