package common.unitofwork;

import entities.base.BaseEntity;
import entities.base.IEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public class HibernateRepository<TEntity extends BaseEntity> implements IRepository<TEntity> {
    //region Fields

    private Session session;

    //endregion //Fields

    //region Constructors

    public HibernateRepository(Session session) {
        this.session = session;
    }

    //endregion

    //region Implementations

    //region Insert

    public void insert(TEntity... entities) {
        for (TEntity entity : entities) {
            session.save(entity);
        }

        session.flush();
    }

    //endregion //Insert

    //region Update

    public void update(TEntity... entities) {
        for (TEntity entity : entities) {
            session.update(entity);
        }

        session.flush();
    }

    //endregion //Update

    //region Delete

    public void delete(TEntity... entities) {
        for (TEntity entity : entities) {
            session.delete(entity);
        }

        session.flush();
    }

    //endregion //Delete

    public List<TEntity> getAll(final Class<TEntity> type) {
        Criteria criteria = session.createCriteria(type);
        return criteria.list();
    }

    public TEntity getById(int id) {
        return null;//return session.createQuery<TEntity>(id);
    }

    //Maybe do it later
    /*public Iterable<TEntity> getBy(Expression<Func<TEntity, bool>> expression)
    {
        return session.Query<TEntity>().Where(expression).ToList();
    } */

    //endregion
}
