<<<<<<< HEAD
package eng.edu.alexu.csd.datastructure.stack.cs49;

public class ExpressionEvaluator implements IExpressionEvaluator {
    /**
     *
     * @param x operators x
     * @param y operators y
     * @return true if x is of higher priority than y
     */
    private boolean priorities(char x, char y)
    {
        // Evaluates the priorities of operations by comparing.
        int pres = x == '*' || x == '/' ? 2 : 1;
        int pres2 = y == '*' || y == '/' ? 2 : 1;
        if(y == '(')
            pres2 = -1;
        return pres > pres2;
    }

    /**
     * @param expression the infix expression
     * @return postfix expression
     */
    public String infixToPostfix(String expression) {
        String postfix = "";
        // stack to store operators
        /**
         * Store operators in the operators Stack
         * add numbers to postfix expression(string)
         * push operator to stack if it is of higher priority than top of stack
         * pop the stack until the top of stack is of lower priority than current operator otherwise
         * if opening bracket is found push it to stack
         * if closing bracket is found pop the stack until the opening bracket is found and popped
         */
        Stack operators = new Stack();
        for(int i = 0; i < expression.length(); i++)
        {
            char x = expression.charAt(i);
            // add to expression if number
            if(x >= '0' && x <= '9')
            {
                postfix += x;
            }
            else if(x == ' ')
                // add space if whitespace
                postfix += ' ';
            else if(x == '*' || x == '+' || x == '-' || x == '/')
            {
                if(operators.isEmpty())
                //if stack is empty, push the operator
                {
                    operators.push(x);
                    continue;
                }
                if(priorities(x,(char)operators.peek()))
                //if the operator is of higher priority than top of stack
                {
                    operators.push(x);
                }
                else if((char)operators.peek() != '(')
                {
                    postfix += " " + (char)operators.pop();
                    //else add it to the postfix
                    i--;
                    continue;
                }
            }
            //if bracket push to stack
            else if(x == '(')
            {
                operators.push(x);
            }
            //if closing bracket pop stack until the opening one is found
            else if (x == ')')
            {
                while(!operators.isEmpty() && (char)operators.peek() != '(')
                    postfix += " " + (char)operators.pop();
                if (!operators.isEmpty() && (char)operators.peek() != '(')
                    //if not found, the expression is invalid
                    throw new RuntimeException("Invalid Expression");
                else
                    operators.pop();
            }
            else
                //invalid expression if the character is invalid
                throw new RuntimeException("Invalid Expression");
        }
        /**
         * Pop the stack into the PostFix expression
         */
        while(!operators.isEmpty())//empty the stack
        {
            if((char)operators.peek() == '(')
                //unclosed brackets = invalid expression
                throw new RuntimeException("Unbalanced Expression");
            postfix += " " + (char)operators.pop();
        }
        //replace excess whitespace with a single one
        postfix = postfix.replaceAll("  "," ");
        return postfix;
    }

    /**
     * @param expression Postfix expression
     * @return the result of processing the expression
     */
    public int evaluate(String expression) {
        /**
         * Store numbers in result stack
         * split the expression to obtain the integer values, store in an array values[]
         */
        Stack result = new Stack();
        //split the expression to get numbers
        String[] parts = expression.split(" ");
        //array to store numbers in the expression as integers
        int[] values = new int[parts.length];
        int j = 0;
        for(int i = 0 ;i < parts.length;i++)
        {
            try
            {
                //change from string to integer
                values[j++] = Integer.parseInt(parts[i]);
            }catch(NumberFormatException e){j--;continue;}
        }
        /**
         * Loop through expression
         * pop 2 operands and perform the operation if an operator is found
         * push the result to the stack
         */
        int k = 0;
        for(int i = 0;i < expression.length();i++) //loop through expression
        {
            char x = expression.charAt(i);
            if(x >= '0' && x <= '9') {
                if (expression.charAt(i + 1) < '0' || expression.charAt(i + 1) > '9')
                    result.push((float)values[k++]);//push if number
            }
            else if(x == '*' || x == '+' || x == '-' || x == '/')
            {
                float done = 0;//result of operation
                if(result.isEmpty())
                    throw new RuntimeException("Invalid expression");
                float op2 = (float)result.pop();
                if(result.isEmpty())
                    throw new RuntimeException("Invalid expression");
                float op1 = (float)result.pop();//pop the operands from the stack
                switch(x)//perform the operation
                {
                    case '*': done = op1 * op2; break;
                    case '+': done = op1 + op2; break;
                    case '-': done = op1 - op2; break;
                    case '/': done = op1 / op2; break;
                }
                //add result to stack
                result.push(done);
            }
            else if(x != ' ')
                throw new RuntimeException("Invalid expression");//invalid expression if invalid input
        }
        if(result.size() != 1)
            throw new RuntimeException("Unbalanced expression");//more than 2 numbers remain in the stack meaning an invalid expression
        return Math.round((float)result.pop());//return the result(last member of stack)
    }
}
=======
package eng.edu.alexu.csd.datastructure.stack.cs49;

