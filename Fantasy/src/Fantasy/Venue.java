/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "VENUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venue.findAll", query = "SELECT v FROM Venue v"),
    @NamedQuery(name = "Venue.findByVenueId", query = "SELECT v FROM Venue v WHERE v.venueId = :venueId"),
    @NamedQuery(name = "Venue.findByVenueName", query = "SELECT v FROM Venue v WHERE v.venueName = :venueName"),
    @NamedQuery(name = "Venue.findByStreetAddress", query = "SELECT v FROM Venue v WHERE v.streetAddress = :streetAddress"),
    @NamedQuery(name = "Venue.findByCity", query = "SELECT v FROM Venue v WHERE v.city = :city"),
    @NamedQuery(name = "Venue.findByUsState", query = "SELECT v FROM Venue v WHERE v.usState = :usState")})
public class Venue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VENUE_ID")
    private Integer venueId;
    @Column(name = "VENUE_NAME")
    private String venueName;
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Column(name = "CITY")
    private String city;
    @Column(name = "US_STATE")
    private String usState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venue")
    private Collection<Event> eventCollection;

    public Venue() {
    }

    public Venue(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsState() {
        return usState;
    }

    public void setUsState(String usState) {
        this.usState = usState;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venueId != null ? venueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venue)) {
            return false;
        }
        Venue other = (Venue) object;
        if ((this.venueId == null && other.venueId != null) || (this.venueId != null && !this.venueId.equals(other.venueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.Venue[ venueId=" + venueId + " ]";
    }
    
}
