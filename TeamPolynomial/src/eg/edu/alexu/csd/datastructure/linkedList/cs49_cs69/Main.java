package eg.edu.alexu.csd.datastructure.linkedList.cs49_cs69;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void printHeader()
    {
        System.out.println("Please choose an action.");
        System.out.println("-----------------------");
        System.out.println("1- Set a polynomial variable\n" +
                "2- Print the value of a polynomial variable\n" +
                "3- Add two polynomials\n" +
                "4- Subtract two polynomials\n" +
                "5- Multiply two polynomials\n" +
                "6- Evaluate a polynomial at some point\n" +
                "7- Clear a polynomial variable\n" +
                "8- to quit");
        System.out.println("================================================");
    }
    public static void main(String[] args) {
	    PolynomialSolver polySolver = new PolynomialSolver();
        Scanner Sc = new Scanner(System.in);
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
            if(state < 0 || state > 8)
            {
                System.out.println("Invalid Input");
                continue;
            }
            if(state == 1)
            {
                System.out.println("Insert the variable name: A, B or C");
                String state2 = Sc.next();
                System.out.println("Insert Polynomial Terms in the form:");
                System.out.println("(coefficient,exponent),(coefficient,exponent),..");
                String pol = Sc.next();
                try {
                    polySolver.setPolynomial(state2.charAt(0),polySolver.StringTokens(pol));
                } catch(RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if(state == 2)
            {
                System.out.println("Insert the variable name: A, B, C or R");
                String state2 = Sc.next();
                try
                {
                    System.out.println(polySolver.print(state2.charAt(0)));
                } catch(RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if(state == 3)
            {
                System.out.println("Insert the first variable(A, B, C)");
                String state2 = Sc.next();
                System.out.println("Insert the second variable(A, B, C)");
                String state3 = Sc.next();
                try
                {
                    polySolver.add(state2.charAt(0),state3.charAt(0));
                    System.out.println("Result of addition: " + polySolver.print('R'));
                } catch (RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if(state == 4)
            {
                System.out.println("Insert the first variable(A, B, C)");
                String state2 = Sc.next();
                System.out.println("Insert the second variable(A, B, C)");
                String state3 = Sc.next();
                try
                {
                    polySolver.subtract(state2.charAt(0),state3.charAt(0));
                    System.out.println("Result of addition: " + polySolver.print('R'));
                } catch (RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if(state == 5)
            {
                System.out.println("Insert the first variable(A, B, C)");
                String state2 = Sc.next();
                System.out.println("Insert the second variable(A, B, C)");
                String state3 = Sc.next();
                try
                {
                    polySolver.multiply(state2.charAt(0),state3.charAt(0));
                    System.out.println("Result of addition: " + polySolver.print('R'));
                } catch (RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
            }else if(state == 6)
            {
                System.out.println("Insert the variable to evaluate:A, B, C");
                String state2 = Sc.next();
                try
                {
                    polySolver.isValidPoly(state2.charAt(0));
                } catch (RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                System.out.println("Insert the value to evaluate at");
                float state3;
                try
                {
                    state3 = Sc.nextFloat();

                } catch(InputMismatchException e)
                {
                    System.out.println("Invalid Point");
                    Sc.next();
                    continue;
                }
                try
                {
                    System.out.println(polySolver.evaluatePolynomial(state2.charAt(0),state3));
                } catch (RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if(state == 7)
            {
                System.out.println("Insert the variable you wishto clear: A, B, C");
                String state2 = Sc.next();
                try
                {
                    polySolver.clearPolynomial(state2.charAt(0));
                } catch (RuntimeException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else return;
		}
    }
}
