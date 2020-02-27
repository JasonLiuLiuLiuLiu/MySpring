package Strategy;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy)
    {
        this.strategy=strategy;
    }

    public void Show(){
        strategy.Execute();
    }
}
