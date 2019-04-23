package eng.edu.alexu.csd.datastructure.stack.cs49;

public interface IExpressionEvaluator {

    public String infixToPostfix(String expression);
    public int evaluate(String expression);
}
