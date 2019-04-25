package eng.edu.alexu.csd.datastructure.stack.cs49;

import java.util.Scanner;

public class Main {
    static void printHeader()
    {
        System.out.println("Please choose an action.");
        System.out.println("-----------------------");
        System.out.println("1- Push\n" +
                "2- Pop\n" +
                "3- Peek\n" +
                "4- Get size\n" +
                "5- Check if empty\n" +
                "6- to quit");
        System.out.println("================================================");
    }
    public static void main(String[] args) {
        ExpressionEvaluator eva = new ExpressionEvaluator();
        eva.evaluate("2 3 1 * + 9 -");
        Scanner Sc = new Scanner(System.in);
        Stack teststack = new Stack();
        while(true)
        {
            printHeader();
            int state;
            try{
                state = Sc.nextInt();
            } catch(java.util.InputMismatchException e)
            {
                System.out.println("Invalid Input");
                Sc.next();
                continue;
            }
            if(state < 0 || state > 6)
            {
                System.out.println("Invalid Input");
                continue;
            }
            else if(state == 1) {
                System.out.println("Enter integer to push");
                int x=0;
                try {
                    x = Sc.nextInt();
                } catch (RuntimeException e)
                {
                    System.out.println("Enter a valid int");
                    continue;
                }
                teststack.push(x);
            }
            else if(state == 2) {
                try {
                    System.out.println(teststack.pop());
                }catch (RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if(state == 3) {
                try {
                    System.out.println(teststack.peek());
                }catch (RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if(state == 4) {
                System.out.println(teststack.size());
            }
            else if(state == 5) {
                System.out.println(teststack.isEmpty());
            }
            else return;
        }
    }

}
