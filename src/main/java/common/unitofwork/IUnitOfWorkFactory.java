package common.unitofwork;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public interface IUnitOfWorkFactory {
    /**
     * Фабричный метод для создания uow
     * @return
     */
    IUnitOfWork createUnitOfWork();
}
