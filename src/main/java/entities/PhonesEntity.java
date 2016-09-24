package entities;

import entities.base.BaseEntity;

import javax.persistence.*;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */

@Entity
@Table(name = "Phones", schema = "", catalog = "gisasu")
public class PhonesEntity extends BaseEntity {
    private String number;
    private Integer idPhoneType;
    private Integer idContact;

    @Basic
    @Column(name = "Number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "Id_phone_type")
    public Integer getIdPhoneType() {
        return idPhoneType;
    }

    public void setIdPhoneType(Integer idPhoneType) {
        this.idPhoneType = idPhoneType;
    }

    @Basic
    @Column(name = "Id_contact")
    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhonesEntity that = (PhonesEntity) o;

        if (id != that.id) return false;
        if (idContact != null ? !idContact.equals(that.idContact) : that.idContact != null) return false;
        if (idPhoneType != null ? !idPhoneType.equals(that.idPhoneType) : that.idPhoneType != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (idPhoneType != null ? idPhoneType.hashCode() : 0);
        result = 31 * result + (idContact != null ? idContact.hashCode() : 0);
        return result;
    }
}
