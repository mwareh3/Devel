/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "SONG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Song.findAll", query = "SELECT s FROM Song s"),
    @NamedQuery(name = "Song.findByBandName", query = "SELECT s FROM Song s WHERE s.songPK.bandName = :bandName"),
    @NamedQuery(name = "Song.findBySongName", query = "SELECT s FROM Song s WHERE s.songPK.songName = :songName"),
    @NamedQuery(name = "Song.findByAlbumName", query = "SELECT s FROM Song s WHERE s.songPK.albumName = :albumName"),
    @NamedQuery(name = "Song.findByTrackNum", query = "SELECT s FROM Song s WHERE s.trackNum = :trackNum")})
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SongPK songPK;
    @Column(name = "TRACK_NUM")
    private Integer trackNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "song")
    private Collection<FantasySetlist> fantasySetlistCollection;
    @JoinColumns({
        @JoinColumn(name = "ALBUM_NAME", referencedColumnName = "ALBUM_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "BAND_NAME", referencedColumnName = "BAND_NAME", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Album album;

    public Song() {
    }

    public Song(SongPK songPK) {
        this.songPK = songPK;
    }

    public Song(String bandName, String songName, String albumName) {
        this.songPK = new SongPK(bandName, songName, albumName);
    }

    public SongPK getSongPK() {
        return songPK;
    }

    public void setSongPK(SongPK songPK) {
        this.songPK = songPK;
    }

    public Integer getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(Integer trackNum) {
        this.trackNum = trackNum;
    }

    @XmlTransient
    public Collection<FantasySetlist> getFantasySetlistCollection() {
        return fantasySetlistCollection;
    }

    public void setFantasySetlistCollection(Collection<FantasySetlist> fantasySetlistCollection) {
        this.fantasySetlistCollection = fantasySetlistCollection;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (songPK != null ? songPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.songPK == null && other.songPK != null) || (this.songPK != null && !this.songPK.equals(other.songPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.Song[ songPK=" + songPK + " ]";
    }
    
}
