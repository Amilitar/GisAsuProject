package common.unitofwork;

import data.entities.base.BaseEntity;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */
public abstract class UnitOfWorkBase implements IUnitOfWork, AutoCloseable  {

    protected Boolean isInTransaction;

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
    public abstract <TEntity extends BaseEntity> IRepository<TEntity> getRepository();

    @Override
    public void close() throws Exception {

    }

    Boolean _disposed = false;

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
}
