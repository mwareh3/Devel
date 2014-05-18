/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByVenueId", query = "SELECT e FROM Event e WHERE e.eventPK.venueId = :venueId"),
    @NamedQuery(name = "Event.findByEventDate", query = "SELECT e FROM Event e WHERE e.eventPK.eventDate = :eventDate")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventPK eventPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<Attended> attendedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<Performance> performanceCollection;
    @JoinColumn(name = "VENUE_ID", referencedColumnName = "VENUE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venue venue;

    public Event() {
    }

    public Event(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public Event(int venueId, Date eventDate) {
        this.eventPK = new EventPK(venueId, eventDate);
    }

    public EventPK getEventPK() {
        return eventPK;
    }

    public void setEventPK(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    @XmlTransient
    public Collection<Attended> getAttendedCollection() {
        return attendedCollection;
    }

    public void setAttendedCollection(Collection<Attended> attendedCollection) {
        this.attendedCollection = attendedCollection;
    }

    @XmlTransient
    public Collection<Performance> getPerformanceCollection() {
        return performanceCollection;
    }

    public void setPerformanceCollection(Collection<Performance> performanceCollection) {
        this.performanceCollection = performanceCollection;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventPK != null ? eventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventPK == null && other.eventPK != null) || (this.eventPK != null && !this.eventPK.equals(other.eventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.Event[ eventPK=" + eventPK + " ]";
    }
    
}
