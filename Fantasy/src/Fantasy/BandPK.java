/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mike
 */
@Embeddable
public class BandPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "BAND_NAME")
    private String bandName;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    public BandPK() {
    }

    public BandPK(String bandName, Date startDate) {
        this.bandName = bandName;
        this.startDate = startDate;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bandName != null ? bandName.hashCode() : 0);
        hash += (startDate != null ? startDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BandPK)) {
            return false;
        }
        BandPK other = (BandPK) object;
        if ((this.bandName == null && other.bandName != null) || (this.bandName != null && !this.bandName.equals(other.bandName))) {
            return false;
        }
        if ((this.startDate == null && other.startDate != null) || (this.startDate != null && !this.startDate.equals(other.startDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.BandPK[ bandName=" + bandName + ", startDate=" + startDate + " ]";
    }
    
}
