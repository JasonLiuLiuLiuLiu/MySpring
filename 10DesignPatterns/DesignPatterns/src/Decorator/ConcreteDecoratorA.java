package Decorator;

public class ConcreteDecoratorA extends Decorator {
    @Override
    public void operation() {
        System.out.println("具体操作对象A");
        component.operation();
    }
}
