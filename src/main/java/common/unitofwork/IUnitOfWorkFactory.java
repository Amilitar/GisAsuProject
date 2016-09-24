package common.unitofwork;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public interface IUnitOfWorkFactory {

    IUnitOfWork createUnitOfWork();
}
