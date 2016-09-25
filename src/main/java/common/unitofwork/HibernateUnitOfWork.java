package common.unitofwork;

import data.entities.base.BaseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public class HibernateUnitOfWork extends UnitOfWorkBase {

    /**
     * Сессию не выбрасываем наружу
     */
    private final Session session;

    private Transaction transaction;

    public HibernateUnitOfWork(Session session)
    {
        this.session = session;
    }

    @Override
    public void beginTransaction()
    {
        super.beginTransaction();
        if (!session.isConnected())
        {
            //session.connection.Open();
        }
        transaction = session.beginTransaction();
    }

    @Override
    public void commitTransaction()
    {
        super.commitTransaction();
        transaction.commit();
    }

    @Override
    public void rollback()
    {
        if (transaction == null)
        {
            return;
        }

        super.rollback();
        transaction.rollback();
    }

    @Override
    public <TEntity extends BaseEntity>IRepository<TEntity> getRepository() {
        return new HibernateRepository<>(session);
    }

    Boolean disposed = false;

    @Override
    protected void dispose(Boolean disposing) throws Exception {
        if (disposed)
            return;

        if (disposing)
        {
            if (isInTransaction)
            {
                rollback();
            }

            close();
        }

        disposed = true;
        super.dispose(disposing);
    }

    @Override
    public void close() throws Exception {
        if (!session.isConnected()) return;

        session.disconnect();
    }
}
