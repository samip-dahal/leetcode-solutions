/*
Problem Description: https://leetcode.com/problems/course-schedule-ii/description/
*/

package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleTwo {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courseGraph = buildCourseGraph(prerequisites, numCourses);

        int[] visited = new int[numCourses];

        List<Integer> courseOrder = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {

            boolean isPossible = checkIfPossibleToFinishAllCourses(course, courseGraph, visited, courseOrder);

            if (!isPossible) {

                return new int[0];
            }
        }

        return toArray(courseOrder);

    }

    private Map<Integer, List<Integer>> buildCourseGraph(int[][] prerequisites, int numCourses) {

        Map<Integer, List<Integer>> courseGraph = new HashMap<>();

        for (int course = 0; course < numCourses; course++) {

            courseGraph.put(course, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {

            int start = prerequisite[0];

            int end = prerequisite[1];

            courseGraph.get(start).add(end);
        }

        return courseGraph;

    }

    private boolean checkIfPossibleToFinishAllCourses(int course, Map<Integer, List<Integer>> courseGraph, int[] visited, List<Integer> courseOrder) {

        if (visited[course] == 1) {

            return false;
        }

        if (visited[course] == 2) {

            return true;
        }

        visited[course] = 1;

        List<Integer> neighbours = courseGraph.get(course);

        for (int i = 0; i < neighbours.size(); i++) {

            int neighbour = neighbours.get(i);

            boolean isPossible = checkIfPossibleToFinishAllCourses(neighbour, courseGraph, visited, courseOrder);

            if (!isPossible) {

                return false;
            }
        }

        visited[course] = 2;

        courseOrder.add(course);

        return true;
    }

    private int[] toArray(List<Integer> list) {

        int size = list.size();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {

            array[i] = list.get(i);
        }

        return array;
    }

}
