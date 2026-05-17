package day60_31.day55;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>(); // 邻接表
        for (int i = 0; i < numCourses; i++) { // 根据课程数创建邻接表
            adjacency.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) { // 构建课程依赖邻接表, pair[1] -> pair[0]
            adjacency.get(pair[1]).add(pair[0]);
        }

        // 0: 未访问, 1: 正在访问, 2: 已访问完成
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjacency, visited)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int course, List<List<Integer>> adjacency, int[] visited) {
        if (visited[course] == 1) return false; // 检测到环
        if (visited[course] == 2) return true;  // 已访问过

        visited[course] = 1; // 标记为正在访问

        for (int next : adjacency.get(course)) {
            if (!dfs(next, adjacency, visited)) {
                return false;
            }
        }

        visited[course] = 2; // 标记为已访问完成
        return true;
    }
}