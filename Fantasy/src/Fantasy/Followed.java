/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FollowedPK followedPK;
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

    public Followed(FollowedPK followedPK) {
        this.followedPK = followedPK;
    }

    public Followed(String userName, String bandName) {
        this.followedPK = new FollowedPK(userName, bandName);
    }

    public FollowedPK getFollowedPK() {
        return followedPK;
    }

    public void setFollowedPK(FollowedPK followedPK) {
        this.followedPK = followedPK;
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
        this.band = band;
    }

    public FantasyUser getFantasyUser() {
        return fantasyUser;
    }

    public void setFantasyUser(FantasyUser fantasyUser) {
        this.fantasyUser = fantasyUser;
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
    
}
