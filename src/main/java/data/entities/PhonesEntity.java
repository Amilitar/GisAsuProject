package data.entities;

import data.entities.base.BaseEntity;

import javax.persistence.*;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */

@Entity
@Table(name = "Phones", schema = "")
public class PhonesEntity extends BaseEntity {
    private String number;
    private PhoneTypeEntity phoneType;
    private Integer idContact;

    @Basic
    @Column(name = "Number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne
    @JoinColumn(name = "id_phone_type")
    public PhoneTypeEntity getIdPhoneType() {
        return phoneType;
    }

    public void setIdPhoneType(PhoneTypeEntity phoneType) {
        this.phoneType = phoneType;
    }

    @Basic
    @Column(name = "id_contact")
    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }
}
