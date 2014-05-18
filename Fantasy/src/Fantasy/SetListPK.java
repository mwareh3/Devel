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
public class SetListPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "BAND_NAME")
    private String bandName;
    @Basic(optional = false)
    @Column(name = "EVENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    public SetListPK() {
    }

    public SetListPK(String bandName, Date eventDate) {
        this.bandName = bandName;
        this.eventDate = eventDate;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bandName != null ? bandName.hashCode() : 0);
        hash += (eventDate != null ? eventDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SetListPK)) {
            return false;
        }
        SetListPK other = (SetListPK) object;
        if ((this.bandName == null && other.bandName != null) || (this.bandName != null && !this.bandName.equals(other.bandName))) {
            return false;
        }
        if ((this.eventDate == null && other.eventDate != null) || (this.eventDate != null && !this.eventDate.equals(other.eventDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.SetListPK[ bandName=" + bandName + ", eventDate=" + eventDate + " ]";
    }
    
}
