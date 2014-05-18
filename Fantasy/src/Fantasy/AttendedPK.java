/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Mike
 */
@Embeddable
public class AttendedPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @Column(name = "VENUE_ID")
    private int venueId;

    public AttendedPK() {
    }

    public AttendedPK(String userName, int venueId) {
        this.userName = userName;
        this.venueId = venueId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        hash += (int) venueId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendedPK)) {
            return false;
        }
        AttendedPK other = (AttendedPK) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        if (this.venueId != other.venueId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.AttendedPK[ userName=" + userName + ", venueId=" + venueId + " ]";
    }
    
}
