package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courseGraph = buildCourseGraph(numCourses, prerequisites);

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (cannotFinishAllCourses(i, courseGraph, visited)) {

                return false;

            }

        }

        return true;

    }

    private Map<Integer, List<Integer>> buildCourseGraph(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courseGraph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {

            courseGraph.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {

            int start = prerequisite[0];

            int end = prerequisite[1];

            courseGraph.get(start).add(end);
        }

        return courseGraph;
    }

    private boolean cannotFinishAllCourses(int course, Map<Integer, List<Integer>> courseGraph, int[] visited) {

        if (visited[course] == 1) {

            return true;
        }

        if (visited[course] == 2) {

            return false;
        }

        visited[course] = 1;

        List<Integer> neighbours = courseGraph.get(course);

        for (int i = 0; i < neighbours.size(); i++) {

            int node = neighbours.get(i);

            if (cannotFinishAllCourses(node, courseGraph, visited)) {

                return true;
            }
        }

        visited[course] = 2;

        return false;

    }

}
