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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "FANTASY_SETLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FantasySetlist.findAll", query = "SELECT f FROM FantasySetlist f"),
    @NamedQuery(name = "FantasySetlist.findByBandName", query = "SELECT f FROM FantasySetlist f WHERE f.fantasySetlistPK.bandName = :bandName"),
    @NamedQuery(name = "FantasySetlist.findByUserName", query = "SELECT f FROM FantasySetlist f WHERE f.fantasySetlistPK.userName = :userName"),
    @NamedQuery(name = "FantasySetlist.findByFantasySetListId", query = "SELECT f FROM FantasySetlist f WHERE f.fantasySetListId = :fantasySetListId"),
    @NamedQuery(name = "FantasySetlist.findByWrittenBy", query = "SELECT f FROM FantasySetlist f WHERE f.writtenBy = :writtenBy")})
public class FantasySetlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FantasySetlistPK fantasySetlistPK;
    @Column(name = "FANTASY_SET_LIST_ID")
    private Integer fantasySetListId;
    @Column(name = "WRITTEN_BY")
    private String writtenBy;
    @JoinColumns({
        @JoinColumn(name = "USER_NAME", referencedColumnName = "USER_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "BAND_NAME", referencedColumnName = "BAND_NAME", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Followed followed;
    @JoinColumns({
        @JoinColumn(name = "BAND_NAME", referencedColumnName = "BAND_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "SONG_NAME", referencedColumnName = "SONG_NAME"),
        @JoinColumn(name = "ALBUM_NAME", referencedColumnName = "ALBUM_NAME")})
    @ManyToOne(optional = false)
    private Song song;

    public FantasySetlist() {
    }

    public FantasySetlist(FantasySetlistPK fantasySetlistPK) {
        this.fantasySetlistPK = fantasySetlistPK;
    }

    public FantasySetlist(String bandName, String userName) {
        this.fantasySetlistPK = new FantasySetlistPK(bandName, userName);
    }

    public FantasySetlistPK getFantasySetlistPK() {
        return fantasySetlistPK;
    }

    public void setFantasySetlistPK(FantasySetlistPK fantasySetlistPK) {
        this.fantasySetlistPK = fantasySetlistPK;
    }

    public Integer getFantasySetListId() {
        return fantasySetListId;
    }

    public void setFantasySetListId(Integer fantasySetListId) {
        this.fantasySetListId = fantasySetListId;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    public Followed getFollowed() {
        return followed;
    }

    public void setFollowed(Followed followed) {
        this.followed = followed;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fantasySetlistPK != null ? fantasySetlistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FantasySetlist)) {
            return false;
        }
        FantasySetlist other = (FantasySetlist) object;
        if ((this.fantasySetlistPK == null && other.fantasySetlistPK != null) || (this.fantasySetlistPK != null && !this.fantasySetlistPK.equals(other.fantasySetlistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.FantasySetlist[ fantasySetlistPK=" + fantasySetlistPK + " ]";
    }
    
}
