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
@Table(name = "sist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sist.findAll", query = "SELECT s FROM Sist s"),
    @NamedQuery(name = "Sist.findBySistId", query = "SELECT s FROM Sist s WHERE s.sistId = :sistId"),
    @NamedQuery(name = "Sist.findBySistnomb", query = "SELECT s FROM Sist s WHERE s.sistnomb = :sistnomb"),
    @NamedQuery(name = "Sist.findBySistesta", query = "SELECT s FROM Sist s WHERE s.sistesta = :sistesta")})
public class Sist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sist__id")
    private Integer sistId;
    @Size(max = 200)
    @Column(name = "sistnomb")
    private String sistnomb;
    @Column(name = "sistesta")
    private Integer sistesta;

    public Sist() {
    }

    public Sist(Integer sistId) {
        this.sistId = sistId;
    }

    public Integer getSistId() {
        return sistId;
    }

    public void setSistId(Integer sistId) {
        this.sistId = sistId;
    }

    public String getSistnomb() {
        return sistnomb;
    }

    public void setSistnomb(String sistnomb) {
        this.sistnomb = sistnomb;
    }

    public Integer getSistesta() {
        return sistesta;
    }

    public void setSistesta(Integer sistesta) {
        this.sistesta = sistesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sistId != null ? sistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sist)) {
            return false;
        }
        Sist other = (Sist) object;
        if ((this.sistId == null && other.sistId != null) || (this.sistId != null && !this.sistId.equals(other.sistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sist[ sistId=" + sistId + " ]";
    }
    
}
