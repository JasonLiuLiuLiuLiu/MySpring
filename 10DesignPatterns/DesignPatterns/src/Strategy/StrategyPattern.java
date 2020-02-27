package Strategy;

public class StrategyPattern {
    public static void main(String[] args) {
        Context contexta=new Context(new ConcreteStrategyA());
        contexta.Show();

        Context contextb=new Context(new ConcreteStrategyB());
        contextb.Show();
    }
}
