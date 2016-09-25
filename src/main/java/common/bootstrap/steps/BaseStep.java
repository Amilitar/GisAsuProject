package common.bootstrap.steps;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 */
public abstract class BaseStep implements IStep {
    protected int priority;

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public abstract void doStep();
}
