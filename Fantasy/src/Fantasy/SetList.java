/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "SET_LIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SetList.findAll", query = "SELECT s FROM SetList s"),
    @NamedQuery(name = "SetList.findByBandName", query = "SELECT s FROM SetList s WHERE s.setListPK.bandName = :bandName"),
    @NamedQuery(name = "SetList.findByEventDate", query = "SELECT s FROM SetList s WHERE s.setListPK.eventDate = :eventDate"),
    @NamedQuery(name = "SetList.findBySongName", query = "SELECT s FROM SetList s WHERE s.songName = :songName"),
    @NamedQuery(name = "SetList.findByWrittenBy", query = "SELECT s FROM SetList s WHERE s.writtenBy = :writtenBy")})
public class SetList implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SetListPK setListPK;
    @Column(name = "SONG_NAME")
    private String songName;
    @Column(name = "WRITTEN_BY")
    private String writtenBy;
    @JoinColumns({
        @JoinColumn(name = "BAND_NAME", referencedColumnName = "BAND_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "VENUE_ID", referencedColumnName = "VENUE_ID"),
        @JoinColumn(name = "EVENT_DATE", referencedColumnName = "EVENT_DATE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Performance performance;

    public SetList() {
    }

    public SetList(SetListPK setListPK) {
        this.setListPK = setListPK;
    }

    public SetList(String bandName, Date eventDate) {
        this.setListPK = new SetListPK(bandName, eventDate);
    }

    public SetListPK getSetListPK() {
        return setListPK;
    }

    public void setSetListPK(SetListPK setListPK) {
        this.setListPK = setListPK;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (setListPK != null ? setListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SetList)) {
            return false;
        }
        SetList other = (SetList) object;
        if ((this.setListPK == null && other.setListPK != null) || (this.setListPK != null && !this.setListPK.equals(other.setListPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.SetList[ setListPK=" + setListPK + " ]";
    }
    
}
