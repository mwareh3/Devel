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
public class EventPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "VENUE_ID")
    private int venueId;
    @Basic(optional = false)
    @Column(name = "EVENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    public EventPK() {
    }

    public EventPK(int venueId, Date eventDate) {
        this.venueId = venueId;
        this.eventDate = eventDate;
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
        hash += (int) venueId;
        hash += (eventDate != null ? eventDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventPK)) {
            return false;
        }
        EventPK other = (EventPK) object;
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
        return "Fantasy.EventPK[ venueId=" + venueId + ", eventDate=" + eventDate + " ]";
    }
    
}
