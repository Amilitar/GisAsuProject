package entities;

import entities.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 */
@Entity
@Table(name = "VersionInfo", schema = "")
public class VersionInfo extends BaseEntity {
    private boolean testDataLoaded;

    @Basic
    @Column(name = "TestDataLoaded")
    public boolean getName() {
        return testDataLoaded;
    }

    public void setName(boolean name) {
        this.testDataLoaded = name;
    }
}
