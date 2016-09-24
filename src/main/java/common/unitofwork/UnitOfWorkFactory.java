package common.unitofwork;

import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public class UnitOfWorkFactory implements IUnitOfWorkFactory {

    private SessionFactory sessionFactory;

    public UnitOfWorkFactory() {
    }

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    public HibernateUnitOfWork createUnitOfWork() {
        return
                new HibernateUnitOfWork(setupSession());
    }

    /**
     * Настройка новой сессии
     *
     * @return
     */
    private Session setupSession() {
        Session session = this.sessionFactory.openSession();
        session.setFlushMode(FlushMode.COMMIT);
        session.setCacheMode(CacheMode.REFRESH);

        return session;
    }
}
