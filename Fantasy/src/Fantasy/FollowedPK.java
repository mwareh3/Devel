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
public class FollowedPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @Column(name = "BAND_NAME")
    private String bandName;

    public FollowedPK() {
    }

    public FollowedPK(String userName, String bandName) {
        this.userName = userName;
        this.bandName = bandName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        hash += (bandName != null ? bandName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowedPK)) {
            return false;
        }
        FollowedPK other = (FollowedPK) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        if ((this.bandName == null && other.bandName != null) || (this.bandName != null && !this.bandName.equals(other.bandName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.FollowedPK[ userName=" + userName + ", bandName=" + bandName + " ]";
    }
    
}
