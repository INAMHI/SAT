/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "data")
@XmlRootElement
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "data__id")
    private Integer dataId;
    @Column(name = "esta__id")
    private Integer estaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datafetd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafetd;
    @Column(name = "datavalo")
    private Double datavalo;
    @Column(name = "dataince")
    private BigInteger dataince;
    @Size(max = 5)
    @Column(name = "inda__id")
    private String indaId;
    @Size(max = 2147483647)
    @Column(name = "dataobse")
    private String dataobse;
    @Column(name = "datactrl")
    private Boolean datactrl;
    @Column(name = "datavers")
    private Integer datavers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "datauing")
    private String datauing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datafing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafing;
    @Size(max = 20)
    @Column(name = "dataumod")
    private String dataumod;
    @Column(name = "datafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafmod;

    public Data() {
    }

    public Data(Integer dataId) {
        this.dataId = dataId;
    }

    public Data(Integer dataId, Date datafetd, String datauing, Date datafing) {
        this.dataId = dataId;
        this.datafetd = datafetd;
        this.datauing = datauing;
        this.datafing = datafing;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getEstaId() {
        return estaId;
    }

    public void setEstaId(Integer estaId) {
        this.estaId = estaId;
    }

    public Date getDatafetd() {
        return datafetd;
    }

    public void setDatafetd(Date datafetd) {
        this.datafetd = datafetd;
    }

    public Double getDatavalo() {
        return datavalo;
    }

    public void setDatavalo(Double datavalo) {
        this.datavalo = datavalo;
    }

    public BigInteger getDataince() {
        return dataince;
    }

    public void setDataince(BigInteger dataince) {
        this.dataince = dataince;
    }

    public String getIndaId() {
        return indaId;
    }

    public void setIndaId(String indaId) {
        this.indaId = indaId;
    }

    public String getDataobse() {
        return dataobse;
    }

    public void setDataobse(String dataobse) {
        this.dataobse = dataobse;
    }

    public Boolean getDatactrl() {
        return datactrl;
    }

    public void setDatactrl(Boolean datactrl) {
        this.datactrl = datactrl;
    }

    public Integer getDatavers() {
        return datavers;
    }

    public void setDatavers(Integer datavers) {
        this.datavers = datavers;
    }

    public String getDatauing() {
        return datauing;
    }

    public void setDatauing(String datauing) {
        this.datauing = datauing;
    }

    public Date getDatafing() {
        return datafing;
    }

    public void setDatafing(Date datafing) {
        this.datafing = datafing;
    }

    public String getDataumod() {
        return dataumod;
    }

    public void setDataumod(String dataumod) {
        this.dataumod = dataumod;
    }

    public Date getDatafmod() {
        return datafmod;
    }

    public void setDatafmod(Date datafmod) {
        this.datafmod = datafmod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataId != null ? dataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.dataId == null && other.dataId != null) || (this.dataId != null && !this.dataId.equals(other.dataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Data[ dataId=" + dataId + " ]";
    }
    
}
