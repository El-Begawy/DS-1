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
    private SingleLinkedList R = new SingleLinkedList();
    private SingleLinkedList A = new SingleLinkedList(), B = new SingleLinkedList(), C = new SingleLinkedList();
    public class Sorter implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(Integer.valueOf(b[1]), Integer.valueOf(a[1]));
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
        String[] parts = str.split(",");
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
            ans += pol.getCoefficient()*Math.pow(value,pol.getExponent());
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
        int i = 0,j = 0;
        ArrayList<polynomial> myArr = new ArrayList<>();
        for(;i < S1.size() && j < S2.size();)
        {
            polynomial X1 = (polynomial)S1.get(i);
            polynomial X2 = (polynomial)S2.get(j);
            if(X1.exponent == X2.exponent)
            {
                myArr.add(new polynomial(X1.coefficient + X2.coefficient,X1.exponent));
                i++;
                j++;
            } else if(X1.exponent > X2.exponent)
            {
                myArr.add(new polynomial(X1.coefficient,X1.exponent));
                i++;
            } else {
                myArr.add(new polynomial(X2.coefficient,X2.exponent));
                j++;
            }
        }
        for(;i < S1.size();i++)
        {
            polynomial X1 = (polynomial)S1.get(i);
            myArr.add(new polynomial(X1.coefficient,X1.exponent));
        }
        for(;j < S2.size();i++)
        {
            polynomial X1 = (polynomial)S2.get(j);
            myArr.add(new polynomial(X1.coefficient,X1.exponent));
        }
        int ret[][] = new int[myArr.size()][2];
        for(int x = 0;x < myArr.size();x++)
        {
            polynomial X1 = myArr.get(x);
            ret[x][0] = X1.coefficient;
            ret[x][1] = X1.exponent;
        }
        Arrays.sort(ret,new Sorter());
        setPolynomial('R',ret);
        return ret;
    }
    public int[][] subtract(char poly1, char poly2)
    {
        if(!isValidPoly(poly1) || !isValidPoly(poly2))
            throw new RuntimeException("Invalid Variable");
        SingleLinkedList S1 = CharToList(poly1),S2 = CharToList(poly2);
        if(isListCleared(S1) || isListCleared(S2))
            throw new RuntimeException("The list is Cleared or uninitialized");
        int i = 0,j = 0;
        ArrayList<polynomial> myArr = new ArrayList<>();
        for(;i < S1.size() && j < S2.size();)
        {
            polynomial X1 = (polynomial)S1.get(i);
            polynomial X2 = (polynomial)S2.get(j);
            if(X1.exponent == X2.exponent)
            {
                myArr.add(new polynomial(X1.coefficient - X2.coefficient,X1.exponent));
                i++;
                j++;
            } else if(X1.exponent > X2.exponent)
            {
                myArr.add(new polynomial(X1.coefficient,X1.exponent));
                i++;
            } else {
                myArr.add(new polynomial(-X2.coefficient,X2.exponent));
                j++;
            }
        }
        for(;i < S1.size();i++)
        {
            polynomial X1 = (polynomial)S1.get(i);
            myArr.add(new polynomial(X1.coefficient,X1.exponent));
        }
        for(;j < S2.size();i++)
        {
            polynomial X1 = (polynomial)S2.get(j);
            myArr.add(new polynomial(-X1.coefficient,X1.exponent));
        }
        int ret[][] = new int[myArr.size()][2];
        for(int x = 0;x < myArr.size();x++)
        {
            polynomial X1 = myArr.get(x);
            ret[x][0] = X1.coefficient;
            ret[x][1] = X1.exponent;
        }
        Arrays.sort(ret,new Sorter());
        setPolynomial('R',ret);
        return ret;
    }
    private int[][] removedupes(int[][] terms)
    {
        for(int i = 0;i < terms.length;i++)
        {
            int coeffsum = terms[i][0];
            int current = terms[i][1];
            for(int j = i+1;j < terms.length;j++)
            {
                if(current == terms[j][1])
                {
                    coeffsum += terms[j][0];
                    terms[j][1]=0;
                }
            }
            terms[i][0] = coeffsum;
        }
        return terms;
    }
    public int[][] multiply(char poly1, char poly2)
    {
        if(!isValidPoly(poly1) || !isValidPoly(poly2))
            throw new RuntimeException("Invalid Variable");
        SingleLinkedList S1 = CharToList(poly1),S2 = CharToList(poly2);
        if(isListCleared(S1) || isListCleared(S2))
            throw new RuntimeException("The list is Cleared or uninitialized");
        int[][] result = new int[S1.size()*S2.size()][2];
        R.clear();
        for(int i = 0;i < S1.size();i++)
        {
            polynomial x1 = (polynomial)S1.get(i);
            for (int j = 0; j < S2.size(); j++)
            {
                polynomial x2 = (polynomial)S2.get(j);
                polynomial poly = new polynomial(x1.getCoefficient()*x2.getCoefficient(),x1.getExponent()+x2.getExponent());
                result[i+j][0] = poly.getCoefficient();
                result[i+j][1] = poly.getExponent();
            }
        }
        Arrays.sort(result,new Sorter());
        removedupes(result);
        setPolynomial('R',result);
        return result;
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
            if(x.coefficient == 0)
                continue;
            if (i > 0)
                L += x.coefficient > 0 ? " + " : ' ';
            L += x.coefficient;
            if (x.exponent != 0 && x.exponent != 1) {
                L += "x^";
                L += x.exponent;
            }
            if (x.exponent == 1)
                L += "x";
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
