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
public class SongPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "BAND_NAME")
    private String bandName;
    @Basic(optional = false)
    @Column(name = "SONG_NAME")
    private String songName;
    @Basic(optional = false)
    @Column(name = "ALBUM_NAME")
    private String albumName;

    public SongPK() {
    }

    public SongPK(String bandName, String songName, String albumName) {
        this.bandName = bandName;
        this.songName = songName;
        this.albumName = albumName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bandName != null ? bandName.hashCode() : 0);
        hash += (songName != null ? songName.hashCode() : 0);
        hash += (albumName != null ? albumName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SongPK)) {
            return false;
        }
        SongPK other = (SongPK) object;
        if ((this.bandName == null && other.bandName != null) || (this.bandName != null && !this.bandName.equals(other.bandName))) {
            return false;
        }
        if ((this.songName == null && other.songName != null) || (this.songName != null && !this.songName.equals(other.songName))) {
            return false;
        }
        if ((this.albumName == null && other.albumName != null) || (this.albumName != null && !this.albumName.equals(other.albumName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.SongPK[ bandName=" + bandName + ", songName=" + songName + ", albumName=" + albumName + " ]";
    }
    
}
