package common.unitofwork;

import entities.base.BaseEntity;
import entities.base.IEntity;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */
public interface IUnitOfWork {

    /**
     *  Реализация инициализации транзакций
     */
    void beginTransaction();

    /**
     * Фиксация транзакций
     */
    void commitTransaction();

    /**
     * Откат транзакций
     */
    void rollback();

    /**
     * Получение репозитория для работы с сущностями
     * @param <TEntity> Тип сущности
     * @return Репозиторий для работы с заданной сущностью
     */
    <TEntity extends BaseEntity> IRepository<TEntity> getRepository();
}
