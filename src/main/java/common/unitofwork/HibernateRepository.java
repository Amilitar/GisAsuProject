package common.unitofwork;

import data.entities.ContactsEntity;
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

    public TEntity getById(final Class<TEntity> type, Long id) {
        return (TEntity) session.get(type, id);
    }

    @Override
    public List<ContactsEntity> getAllByFilter(Class<TEntity> type, String filterString) {
        //хардкод для поиск
        StringBuilder sql =new StringBuilder();
        String search = "%" + filterString + "%";
        sql.append("SELECT DISTINCT Co.* FROM Contacts AS Co " +
                " JOIN " +
                " Phones AS Ph ON Co.Id = Ph.Id_contact" +
                " WHERE" +
                "  Co.FirstName like '" + search + "' OR " +
                "  Co.MiddleName like '" + search + "' OR " +
                "  Co.SecondName like '" + search + "' OR " +
                "  Co.Address like '" + search + "' OR " +
                "  Ph.Number like '" + search + "' " +
                "");
        List<ContactsEntity> contactsEntity= session.createSQLQuery(sql.toString())
                .addEntity(ContactsEntity.class)
                .list();

        return contactsEntity;
    }

    //Maybe do it later
    /*public Iterable<TEntity> getBy(Expression<Func<TEntity, bool>> expression)
    {
        return session.Query<TEntity>().Where(expression).ToList();
    } */
}
