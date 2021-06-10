package geeks.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1/
//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
//Geeks has a different solution which seems unnecessarily complex, below seems fine and is accepted on practice
public class TimeToRotOranges {

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] directions = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    static boolean isSafe(int u, int v, int r, int c) {
        return u >= 0 && u < r && v >= 0 && v < c;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int[][] ar = new int[r][c];

                Queue<Node> q = new ArrayDeque<>();
                int count = 0;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        ar[i][j] = sc.nextInt();
                        if (ar[i][j] == 1) {
                            count++;
                        }
                        if (ar[i][j] == 2) {
                            q.offer(new Node(i, j));
                        }
                    }
                }
                int time = 0;
                while (!q.isEmpty()) {
                    int h = q.size();
                    while (h-- > 0) {
                        Node node = q.poll();
                        for (int[] dir : directions) {
                            int u = node.i + dir[0];
                            int v = node.j + dir[1];
                            if (isSafe(u, v, r, c) && ar[u][v] == 1) {
                                ar[u][v] = 2;
                                count--;
                                //if (--count == 0) return/print time; //this is better
                                q.offer(new Node(u, v));
                            }
                        }
                    }
                    time++;
                }
                System.out.println(count == 0 ? time - 1 : -1);
            }
        }
    }

}
