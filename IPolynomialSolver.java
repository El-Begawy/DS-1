package eg.edu.alexu.csd.datastructure.linkedList.cs49_cs69;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
public class IPolynomialSolver {
    class polynomial {
        public int coefficient;
        public int exponent;
    }

    public class Sorter implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {

            return Integer.compare(a[1], b[1]);

        }
    }

    SingleLinkedList R;
    SingleLinkedList A, B, C;

    public void setPolynomial(char poly, int[][] terms) {

        SingleLinkedList tobeused = new SingleLinkedList();
        switch (poly) {
            case 'A':
                A = tobeused;
                break;
            case 'B':
                B = tobeused;
                break;
            case 'C':
                C = tobeused;
                break;
            default:
                System.out.println("Invalid");
                return;
        }

        int flag = 1;
        int[][] x = new int[40][2];
        String trash;
        Scanner scanin = new Scanner(System.in);
        trash = scanin.nextLine();
        int current = 0;
        int spot = 0;
        int units = 0;
        boolean negative = false;
        boolean seperate = true;
        for (int i = 0; i < trash.length(); i++) {
            if (trash.charAt(i) == '-')
                negative = true;
            if (trash.charAt(i) >= '0' && trash.charAt(i) <= '9') {
                int j = i;
                while (trash.charAt(j) >= '0' && trash.charAt(j) <= '9') {
                    j++;
                    units++;
                }
                current += (trash.charAt(i) - '0') * Math.pow(10, units - 1);
                units = 0;
            } else if (trash.charAt(i) == ')' || (trash.charAt(i) == ',' && seperate)) {
                if (flag == 1) {
                    current = negative ? current * -1 : current;
                    x[spot][0] = current;
                    flag *= -1;
                    current = 0;
                    seperate = true;
                    negative = false;
                } else {
                    current = negative ? current * -1 : current;
                    x[spot][1] = current;
                    current = 0;
                    spot++;
                    flag *= -1;
                    seperate = false;
                    negative = false;
                }
            } else if (trash.charAt(i) == ',' && !seperate)
                seperate = true;

        }

        int[][] tobesorted = new int[spot][2];
        System.arraycopy(x, 0, tobesorted, 0, spot);
        Arrays.sort(tobesorted, new Sorter());
        while (spot-- != 0) {
            polynomial xy = new polynomial();
            xy.exponent = tobesorted[spot][1];
            xy.coefficient = tobesorted[spot][0];
            tobeused.add(xy);
            units++;
        }
    }

    String print(char poly) {
        SingleLinkedList tobeused;
        switch (poly) {
            case 'A':
                tobeused = A;
                break;
            case 'B':
                tobeused = B;
                break;
            case 'C':
                tobeused = C;
                break;
            case 'R':
                tobeused = R;
                break;
            default:
                System.out.println("Invalid");
                return "invalid";
        }
        String L = "";
        for (int i = 0; i < tobeused.size(); i++) {
            polynomial x = (polynomial) tobeused.get(i);
            if (i > 0)
                L += x.coefficient > 0 ? " + " : ' ';
            L += x.coefficient;
            if (x.exponent != 0 && x.exponent != 1) {
                L += "x^";
                L += x.exponent;
            }
            if (x.exponent == 1)
                L += x;
        }
        return L;
    }

    void clearPolynomial(char poly)
    {
        SingleLinkedList tobeused=null;
        switch (poly) {
            case 'A':
                tobeused = A;
                break;
            case 'B':
                tobeused = B;
                break;
            case 'C':
                tobeused = C;
                break;
            case 'R':
                tobeused = R;
                break;
            default:
                System.out.println("Invalid");
                return;
        }
        tobeused.clear();
    }
    public static void main(String[] args)
    {
        IPolynomialSolver war=new IPolynomialSolver();
        int[][] tester = new int[20][2];
        System.out.println("Insert the variable name A,B or C");
        Scanner scanin = new Scanner(System.in);
        String y = scanin.next();
        char switchpoly = y.charAt(0);
        System.out.println("Insert the polynomial terms in the form:\n");
        System.out.println("(coeff1, exponent1), (coeff2, exponent2), ..\n");
        war.setPolynomial(switchpoly,tester);
        System.out.println(war.print(switchpoly));
    }

}
