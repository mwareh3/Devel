/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "FANTASY_PERFORMANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FantasyPerformance.findAll", query = "SELECT f FROM FantasyPerformance f"),
    @NamedQuery(name = "FantasyPerformance.findByBandName", query = "SELECT f FROM FantasyPerformance f WHERE f.fantasyPerformancePK.bandName = :bandName"),
    @NamedQuery(name = "FantasyPerformance.findByUserName", query = "SELECT f FROM FantasyPerformance f WHERE f.fantasyPerformancePK.userName = :userName"),
    @NamedQuery(name = "FantasyPerformance.findByDuration", query = "SELECT f FROM FantasyPerformance f WHERE f.duration = :duration"),
    @NamedQuery(name = "FantasyPerformance.findByCreationDate", query = "SELECT f FROM FantasyPerformance f WHERE f.creationDate = :creationDate"),
    @NamedQuery(name = "FantasyPerformance.findByLastEdit", query = "SELECT f FROM FantasyPerformance f WHERE f.lastEdit = :lastEdit")})
public class FantasyPerformance implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FantasyPerformancePK fantasyPerformancePK;
    @Column(name = "DURATION")
    private Integer duration;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "LAST_EDIT")
    @Temporal(TemporalType.DATE)
    private Date lastEdit;
    @JoinColumns({
        @JoinColumn(name = "USER_NAME", referencedColumnName = "USER_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "BAND_NAME", referencedColumnName = "BAND_NAME", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Followed followed;

    public FantasyPerformance() {
    }

    public FantasyPerformance(FantasyPerformancePK fantasyPerformancePK) {
        this.fantasyPerformancePK = fantasyPerformancePK;
    }

    public FantasyPerformance(String bandName, String userName) {
        this.fantasyPerformancePK = new FantasyPerformancePK(bandName, userName);
    }

    public FantasyPerformancePK getFantasyPerformancePK() {
        return fantasyPerformancePK;
    }

    public void setFantasyPerformancePK(FantasyPerformancePK fantasyPerformancePK) {
        this.fantasyPerformancePK = fantasyPerformancePK;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(Date lastEdit) {
        this.lastEdit = lastEdit;
    }

    public Followed getFollowed() {
        return followed;
    }

    public void setFollowed(Followed followed) {
        this.followed = followed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fantasyPerformancePK != null ? fantasyPerformancePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FantasyPerformance)) {
            return false;
        }
        FantasyPerformance other = (FantasyPerformance) object;
        if ((this.fantasyPerformancePK == null && other.fantasyPerformancePK != null) || (this.fantasyPerformancePK != null && !this.fantasyPerformancePK.equals(other.fantasyPerformancePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.FantasyPerformance[ fantasyPerformancePK=" + fantasyPerformancePK + " ]";
    }
    
}
