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
    private Boolean isMain;

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
    public PhoneTypeEntity getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneTypeEntity phoneType) {
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

    @Basic
    @Column(name = "isMain")
    public Boolean getIsMain() {
        return isMain;
    }

    public void setIsMain(Boolean isMain) {
        this.isMain = isMain;
    }
}
