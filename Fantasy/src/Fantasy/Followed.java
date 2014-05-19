/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "FOLLOWED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followed.findAll", query = "SELECT f FROM Followed f"),
    @NamedQuery(name = "Followed.findByUserName", query = "SELECT f FROM Followed f WHERE f.followedPK.userName = :userName"),
    @NamedQuery(name = "Followed.findByBandName", query = "SELECT f FROM Followed f WHERE f.followedPK.bandName = :bandName")})
public class Followed implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FollowedPK followedPK;
    @Basic(optional = false)
    @Column(name = "BAND_NAME")
    private String bandName;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "followed")
    private FantasySetlist fantasySetlist;
    @JoinColumns({
        @JoinColumn(name = "BAND_NAME", referencedColumnName = "BAND_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "START_DATE", referencedColumnName = "START_DATE")})
    @ManyToOne(optional = false)
    private Band band;
    @JoinColumn(name = "USER_NAME", referencedColumnName = "USER_NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FantasyUser fantasyUser;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "followed")
    private FantasyPerformance fantasyPerformance;

    public Followed() {
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public Followed(FollowedPK followedPK) {
        this.followedPK = followedPK;
        this.bandName = followedPK.getBandName();
    }

    public Followed(String userName, String bandName) {
        this.followedPK = new FollowedPK(userName, bandName);
        this.bandName = bandName;
    }

    public FollowedPK getFollowedPK() {
        return followedPK;
    }

    public void setFollowedPK(FollowedPK followedPK) {
        this.followedPK = followedPK;
        this.bandName = followedPK.getBandName();
    }

    public FantasySetlist getFantasySetlist() {
        return fantasySetlist;
    }

    public void setFantasySetlist(FantasySetlist fantasySetlist) {
        this.fantasySetlist = fantasySetlist;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        Band oldBand = this.band;
        this.band = band;
        changeSupport.firePropertyChange("band", oldBand, band);
    }

    public FantasyUser getFantasyUser() {
        return fantasyUser;
    }

    public void setFantasyUser(FantasyUser fantasyUser) {
        FantasyUser oldFantasyUser = this.fantasyUser;
        this.fantasyUser = fantasyUser;
        changeSupport.firePropertyChange("fantasyUser", oldFantasyUser, fantasyUser);
    }

    public FantasyPerformance getFantasyPerformance() {
        return fantasyPerformance;
    }

    public void setFantasyPerformance(FantasyPerformance fantasyPerformance) {
        this.fantasyPerformance = fantasyPerformance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followedPK != null ? followedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followed)) {
            return false;
        }
        Followed other = (Followed) object;
        if ((this.followedPK == null && other.followedPK != null) || (this.followedPK != null && !this.followedPK.equals(other.followedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.Followed[ followedPK=" + followedPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
