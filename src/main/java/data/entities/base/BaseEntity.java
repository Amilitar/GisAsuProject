package data.entities.base;

import javax.persistence.*;

/**
 * Base Entity with standart methods
 * User: nikpodrivnik
 * Date: 18/09/16
 */
@MappedSuperclass
public class BaseEntity implements IEntity {
    protected Long id;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
