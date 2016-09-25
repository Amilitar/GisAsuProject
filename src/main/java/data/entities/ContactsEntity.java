package data.entities;

import data.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */
@Entity
@Table(name = "Contacts", schema = "")
public class ContactsEntity extends BaseEntity {
    private String firstName;
    private String secondName;
    private String middleName;
    private String address;
    private CitiesEntity city;
    private Set<PhonesEntity> phones;

    @Basic
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "SecondName")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "MiddleName")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "id_city")
    public CitiesEntity getCity() {
        return city;
    }

    public void setCity(CitiesEntity city) {
        this.city = city;
    }

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="id_contact")
    public Set<PhonesEntity> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhonesEntity> phones) {
        this.phones = phones;
    }

}
