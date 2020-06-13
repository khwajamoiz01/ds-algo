/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package leetcode;

import java.awt.*;
import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: LargeMaze.java, v 0.1 2020-04-20 12:47 am khwaja.ali Exp 3
 */
public class LargeMaze {
    public static void main(String[] args) {
        LargeMaze lm = new LargeMaze();
        int[][] blocked = {};//{{0, 1}, {1, 0}};
        int[] source = {0, 0};
        int[] target = {999, 999};
        System.out.println(lm.isEscapePossible(blocked, source, target));
    }

    static int[][] dirs = {{0, -1}, {-1, 0}, {0, +1}, {+1, 0}};

    public boolean isEscapePossible(int[][] blocked, int[] sourcePoint, int[] target) {
        Set<String> vis = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(sourcePoint);

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];
            if (i == target[0] && j == target[1])
                return true;
            for (int[] dir : dirs) {
                int u = i + dir[0];
                int v = j + dir[1];
                if (isSafe(u, v, blocked, vis)) {
                    vis.add(u + "," + v);
                    queue.add(new int[]{u, v});
                }
            }
        }
        return false;
    }

    boolean isSafe(int u, int v, int[][] blockAr, Set<String> vis) {
        if (vis.contains(u + "," + v))
            return false;
        if (u < 0 || u >= 100000)
            return false;
        if (v < 0 || v >= 100000)
            return false;
        for (int[] block : blockAr) {
            if (u == block[0] && v == block[1])
                return false;
        }
        return true;
    }

}