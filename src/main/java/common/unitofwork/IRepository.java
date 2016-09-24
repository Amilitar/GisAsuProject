package common.unitofwork;

import entities.base.BaseEntity;
import entities.base.IEntity;

import java.util.List;

/**
 * User: nikpodrivnik
 * Date: 18/09/16
 */
public interface IRepository<TEntity extends IEntity> {
    /**
     * Добавить список объектов
     * @param entities
     */
    void insert(TEntity... entities);

    /**
     * Обновить объект
     * @param entities
     */
    void update(TEntity... entities);

    /**
     * Удалить объект
     * @param entities
     */
    void delete(TEntity... entities);

    /**
     * Вернуть все объекты
     * @param type generic тип для работы с сущностями
     * @return Перечисление сущностей
     */
    List<TEntity> getAll(final Class<TEntity> type);

    /**
     * Возвращает объект по его идентификатору
     * @param type generic тип для работы с сущностями
     * @param id Идентификатор объекта
     * @return Найденый объект или null
     */
    TEntity getById(final Class<TEntity> type, int id);

    /**
     * Вернуть все объекты
     * @return Перечисление сущностей
     */
    //Iterable<TEntity> GetBy(Expression<Func<TEntity, Boolean>> expression);
}
