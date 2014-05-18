/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "FANTASY_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FantasyUser.findAll", query = "SELECT f FROM FantasyUser f"),
    @NamedQuery(name = "FantasyUser.findByUserName", query = "SELECT f FROM FantasyUser f WHERE f.userName = :userName"),
    @NamedQuery(name = "FantasyUser.findByFname", query = "SELECT f FROM FantasyUser f WHERE f.fname = :fname"),
    @NamedQuery(name = "FantasyUser.findByMinit", query = "SELECT f FROM FantasyUser f WHERE f.minit = :minit"),
    @NamedQuery(name = "FantasyUser.findByLname", query = "SELECT f FROM FantasyUser f WHERE f.lname = :lname"),
    @NamedQuery(name = "FantasyUser.findByBirthDate", query = "SELECT f FROM FantasyUser f WHERE f.birthDate = :birthDate")})
public class FantasyUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "FNAME")
    private String fname;
    @Column(name = "MINIT")
    private String minit;
    @Column(name = "LNAME")
    private String lname;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fantasyUser")
    private Collection<Attended> attendedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fantasyUser")
    private Collection<Followed> followedCollection;

    public FantasyUser() {
    }

    public FantasyUser(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @XmlTransient
    public Collection<Attended> getAttendedCollection() {
        return attendedCollection;
    }

    public void setAttendedCollection(Collection<Attended> attendedCollection) {
        this.attendedCollection = attendedCollection;
    }

    @XmlTransient
    public Collection<Followed> getFollowedCollection() {
        return followedCollection;
    }

    public void setFollowedCollection(Collection<Followed> followedCollection) {
        this.followedCollection = followedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FantasyUser)) {
            return false;
        }
        FantasyUser other = (FantasyUser) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fantasy.FantasyUser[ userName=" + userName + " ]";
    }
    
}
