package eg.edu.alexu.csd.datastructure.iceHockey.cs49;
import java.awt.*;
import java.util.*;
public class IPlayersFinder {
    public class Sorter implements Comparator
    {
        public int compare(Object a, Object b) {
            Point x=(Point) a;
            Point y=(Point) b;
            int xComp = Integer.compare(x.x, y.x);
            if(xComp == 0)
                return Integer.compare(x.y, y.y);
            else
                return xComp;
        }
    }
    public int maxx=0,maxy=0,miny=999,minx=999;
    public int dfs(String[] photo, int team, int threshold, boolean[][] taken,int i,int j,int area)
    {
        area=4;
        taken[i][j]=true;
        if(maxx<i)
            maxx=i;
        if(maxy<j)
            maxy=j;
        if(minx>i)
            minx=i;
        if(miny>j)
            miny=j;
        if(j+1<photo[0].length()&&photo[i].charAt(j+1)==(team+'0') && taken[i][j+1]==false)
        {
            area+= dfs(photo,team,threshold,taken,i,j+1,area);
        }
        if(j-1>=0&&photo[i].charAt(j-1)==(team+'0') && taken[i][j-1]==false)
        {
            area+= dfs(photo,team,threshold,taken,i,j-1,area);
        }
        if(i+1<photo.length&&photo[i+1].charAt(j)==(team+'0') && taken[i+1][j]==false)
        {
            area+= dfs(photo,team,threshold,taken,i+1,j,area);
        }
        if(i-1>=0&&photo[i-1].charAt(j)==(team+'0') && taken[i-1][j]==false)
        {
            area+= dfs(photo,team,threshold,taken,i-1,j,area);
        }
        return area;
    }
    public java.awt.Point[] findPlayers(String[] photo, int team, int threshold) {
        boolean[][] taken = new boolean[photo.length][photo[0].length()];
        java.awt.Point[] answer = new java.awt.Point[200];
        int flag=0;
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[0].length(); j++) {
                if (photo[i].charAt(j) == (team+'0') && taken[i][j] == false) {
                    maxx = 0;
                    maxy = 0;
                    miny = 999;
                    minx = 999;
                    int area = dfs(photo, team, threshold, taken, i, j, 0);
                    if (area >= threshold) {
                        java.awt.Point box = new java.awt.Point();
                        box.y = minx + maxx + 1;
                        box.x = miny + maxy + 1;
                        answer[flag++]=box;
                    }
                }
            }
        }
        java.awt.Point[] tobesorted = new java.awt.Point[flag];
        System.arraycopy(answer,0,tobesorted,0,flag);

        Arrays.sort(tobesorted, new Sorter());

        return tobesorted;
    }
}
