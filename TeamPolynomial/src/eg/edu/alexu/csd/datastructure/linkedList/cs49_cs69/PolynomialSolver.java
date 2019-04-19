package eg.edu.alexu.csd.datastructure.linkedList.cs49_cs69;

import java.util.*;
import java.lang.Math;
public class PolynomialSolver implements IPolynomialSolver {
    class polynomial {
        private int coefficient;
        private int exponent;
        polynomial(int c,int e)
        {
            coefficient = c;
            exponent = e;
        }

        public int getCoefficient() {
            return coefficient;
        }

        public int getExponent() {
            return exponent;
        }
    }
    private SingleLinkedList R;
    private SingleLinkedList A = new SingleLinkedList(), B = new SingleLinkedList(), C = new SingleLinkedList();
    public class Sorter implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(b[1], a[1]);
        }
    }
    public Boolean isValidPoly(char poly)
    {
        return ((poly >= 'A' && poly <= 'C') || poly == 'R');
    }
    public Boolean isListCleared(SingleLinkedList S)
    {
        return (S == null || (S != null && S.size() == 0));
    }
    public SingleLinkedList CharToList(char poly)
    {
        switch(poly)
        {
            case 'A':
                return A;
            case 'B':
                return B;
            case 'C':
                return C;
            case 'R':
                return R;
            default:
                throw new RuntimeException("Invalid Variable");
        }
    }
    public int[][] StringTokens(String str)
    {
        if(str.matches(".*[^\\-0123456789() ,]+.*"))
            throw new RuntimeException("Invalid Input");
        String parts[] = str.split(",");
        if(parts.length == 0 || parts.length % 2 > 0)
            throw new RuntimeException("Invalid Input");
        for(int i =0;i < parts.length;i++)
        {
            if(parts[i].length() == 0)
                throw new RuntimeException("Invalid Input");
            parts[i] = parts[i].replaceAll("[^\\-0123456789]","");
        }
        int PolyArr[][] = new int[parts.length / 2][2];
        for(int i = 0;i < parts.length;i += 2)
        {
            try {
                Integer.parseInt(parts[0]);
                Integer.parseInt(parts[1]);
            } catch (NumberFormatException e)
            {
                throw new RuntimeException("Invalid Input");
            }
            PolyArr[i / 2][0] = Integer.valueOf(parts[i]);
            PolyArr[i / 2][1] = Integer.valueOf(parts[i+1]);
        }
        return PolyArr;
    }
    public float evaluatePolynomial(char poly, float value)
    {
        if(!isValidPoly(poly))
            throw new RuntimeException("Invalid Variable");
        SingleLinkedList singleList = CharToList(poly);
        if(isListCleared(singleList))
            throw new RuntimeException("The list is Cleared or uninitialized");
        float ans = 0;
        int Sz = singleList.size();
        for(int i = 0;i < Sz;i++)
        {
            polynomial pol = (polynomial) singleList.get(i);
            ans += Math.pow(pol.getCoefficient(),pol.getExponent());
        }
        return ans;
    }
    public int[][] add(char poly1, char poly2)
    {
        if(!isValidPoly(poly1) || !isValidPoly(poly2))
            throw new RuntimeException("Invalid Variable");
        SingleLinkedList S1 = CharToList(poly1),S2 = CharToList(poly2);
        if(isListCleared(S1) || isListCleared(S2))
            throw new RuntimeException("The list is Cleared or uninitialized");
        R = new SingleLinkedList();
        
        return null;
    }
    public int[][] subtract(char poly1, char poly2)
    {
        if(!isValidPoly(poly1) || !isValidPoly(poly2))
            throw new RuntimeException("Invalid Variable");
        SingleLinkedList S1 = CharToList(poly1),S2 = CharToList(poly2);
        if(isListCleared(S1) || isListCleared(S2))
            throw new RuntimeException("The list is Cleared or uninitialized");
        //TBD
        return null;
    }
    public int[][] multiply(char poly1, char poly2)
    {
        //TBD
        return null;
    }
    public void setPolynomial(char poly, int[][] terms) {

        SingleLinkedList tobeused = null;
        if(!isValidPoly(poly))
            throw new RuntimeException("Invalid Variable");
        tobeused = CharToList(poly);
        if(tobeused == null)
            tobeused = new SingleLinkedList();
        tobeused.clear();
        Arrays.sort(terms,new Sorter());
        for(int i = 0;i < terms.length;i++)
        {
            polynomial pol = new polynomial(terms[i][0],terms[i][1]);
            tobeused.add(pol);
        }
    }

    public String print(char poly) {
        SingleLinkedList tobeused=null;
        if(!isValidPoly(poly))
            throw new RuntimeException("Invalid Variable");
        tobeused = CharToList(poly);
        if(isListCleared(tobeused))
            throw new RuntimeException("The list is Cleared or uninitialized");
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

    public void clearPolynomial(char poly)
    {
        SingleLinkedList tobeused=null;
        if(!isValidPoly(poly))
            throw new RuntimeException("Invalid Variable");
        tobeused = CharToList(poly);
        tobeused.clear();
    }
}
