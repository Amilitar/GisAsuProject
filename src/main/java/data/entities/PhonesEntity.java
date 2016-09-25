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
    private ContactsEntity contact;

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

    @ManyToOne
    public ContactsEntity getContact() {
        return contact;
    }

    public void setContact(ContactsEntity contact) {
        this.contact = contact;
    }
}
