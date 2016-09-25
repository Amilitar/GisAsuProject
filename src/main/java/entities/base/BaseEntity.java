package entities.base;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
