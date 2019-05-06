package eg.edu.alexu.csd.datastructure.maze.cs49;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeSolver implements IMazeSolver {
    private int n;
    private int m;
    private Point S = new Point();
    private class Node
    {
        Node father;
        Point coords;
    }
    private int[][] Pather(Node ref) {
        Node tempnode = ref;

        int size;
        for(size = 0; ref != null; ref = ref.father) {
            ++size;
        }

        int[][] path = new int[size][2];
        int i = size - 1;

        for(ref = tempnode; ref != null; ref = ref.father) {
            Point temp = ref.coords;
            path[i][0] = temp.y;
            path[i--][1] = temp.x;
        }

        return path;
    }

    private char[][] prepare(File maze) {
        Scanner sc;
        try {
            sc = new Scanner(maze);
        } catch (FileNotFoundException var7) {
            throw new RuntimeException("File not found");
        }

        n = sc.nextInt();
        m = sc.nextInt();
        char[][] Map = new char[n][m];

        for(int i = 0; i < n; ++i) {
            String x = sc.next();

            for(int j = 0; j < m; ++j) {
                Map[i][j] = x.charAt(j);
                if (Map[i][j] == 'S') {
                    S.y = i;
                    S.x = j;
                }
            }
        }

        return Map;
    }

    public int[][] solveBFS(File maze) {
        char[][] Map = prepare(maze);
        LinkedQueue Nodes = new LinkedQueue();
        Point T = S;
        Node current = new Node();
        current.coords = S;
        boolean[][] Visited = new boolean[n][m];
        Nodes.enqueue(current);
        boolean success = false;

        while(!Nodes.isEmpty()) {
            current = (Node)Nodes.dequeue();
            T = current.coords;
            Visited[T.y][T.x] = true;
            if (Map[T.y][T.x] == 'E') {
                success = true;
                break;
            }

            Node temp2;
            Point temp;
            if (T.y + 1 < n && Map[T.y + 1][T.x] != '#' && !Visited[T.y + 1][T.x]) {
                temp2 = new Node();
                temp = new Point();
                temp.y = T.y + 1;
                temp.x = T.x;
                temp2.coords = temp;
                temp2.father = current;
                Nodes.enqueue(temp2);
            }

            if (T.y - 1 >= 0 && Map[T.y - 1][T.x] != '#' && !Visited[T.y - 1][T.x]) {
                temp2 = new Node();
                temp = new Point();
                temp.y = T.y - 1;
                temp.x = T.x;
                temp2.coords = temp;
                temp2.father = current;
                Nodes.enqueue(temp2);
            }

            if (T.x + 1 < m && Map[T.y][T.x + 1] != '#' && !Visited[T.y][T.x + 1]) {
                temp2 = new Node();
                temp = new Point();
                temp.y = T.y;
                temp.x = T.x + 1;
                temp2.coords = temp;
                temp2.father = current;
                Nodes.enqueue(temp2);
            }

            if (T.x - 1 >= 0 && Map[T.y][T.x - 1] != '#' && !Visited[T.y][T.x - 1]) {
                temp2 = new Node();
                temp = new Point();
                temp.y = T.y;
                temp.x = T.x - 1;
                temp2.coords = temp;
                temp2.father = current;
                Nodes.enqueue(temp2);
            }
        }

        if (success) {
            int[][] path = Pather(current);
            return path;
        } else {
            return null;
        }
    }

    public int[][] solveDFS(File maze) {
        char[][] Map = prepare(maze);
        Stack Nodes = new Stack();
        Point T = S;
        Node current = new Node();
        current.coords = S;
        boolean[][] Visited = new boolean[n][m];
        Nodes.push(current);
        boolean success = false;

        while(!Nodes.isEmpty()) {
            current = (Node)Nodes.pop();
            T = current.coords;
            Visited[T.y][T.x] = true;
            if (Map[T.y][T.x] == 'E') {
                success = true;
                break;
            }

            Node temp2 = new Node();
            Point temp = new Point();
            if (T.y + 1 < n && Map[T.y + 1][T.x] != '#' && !Visited[T.y + 1][T.x]) {
                temp.y = T.y + 1;
                temp.x = T.x;
                temp2.coords = temp;
                temp2.father = current;
                Nodes.push(temp2);
            }

            if (T.y - 1 >= 0 && Map[T.y - 1][T.x] != '#' && !Visited[T.y - 1][T.x]) {
                temp.y = T.y - 1;
                temp.x = T.x;
                temp2.coords = temp;
                temp2.father = current;
                Nodes.push(temp2);
            }

            if (T.x + 1 < m && Map[T.y][T.x + 1] != '#' && !Visited[T.y][T.x + 1]) {
                temp.y = T.y;
                temp.x = T.x + 1;
                temp2.coords = temp;
                temp2.father = current;
                Nodes.push(temp2);
            }

            if (T.x - 1 >= 0 && Map[T.y][T.x - 1] != '#' && !Visited[T.y][T.x - 1]) {
                temp.y = T.y;
                temp.x = T.x - 1;
                temp2.coords = temp;
                temp2.father = current;
                Nodes.push(temp2);
            }
        }

        if (success) {
            int[][] path = Pather(current);
            return path;
        } else {
            return null;
        }
    }
}
