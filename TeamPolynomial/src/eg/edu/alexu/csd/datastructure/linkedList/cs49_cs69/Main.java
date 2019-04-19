package eg.edu.alexu.csd.datastructure.linkedList.cs49_cs69;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    PolynomialSolver polySolver = new PolynomialSolver();
        Scanner Sc = new Scanner(System.in);
	    String inp = Sc.nextLine();
	    int tmp[][] = polySolver.StringTokens(inp);
	    polySolver.setPolynomial('A',tmp);
	    inp = Sc.nextLine();
	    tmp = polySolver.StringTokens(inp);
	    polySolver.setPolynomial('B',tmp);
	    polySolver.add('A','B');
	    System.out.println(polySolver.print('R'));

    }
}
