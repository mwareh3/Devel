/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "BAND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Band.findAll", query = "SELECT b FROM Band b"),
    @NamedQuery(name = "Band.findByBandName", query = "SELECT b FROM Band b WHERE b.bandPK.bandName = :bandName"),
    @NamedQuery(name = "Band.findByStartDate", query = "SELECT b FROM Band b WHERE b.bandPK.startDate = :startDate"),
    @NamedQuery(name = "Band.findByEndDate", query = "SELECT b FROM Band b WHERE b.endDate = :endDate")})
public class Band implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BandPK bandPK;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "BAND_NAME")
    private String bandName;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    private Collection<Performance> performanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    private Collection<BandMember> bandMemberCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    private Collection<Followed> followedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    private Collection<Album> albumCollection;

    public Band() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        Date oldStartDate = this.startDate;
        this.startDate = startDate;
        changeSupport.firePropertyChange("startDate", oldStartDate, startDate);
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        String oldBandName = this.bandName;
        this.bandName = bandName;
        changeSupport.firePropertyChange("bandName", oldBandName, bandName);
    }
    
    

    public Band(BandPK bandPK) {
        this.bandPK = bandPK;
        this.bandName = bandPK.getBandName();
        this.startDate = bandPK.getStartDate();
    }

    public Band(String bandName, Date startDate) {
        this.bandPK = new BandPK(bandName, startDate);
        this.bandName = bandName;
        this.startDate = startDate;
    }

    public BandPK getBandPK() {
        return bandPK;
    }

    public void setBandPK(BandPK bandPK) {
        this.bandPK = bandPK;
        this.bandName = bandPK.getBandName();
        this.startDate = bandPK.getStartDate();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        Date oldEndDate = this.endDate;
        this.endDate = endDate;
        changeSupport.firePropertyChange("endDate", oldEndDate, endDate);
    }

    @XmlTransient
    public Collection<Performance> getPerformanceCollection() {
        return performanceCollection;
    }

    public void setPerformanceCollection(Collection<Performance> performanceCollection) {
        this.performanceCollection = performanceCollection;
    }

    @XmlTransient
    public Collection<BandMember> getBandMemberCollection() {
        return bandMemberCollection;
    }

    public void setBandMemberCollection(Collection<BandMember> bandMemberCollection) {
        this.bandMemberCollection = bandMemberCollection;
    }

    @XmlTransient
    public Collection<Followed> getFollowedCollection() {
        return followedCollection;
    }

    public void setFollowedCollection(Collection<Followed> followedCollection) {
        this.followedCollection = followedCollection;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bandPK != null ? bandPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Band)) {
            return false;
        }
        Band other = (Band) object;
        if ((this.bandPK == null && other.bandPK != null) || (this.bandPK != null && !this.bandPK.equals(other.bandPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.Band[ bandPK=" + bandPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
