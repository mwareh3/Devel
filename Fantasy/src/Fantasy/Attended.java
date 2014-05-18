/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "ATTENDED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attended.findAll", query = "SELECT a FROM Attended a"),
    @NamedQuery(name = "Attended.findByUserName", query = "SELECT a FROM Attended a WHERE a.attendedPK.userName = :userName"),
    @NamedQuery(name = "Attended.findByVenueId", query = "SELECT a FROM Attended a WHERE a.attendedPK.venueId = :venueId"),
    @NamedQuery(name = "Attended.findByComments", query = "SELECT a FROM Attended a WHERE a.comments = :comments")})
public class Attended implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AttendedPK attendedPK;
    @Column(name = "COMMENTS")
    private String comments;
    @JoinColumns({
        @JoinColumn(name = "VENUE_ID", referencedColumnName = "VENUE_ID", insertable = false, updatable = false),
        @JoinColumn(name = "EVENT_DATE", referencedColumnName = "EVENT_DATE")})
    @ManyToOne(optional = false)
    private Event event;
    @JoinColumn(name = "USER_NAME", referencedColumnName = "USER_NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FantasyUser fantasyUser;

    public Attended() {
    }

    public Attended(AttendedPK attendedPK) {
        this.attendedPK = attendedPK;
    }

    public Attended(String userName, int venueId) {
        this.attendedPK = new AttendedPK(userName, venueId);
    }

    public AttendedPK getAttendedPK() {
        return attendedPK;
    }

    public void setAttendedPK(AttendedPK attendedPK) {
        this.attendedPK = attendedPK;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public FantasyUser getFantasyUser() {
        return fantasyUser;
    }

    public void setFantasyUser(FantasyUser fantasyUser) {
        this.fantasyUser = fantasyUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendedPK != null ? attendedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attended)) {
            return false;
        }
        Attended other = (Attended) object;
        if ((this.attendedPK == null && other.attendedPK != null) || (this.attendedPK != null && !this.attendedPK.equals(other.attendedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.Attended[ attendedPK=" + attendedPK + " ]";
    }
    
}
