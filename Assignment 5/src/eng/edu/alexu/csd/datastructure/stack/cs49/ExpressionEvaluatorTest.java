package eng.edu.alexu.csd.datastructure.stack.cs49;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    @org.junit.jupiter.api.Test
    void infixToPostfix() {
        ExpressionEvaluator x = new ExpressionEvaluator();
        assertEquals("74 2 + 4 *",x.infixToPostfix("17 10 + 3 * 9 /"));
    }

    @org.junit.jupiter.api.Test
    void evaluate() {
        ExpressionEvaluator x = new ExpressionEvaluator();
        assertEquals(48,x.evaluate("5 3 + 8 2 - *"));
    }
}