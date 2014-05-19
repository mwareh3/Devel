/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByAlbumName", query = "SELECT a FROM Album a WHERE a.albumPK.albumName = :albumName"),
    @NamedQuery(name = "Album.findByBandName", query = "SELECT a FROM Album a WHERE a.albumPK.bandName = :bandName"),
    @NamedQuery(name = "Album.findByReleaseYear", query = "SELECT a FROM Album a WHERE a.releaseYear = :releaseYear"),
    @NamedQuery(name = "Album.findByRecordLabel", query = "SELECT a FROM Album a WHERE a.recordLabel = :recordLabel")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlbumPK albumPK;
    @Column(name = "ALBUM_NAME")
    private String albumName;
    @Column(name = "RELEASE_YEAR")
    @Temporal(TemporalType.DATE)
    private Date releaseYear;
    @Column(name = "RECORD_LABEL")
    private String recordLabel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private Collection<Song> songCollection;
    @JoinColumns({
        @JoinColumn(name = "BAND_NAME", referencedColumnName = "BAND_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "START_DATE", referencedColumnName = "START_DATE")})
    @ManyToOne(optional = false)
    private Band band;

    public Album() {
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    
    public Album(AlbumPK albumPK) {
        this.albumPK = albumPK;
        this.albumName = albumPK.getAlbumName();
    }

    public Album(String albumName, String bandName) {
        this.albumPK = new AlbumPK(albumName, bandName);
        this.albumName = albumName;
    }

    public AlbumPK getAlbumPK() {
        return albumPK;
    }

    public void setAlbumPK(AlbumPK albumPK) {
        this.albumPK = albumPK;
        this.albumName = albumPK.getAlbumName();
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    @XmlTransient
    public Collection<Song> getSongCollection() {
        return songCollection;
    }

    public void setSongCollection(Collection<Song> songCollection) {
        this.songCollection = songCollection;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumPK != null ? albumPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumPK == null && other.albumPK != null) || (this.albumPK != null && !this.albumPK.equals(other.albumPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.Album[ albumPK=" + albumPK + " ]";
    }
    
}
