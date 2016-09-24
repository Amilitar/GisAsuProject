package common.unitofwork;

import entities.base.BaseEntity;
import entities.base.IEntity;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */
public interface IUnitOfWork {
    /// <summary>
    /// Реализация инициализации транзакций
    /// </summary>
    void beginTransaction();

    /// <summary>
    /// Фиксация транзакций
    /// </summary>
    void commitTransaction();

    /// <summary>
    /// Откат транзакций
    /// </summary>
    void rollback();

    /// <summary>
    /// Получение репозитория для работы с сущностями
    /// </summary>
    /// <typeparam name="TEntity">Тип сущности</typeparam>
    /// <returns>Репозиторий для работы с заданной сущностью</returns>
    <TEntity extends BaseEntity> IRepository<TEntity> getRepository();
}
