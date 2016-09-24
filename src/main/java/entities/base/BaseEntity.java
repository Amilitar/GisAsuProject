package entities.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base Entity with standart methods
 * User: nikpodrivnik
 * Date: 18/09/16
 */
@MappedSuperclass
public class BaseEntity implements IEntity {
    protected int id;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
