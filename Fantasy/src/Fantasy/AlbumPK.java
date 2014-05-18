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
public class AlbumPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ALBUM_NAME")
    private String albumName;
    @Basic(optional = false)
    @Column(name = "BAND_NAME")
    private String bandName;

    public AlbumPK() {
    }

    public AlbumPK(String albumName, String bandName) {
        this.albumName = albumName;
        this.bandName = bandName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
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
        hash += (albumName != null ? albumName.hashCode() : 0);
        hash += (bandName != null ? bandName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlbumPK)) {
            return false;
        }
        AlbumPK other = (AlbumPK) object;
        if ((this.albumName == null && other.albumName != null) || (this.albumName != null && !this.albumName.equals(other.albumName))) {
            return false;
        }
        if ((this.bandName == null && other.bandName != null) || (this.bandName != null && !this.bandName.equals(other.bandName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.AlbumPK[ albumName=" + albumName + ", bandName=" + bandName + " ]";
    }
    
}
