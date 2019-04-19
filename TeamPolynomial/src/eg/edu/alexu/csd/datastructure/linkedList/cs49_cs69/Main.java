package eg.edu.alexu.csd.datastructure.linkedList.cs49_cs69;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    PolynomialSolver polySolver = new PolynomialSolver();
        Scanner Sc = new Scanner(System.in);
	    String inp = Sc.nextLine();
	    int tmp[][] = polySolver.StringTokens(inp);
	    if(tmp == null)
	        return;
	    for(int i = 0;i < tmp.length;i++)
	        System.out.println(tmp[i][0] + " " + tmp[i][1]);
	    polySolver.setPolynomial('A',tmp);
	    polySolver.print('A');

    }
}
