package Decorator;

public abstract class Decorator implements Component {

    protected Component component;

    public void  setComponent(Component component)
    {
        this.component=component;
    }

   public abstract void operation();
}