public class ExpressionEvaluator implements IExpressionEvaluator {
    /**
     *
     * @param x operators x
     * @param y operators y
     * @return true if x is of higher priority than y
     */
    private boolean priorities(char x, char y)
    {
        // Evaluates the priorities of operations by comparing.
        int pres = x == '*' || x == '/' ? 2 : 1;
        int pres2 = y == '*' || y == '/' ? 2 : 1;
        if(y == '(')
            pres2 = -1;
        return pres > pres2;
    }

    /**
     * @param expression the infix expression
     * @return postfix expression
     */
    public String infixToPostfix(String expression) {
        String postfix = "";
        // stack to store operators
        /**
         * Store operators in the operators Stack
         * add numbers to postfix expression(string)
         * push operator to stack if it is of higher priority than top of stack
         * pop the stack until the top of stack is of lower priority than current operator otherwise
         * if opening bracket is found push it to stack
         * if closing bracket is found pop the stack until the opening bracket is found and popped
         */
        Stack operators = new Stack();
        for(int i = 0; i < expression.length(); i++)
        {
            char x = expression.charAt(i);
            // add to expression if number
            if(x >= '0' && x <= '9')
            {
                postfix += x;
            }
            else if(x == ' ')
                // add space if whitespace
                postfix += ' ';
            else if(x == '*' || x == '+' || x == '-' || x == '/')
            {
                if(operators.isEmpty())
                    //if stack is empty, push the operator
                {
                    operators.push(x);
                    continue;
                }
                if(priorities(x,(char)operators.peek()))
                    //if the operator is of higher priority than top of stack
                {
                    operators.push(x);
                }
                else if((char)operators.peek() != '(')
                {
                    postfix += " " + (char)operators.pop();
                    //else add it to the postfix
                    i--;
                    continue;
                }
            }
            //if bracket push to stack
            else if(x == '(')
            {
                operators.push(x);
            }
            //if closing bracket pop stack until the opening one is found
            else if (x == ')')
            {
                while(!operators.isEmpty() && (char)operators.peek() != '(')
                    postfix += " " + (char)operators.pop();
                if (!operators.isEmpty() && (char)operators.peek() != '(')
                    //if not found, the expression is invalid
                    throw new RuntimeException("Invalid Expression");
                else
                    operators.pop();
            }
            else
                //invalid expression if the character is invalid
                throw new RuntimeException("Invalid Expression");
        }
        /**
         * Pop the stack into the PostFix expression
         */
        while(!operators.isEmpty())//empty the stack
        {
            if((char)operators.peek() == '(')
                //unclosed brackets = invalid expression
                throw new RuntimeException("Unbalanced Expression");
            postfix += " " + (char)operators.pop();
        }
        //replace excess whitespace with a single one
        postfix = postfix.replaceAll("  "," ");
        return postfix;
    }

    /**
     * @param expression Postfix expression
     * @return the result of processing the expression
     */
    public int evaluate(String expression) {
        /**
         * Store numbers in result stack
         * split the expression to obtain the integer values, store in an array values[]
         */
        Stack result = new Stack();
        //split the expression to get numbers
        String[] parts = expression.split(" ");
        //array to store numbers in the expression as integers
        int[] values = new int[parts.length];
        int j = 0;
        for(int i = 0 ;i < parts.length;i++)
        {
            try
            {
                //change from string to integer
                values[j++] = Integer.parseInt(parts[i]);
            }catch(NumberFormatException e){j--;continue;}
        }
        /**
         * Loop through expression
         * pop 2 operands and perform the operation if an operator is found
         * push the result to the stack
         */
        int k = 0;
        for(int i = 0;i < expression.length();i++) //loop through expression
        {
            char x = expression.charAt(i);
            if(x >= '0' && x <= '9') {
                if (expression.charAt(i + 1) < '0' || expression.charAt(i + 1) > '9')
                    result.push(values[k++]);//push if number
            }
            else if(x == '*' || x == '+' || x == '-' || x == '/')
            {
                int done = 0;//result of operation
                if(result.isEmpty())
                    throw new RuntimeException("Invalid expression");
                int op2 = (int)result.pop();
                if(result.isEmpty())
                    throw new RuntimeException("Invalid expression");
                int op1 = (int)result.pop();//pop the operands from the stack
                switch(x)//perform the operation
                {
                    case '*': done = op1 * op2; break;
                    case '+': done = op1 + op2; break;
                    case '-': done = op1 - op2; break;
                    case '/': done = op1 / op2; break;
                }
                //add result to stack
                result.push(done);
            }
            else if(x != ' ')
                throw new RuntimeException("Invalid expression");//invalid expression if invalid input
        }
        if(result.size() != 1)
            throw new RuntimeException("Unbalanced expression");//more than 2 numbers remain in the stack meaning an invalid expression
        return (int)result.pop();//return the result(last member of stack)
    }
}
>>>>>>> 758ddc088b90deccb81078042cfaf95f5b437309
