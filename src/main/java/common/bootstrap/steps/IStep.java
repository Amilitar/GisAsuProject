package common.bootstrap.steps;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 * Интерфейс для шагов нашего бутстрапера
 */
public interface IStep {

    /**
     * Приоритет выполнения шага
     * @param priority номер приоритета
     */
    void setPriority(int priority);
}
