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
public class BandMemberPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "BAND_NAME")
    private String bandName;
    @Basic(optional = false)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @Column(name = "LNAME")
    private String lname;

    public BandMemberPK() {
    }

    public BandMemberPK(String bandName, String fname, String lname) {
        this.bandName = bandName;
        this.fname = fname;
        this.lname = lname;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bandName != null ? bandName.hashCode() : 0);
        hash += (fname != null ? fname.hashCode() : 0);
        hash += (lname != null ? lname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BandMemberPK)) {
            return false;
        }
        BandMemberPK other = (BandMemberPK) object;
        if ((this.bandName == null && other.bandName != null) || (this.bandName != null && !this.bandName.equals(other.bandName))) {
            return false;
        }
        if ((this.fname == null && other.fname != null) || (this.fname != null && !this.fname.equals(other.fname))) {
            return false;
        }
        if ((this.lname == null && other.lname != null) || (this.lname != null && !this.lname.equals(other.lname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.BandMemberPK[ bandName=" + bandName + ", fname=" + fname + ", lname=" + lname + " ]";
    }
    
}
