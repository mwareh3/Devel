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
public class PerformancePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "BAND_NAME")
    private String bandName;
    @Basic(optional = false)
    @Column(name = "VENUE_ID")
    private int venueId;
    @Basic(optional = false)
    @Column(name = "EVENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    public PerformancePK() {
    }

    public PerformancePK(String bandName, int venueId, Date eventDate) {
        this.bandName = bandName;
        this.venueId = venueId;
        this.eventDate = eventDate;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
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
        hash += (int) venueId;
        hash += (eventDate != null ? eventDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerformancePK)) {
            return false;
        }
        PerformancePK other = (PerformancePK) object;
        if ((this.bandName == null && other.bandName != null) || (this.bandName != null && !this.bandName.equals(other.bandName))) {
            return false;
        }
        if (this.venueId != other.venueId) {
            return false;
        }
        if ((this.eventDate == null && other.eventDate != null) || (this.eventDate != null && !this.eventDate.equals(other.eventDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.PerformancePK[ bandName=" + bandName + ", venueId=" + venueId + ", eventDate=" + eventDate + " ]";
    }
    
}
