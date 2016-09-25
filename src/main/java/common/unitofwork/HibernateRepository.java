package common.unitofwork;

import data.entities.base.BaseEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public class HibernateRepository<TEntity extends BaseEntity> implements IRepository<TEntity> {

    private Session session;

    public HibernateRepository(Session session) {
        this.session = session;
    }

    public void insert(TEntity... entities) {
        for (TEntity entity : entities) {
            session.save(entity);
        }

        session.flush();
    }

    public void update(TEntity... entities) {
        for (TEntity entity : entities) {
            session.update(entity);
        }

        session.flush();
    }

    public void delete(TEntity... entities) {
        for (TEntity entity : entities) {
            session.delete(entity);
        }

        session.flush();
    }

    public List<TEntity> getAll(final Class<TEntity> type) {
        Criteria criteria = session.createCriteria(type);
        return criteria.list();
    }

    public TEntity getById(final Class<TEntity> type, int id) {
        return (TEntity) session.get(type, id);
    }

    //Maybe do it later
    /*public Iterable<TEntity> getBy(Expression<Func<TEntity, bool>> expression)
    {
        return session.Query<TEntity>().Where(expression).ToList();
    } */
}
