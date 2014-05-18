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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "BAND_MEMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BandMember.findAll", query = "SELECT b FROM BandMember b"),
    @NamedQuery(name = "BandMember.findByBandName", query = "SELECT b FROM BandMember b WHERE b.bandMemberPK.bandName = :bandName"),
    @NamedQuery(name = "BandMember.findByFname", query = "SELECT b FROM BandMember b WHERE b.bandMemberPK.fname = :fname"),
    @NamedQuery(name = "BandMember.findByMinit", query = "SELECT b FROM BandMember b WHERE b.minit = :minit"),
    @NamedQuery(name = "BandMember.findByLname", query = "SELECT b FROM BandMember b WHERE b.bandMemberPK.lname = :lname"),
    @NamedQuery(name = "BandMember.findByPositionInBand", query = "SELECT b FROM BandMember b WHERE b.positionInBand = :positionInBand"),
    @NamedQuery(name = "BandMember.findByBandStartDate", query = "SELECT b FROM BandMember b WHERE b.bandStartDate = :bandStartDate"),
    @NamedQuery(name = "BandMember.findByEndDate", query = "SELECT b FROM BandMember b WHERE b.endDate = :endDate")})
public class BandMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BandMemberPK bandMemberPK;
    @Column(name = "MINIT")
    private String minit;
    @Column(name = "POSITION_IN_BAND")
    private String positionInBand;
    @Column(name = "BAND_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date bandStartDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumns({
        @JoinColumn(name = "BAND_NAME", referencedColumnName = "BAND_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "START_DATE", referencedColumnName = "START_DATE")})
    @ManyToOne(optional = false)
    private Band band;

    public BandMember() {
    }

    public BandMember(BandMemberPK bandMemberPK) {
        this.bandMemberPK = bandMemberPK;
    }

    public BandMember(String bandName, String fname, String lname) {
        this.bandMemberPK = new BandMemberPK(bandName, fname, lname);
    }

    public BandMemberPK getBandMemberPK() {
        return bandMemberPK;
    }

    public void setBandMemberPK(BandMemberPK bandMemberPK) {
        this.bandMemberPK = bandMemberPK;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getPositionInBand() {
        return positionInBand;
    }

    public void setPositionInBand(String positionInBand) {
        this.positionInBand = positionInBand;
    }

    public Date getBandStartDate() {
        return bandStartDate;
    }

    public void setBandStartDate(Date bandStartDate) {
        this.bandStartDate = bandStartDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        hash += (bandMemberPK != null ? bandMemberPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BandMember)) {
            return false;
        }
        BandMember other = (BandMember) object;
        if ((this.bandMemberPK == null && other.bandMemberPK != null) || (this.bandMemberPK != null && !this.bandMemberPK.equals(other.bandMemberPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.BandMember[ bandMemberPK=" + bandMemberPK + " ]";
    }
    
}
