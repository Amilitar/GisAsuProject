package common.unitofwork;

import entities.base.BaseEntity;
import entities.base.IEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public class HibernateUnitOfWork extends UnitOfWorkBase {
    
    //region Fields
    /// <summary>
    /// Сессию не выбрасываем наружу
    /// </summary>
    public final Session session;

    private Transaction transaction;

    //endregion //Fields

    //region Constructors

    public HibernateUnitOfWork(Session session)
    {
        this.session = session;
    }

    //endregion //Constructors

    //region Overrides
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
    public <TEntity extends BaseEntity>IRepository getRepository() {
        return new HibernateRepository<TEntity>(session);
    }

    //endregion //Overrides

    //region IDisposable

    Boolean disposed = false;

    // Protected implementation of Dispose pattern.
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

    //endregion //IDisposable

    //region Methods
    @Override
    public void close() throws Exception {
        if (!session.isConnected()) return;

        session.disconnect();
    }

    public Connection getDbConnection()
    {
        /*Connection connection = session.getconnection;
        if (connection.State != ConnectionState.Open)
        {
            connection.Open();
        }
          */
        return null;//(SqlConnection)session.Connection;
    }

    //endregion //Methods
}
