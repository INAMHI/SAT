/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "umbsat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Umbsat.findAll", query = "SELECT u FROM Umbsat u"),
    @NamedQuery(name = "Umbsat.findByUmbsatId", query = "SELECT u FROM Umbsat u WHERE u.umbsatId = :umbsatId"),
    @NamedQuery(name = "Umbsat.findByUmbsatmes", query = "SELECT u FROM Umbsat u WHERE u.umbsatmes = :umbsatmes"),
    @NamedQuery(name = "Umbsat.findByUmbsatmax", query = "SELECT u FROM Umbsat u WHERE u.umbsatmax = :umbsatmax"),
    @NamedQuery(name = "Umbsat.findByUmbsatmin", query = "SELECT u FROM Umbsat u WHERE u.umbsatmin = :umbsatmin"),
    @NamedQuery(name = "Umbsat.findByUmbsatavi", query = "SELECT u FROM Umbsat u WHERE u.umbsatavi = :umbsatavi"),
    @NamedQuery(name = "Umbsat.findByUmbsatalt", query = "SELECT u FROM Umbsat u WHERE u.umbsatalt = :umbsatalt"),
    @NamedQuery(name = "Umbsat.findByUmbsatrio", query = "SELECT u FROM Umbsat u WHERE u.umbsatrio = :umbsatrio"),
    @NamedQuery(name = "Umbsat.findByUmbsatubi", query = "SELECT u FROM Umbsat u WHERE u.umbsatubi = :umbsatubi"),
    @NamedQuery(name = "Umbsat.findByUmbsatprov", query = "SELECT u FROM Umbsat u WHERE u.umbsatprov = :umbsatprov")})
public class Umbsat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "umbsat__id")
    private Integer umbsatId;
    @Column(name = "umbsatmes")
    private Integer umbsatmes;
    @Column(name = "umbsatmax")
    private Double umbsatmax;
    @Column(name = "umbsatmin")
    private Double umbsatmin;
    @Column(name = "umbsatavi")
    private Double umbsatavi;
    @Column(name = "umbsatalt")
    private Double umbsatalt;
    @Size(max = 200)
    @Column(name = "umbsatrio")
    private String umbsatrio;
    @Size(max = 200)
    @Column(name = "umbsatubi")
    private String umbsatubi;
    @Size(max = 200)
    @Column(name = "umbsatprov")
    private String umbsatprov;

    public Umbsat() {
    }

    public Umbsat(Integer umbsatId) {
        this.umbsatId = umbsatId;
    }

    public Integer getUmbsatId() {
        return umbsatId;
    }

    public void setUmbsatId(Integer umbsatId) {
        this.umbsatId = umbsatId;
    }

    public Integer getUmbsatmes() {
        return umbsatmes;
    }

    public void setUmbsatmes(Integer umbsatmes) {
        this.umbsatmes = umbsatmes;
    }

    public Double getUmbsatmax() {
        return umbsatmax;
    }

    public void setUmbsatmax(Double umbsatmax) {
        this.umbsatmax = umbsatmax;
    }

    public Double getUmbsatmin() {
        return umbsatmin;
    }

    public void setUmbsatmin(Double umbsatmin) {
        this.umbsatmin = umbsatmin;
    }

    public Double getUmbsatavi() {
        return umbsatavi;
    }

    public void setUmbsatavi(Double umbsatavi) {
        this.umbsatavi = umbsatavi;
    }

    public Double getUmbsatalt() {
        return umbsatalt;
    }

    public void setUmbsatalt(Double umbsatalt) {
        this.umbsatalt = umbsatalt;
    }

    public String getUmbsatrio() {
        return umbsatrio;
    }

    public void setUmbsatrio(String umbsatrio) {
        this.umbsatrio = umbsatrio;
    }

    public String getUmbsatubi() {
        return umbsatubi;
    }

    public void setUmbsatubi(String umbsatubi) {
        this.umbsatubi = umbsatubi;
    }

    public String getUmbsatprov() {
        return umbsatprov;
    }

    public void setUmbsatprov(String umbsatprov) {
        this.umbsatprov = umbsatprov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (umbsatId != null ? umbsatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Umbsat)) {
            return false;
        }
        Umbsat other = (Umbsat) object;
        if ((this.umbsatId == null && other.umbsatId != null) || (this.umbsatId != null && !this.umbsatId.equals(other.umbsatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Umbsat[ umbsatId=" + umbsatId + " ]";
    }
    
}
