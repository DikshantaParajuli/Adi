
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "company", catalog = "adi", schema = "")
@NamedQueries({
    @NamedQuery(name = "Company_1.findAll", query = "SELECT c FROM Company_1 c"),
    @NamedQuery(name = "Company_1.findById", query = "SELECT c FROM Company_1 c WHERE c.id = :id"),
    @NamedQuery(name = "Company_1.findByCompanyName", query = "SELECT c FROM Company_1 c WHERE "
            + "c.companyName = :companyName"),
    @NamedQuery(name = "Company_1.findByCompanyAddress", query = "SELECT c FROM Company_1 c WHERE "
            + "c.companyAddress = :companyAddress"),
    @NamedQuery(name = "Company_1.findByContact", query = "SELECT c FROM Company_1 c WHERE c.contact "
            + "= :contact")})
public class Company_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CompanyName")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "CompanyAddress")
    private String companyAddress;
    @Basic(optional = false)
    @Column(name = "Contact")
    private String contact;

    public Company_1() {
    }

    public Company_1(Integer id) {
        this.id = id;
    }

    public Company_1(Integer id, String companyName, String companyAddress, String contact) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        String oldCompanyName = this.companyName;
        this.companyName = companyName;
        changeSupport.firePropertyChange("companyName", oldCompanyName, companyName);
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        String oldCompanyAddress = this.companyAddress;
        this.companyAddress = companyAddress;
        changeSupport.firePropertyChange("companyAddress", oldCompanyAddress, companyAddress);
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        String oldContact = this.contact;
        this.contact = contact;
        changeSupport.firePropertyChange("contact", oldContact, contact);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company_1)) {
            return false;
        }
        Company_1 other = (Company_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Company_1[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
