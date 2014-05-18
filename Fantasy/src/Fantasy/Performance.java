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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "PERFORMANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Performance.findAll", query = "SELECT p FROM Performance p"),
    @NamedQuery(name = "Performance.findByBandName", query = "SELECT p FROM Performance p WHERE p.performancePK.bandName = :bandName"),
    @NamedQuery(name = "Performance.findByVenueId", query = "SELECT p FROM Performance p WHERE p.performancePK.venueId = :venueId"),
    @NamedQuery(name = "Performance.findByEventDate", query = "SELECT p FROM Performance p WHERE p.performancePK.eventDate = :eventDate"),
    @NamedQuery(name = "Performance.findByDuration", query = "SELECT p FROM Performance p WHERE p.duration = :duration")})
public class Performance implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerformancePK performancePK;
    @Column(name = "DURATION")
    private Integer duration;
    @JoinColumns({
        @JoinColumn(name = "BAND_NAME", referencedColumnName = "BAND_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "START_DATE", referencedColumnName = "START_DATE")})
    @ManyToOne(optional = false)
    private Band band;
    @JoinColumns({
        @JoinColumn(name = "VENUE_ID", referencedColumnName = "VENUE_ID", insertable = false, updatable = false),
        @JoinColumn(name = "EVENT_DATE", referencedColumnName = "EVENT_DATE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Event event;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "performance")
    private Collection<SetList> setListCollection;

    public Performance() {
    }

    public Performance(PerformancePK performancePK) {
        this.performancePK = performancePK;
    }

    public Performance(String bandName, int venueId, Date eventDate) {
        this.performancePK = new PerformancePK(bandName, venueId, eventDate);
    }

    public PerformancePK getPerformancePK() {
        return performancePK;
    }

    public void setPerformancePK(PerformancePK performancePK) {
        this.performancePK = performancePK;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @XmlTransient
    public Collection<SetList> getSetListCollection() {
        return setListCollection;
    }

    public void setSetListCollection(Collection<SetList> setListCollection) {
        this.setListCollection = setListCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (performancePK != null ? performancePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Performance)) {
            return false;
        }
        Performance other = (Performance) object;
        if ((this.performancePK == null && other.performancePK != null) || (this.performancePK != null && !this.performancePK.equals(other.performancePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.Performance[ performancePK=" + performancePK + " ]";
    }
    
}
