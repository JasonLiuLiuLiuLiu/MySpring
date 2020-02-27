package Decorator;

public class ConcreteDecoratorB extends Decorator {
    @Override
    public void operation() {
        System.out.println("具体操作对象B");
        component.operation();
    }
}
