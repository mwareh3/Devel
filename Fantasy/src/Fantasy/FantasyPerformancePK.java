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
public class FantasyPerformancePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "BAND_NAME")
    private String bandName;
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;

    public FantasyPerformancePK() {
    }

    public FantasyPerformancePK(String bandName, String userName) {
        this.bandName = bandName;
        this.userName = userName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bandName != null ? bandName.hashCode() : 0);
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FantasyPerformancePK)) {
            return false;
        }
        FantasyPerformancePK other = (FantasyPerformancePK) object;
        if ((this.bandName == null && other.bandName != null) || (this.bandName != null && !this.bandName.equals(other.bandName))) {
            return false;
        }
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.FantasyPerformancePK[ bandName=" + bandName + ", userName=" + userName + " ]";
    }
    
}
