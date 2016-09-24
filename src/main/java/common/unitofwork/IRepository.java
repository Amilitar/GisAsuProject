package common.unitofwork;

import entities.base.BaseEntity;
import entities.base.IEntity;

import java.util.List;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */
public interface IRepository<TEntity extends IEntity> {
    /// <summary>
    /// Добавить список объектов
    /// </summary>
    /// <param name="entities"></param>
    void insert(TEntity... entities);

    /// <summary>
    /// Обновить объект
    /// </summary>
    /// <param name="entities"></param>
    void update(TEntity... entities);

    /// <summary>
    /// Удалить объект
    /// </summary>
    /// <param name="entities"></param>
    void delete(TEntity... entities);

    /// <summary>
    /// Вернуть все объекты
    /// </summary>
    /// <returns>Перечисление сущностей</returns>
    List<TEntity> getAll(final Class<TEntity> type);

    /// <summary>
    /// Возвращает объект по его идентификатору
    /// </summary>
    /// <param name="id">Идентификатор объекта</param>
    /// <returns>Найденый объект или null</returns>
    TEntity getById(int id);

    /// <summary>
    /// Вернуть все объекты
    /// </summary>
    /// <returns>Перечисление сущностей</returns>
    //Iterable<TEntity> GetBy(Expression<Func<TEntity, Boolean>> expression);
}
