/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "vta__unidad_medida_parametros_tiempos_estadisticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findAll", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findByNombreParametro", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.nombreParametro = :nombreParametro"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findBySimboloUnidadMedida", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.simboloUnidadMedida = :simboloUnidadMedida"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findByNombreUnidadMedida", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.nombreUnidadMedida = :nombreUnidadMedida"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findByIdsDeEstadisticos", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.idsDeEstadisticos = :idsDeEstadisticos"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findBySimboloEstadistico", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.simboloEstadistico = :simboloEstadistico"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findByNombreEstadistico", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.nombreEstadistico = :nombreEstadistico"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findByUnidadMedidaTiempo", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.unidadMedidaTiempo = :unidadMedidaTiempo"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findByMedidaTiempo", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.medidaTiempo = :medidaTiempo"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findByNemonicoCopa", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.nemonicoCopa = :nemonicoCopa"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findByIdCopa", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.idCopa = :idCopa"),
    @NamedQuery(name = "VtaUnidadMedidaParametrosTiemposEstadisticos.findByIdParametro", query = "SELECT v FROM VtaUnidadMedidaParametrosTiemposEstadisticos v WHERE v.idParametro = :idParametro")})
public class VtaUnidadMedidaParametrosTiemposEstadisticos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 1000)
    @Column(name = "nombre_parametro")
    private String nombreParametro;
    @Size(max = 20)
    @Column(name = "simbolo_unidad_medida")
    private String simboloUnidadMedida;
    @Size(max = 100)
    @Column(name = "nombre_unidad_medida")
    private String nombreUnidadMedida;
    @Size(max = 1000)
    @Column(name = "ids_de_estadisticos")
    private String idsDeEstadisticos;
    @Size(max = 1000)
    @Column(name = "simbolo_estadistico")
    private String simboloEstadistico;
    @Size(max = 1000)
    @Column(name = "nombre_estadistico")
    private String nombreEstadistico;
    @Size(max = 50)
    @Column(name = "unidad_medida_tiempo")
    private String unidadMedidaTiempo;
    @Column(name = "medida_tiempo")
    private BigInteger medidaTiempo;
    @Id
    @Size(max = 1000)
    @Column(name = "nemonico_copa")
    private String nemonicoCopa;
    @Column(name = "id_copa")
    private Integer idCopa;
    @Column(name = "id_parametro")
    private Integer idParametro;

    public VtaUnidadMedidaParametrosTiemposEstadisticos() {
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public String getSimboloUnidadMedida() {
        return simboloUnidadMedida;
    }

    public void setSimboloUnidadMedida(String simboloUnidadMedida) {
        this.simboloUnidadMedida = simboloUnidadMedida;
    }

    public String getNombreUnidadMedida() {
        return nombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    public String getIdsDeEstadisticos() {
        return idsDeEstadisticos;
    }

    public void setIdsDeEstadisticos(String idsDeEstadisticos) {
        this.idsDeEstadisticos = idsDeEstadisticos;
    }

    public String getSimboloEstadistico() {
        return simboloEstadistico;
    }

    public void setSimboloEstadistico(String simboloEstadistico) {
        this.simboloEstadistico = simboloEstadistico;
    }

    public String getNombreEstadistico() {
        return nombreEstadistico;
    }

    public void setNombreEstadistico(String nombreEstadistico) {
        this.nombreEstadistico = nombreEstadistico;
    }

    public String getUnidadMedidaTiempo() {
        return unidadMedidaTiempo;
    }

    public void setUnidadMedidaTiempo(String unidadMedidaTiempo) {
        this.unidadMedidaTiempo = unidadMedidaTiempo;
    }

    public BigInteger getMedidaTiempo() {
        return medidaTiempo;
    }

    public void setMedidaTiempo(BigInteger medidaTiempo) {
        this.medidaTiempo = medidaTiempo;
    }

    public String getNemonicoCopa() {
        return nemonicoCopa;
    }

    public void setNemonicoCopa(String nemonicoCopa) {
        this.nemonicoCopa = nemonicoCopa;
    }

    public Integer getIdCopa() {
        return idCopa;
    }

    public void setIdCopa(Integer idCopa) {
        this.idCopa = idCopa;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }
}
