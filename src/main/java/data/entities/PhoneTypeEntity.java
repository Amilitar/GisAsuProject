package data.entities;

import data.entities.base.BaseEntity;

import javax.persistence.*;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */

@Entity
@Table(name = "PhoneType", schema = "")
public class PhoneTypeEntity extends BaseEntity {
    private String name;

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
