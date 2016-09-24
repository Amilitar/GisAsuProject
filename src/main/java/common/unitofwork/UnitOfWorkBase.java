package common.unitofwork;

import entities.base.BaseEntity;
import entities.base.IEntity;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */
public abstract class UnitOfWorkBase implements IUnitOfWork, AutoCloseable  {
    //region Fields

    protected Boolean isInTransaction;

    //endregion //Fields

    //region Implementations

    public void beginTransaction()
    {
        isInTransaction = true;
    }

    public void commitTransaction()
    {
        isInTransaction = false;
    }

    public void rollback()
    {
        isInTransaction = false;
    }

    @Override
    public abstract <TEntity extends BaseEntity> IRepository getRepository();

    @Override
    public void close() throws Exception {

    }

    //endregion //Implementations

    //region IDisposable

    Boolean _disposed = false;

    public void dispose() throws Exception {
        dispose(true);
    }

    protected void dispose(Boolean disposing) throws Exception {
        if (_disposed) return;

        if (disposing)
        {
            if (isInTransaction)
            {
                rollback();
            }
        }

        _disposed = true;
    }

    //endregion //IDisposable
}
