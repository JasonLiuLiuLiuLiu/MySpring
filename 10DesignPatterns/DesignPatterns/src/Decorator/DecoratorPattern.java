package Decorator;

public class DecoratorPattern {
    public static void main(String[] args) {
        Decorator d1=new ConcreteDecoratorA();
        d1.setComponent(new ConcreteComponent());

       Decorator d2=new ConcreteDecoratorB();
       d2.setComponent(d1);

       d2.operation();
    }
}
