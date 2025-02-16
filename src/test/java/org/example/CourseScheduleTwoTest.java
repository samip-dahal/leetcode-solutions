package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseScheduleTwoTest {

    @Test
    public void testIfCoursesWithoutLoopReturnsTopologicalSortedCourseOrder() {
        final CourseScheduleTwo courseScheduleTwo = new CourseScheduleTwo();

        final int numCourses = 5;

        final int[][] prerequisites = new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}};

        final int[] result = courseScheduleTwo.findOrder(numCourses, prerequisites);

        assertEquals(numCourses, result.length);
    }

    @Test
    public void testIfCoursesWithLoopReturnsEmptyArray() {

        final CourseScheduleTwo courseScheduleTwo = new CourseScheduleTwo();

        final int numCourses = 3;

        final int[][] prerequisites = new int[][] {{1, 0}, {2, 0}, {0, 1}};

        final int[] result = courseScheduleTwo.findOrder(numCourses, prerequisites);

        assertEquals(0, result.length);
    }

    @Test
    public void testIfCoursesWithNoPrerequisitesReturnsTopologicalSortedCourseOrder() {

        final CourseScheduleTwo courseScheduleTwo = new CourseScheduleTwo();

        final int numCourses = 1;

        final int[][] prerequisites = new int[][] {};

        final int[] result = courseScheduleTwo.findOrder(numCourses, prerequisites);

        assertEquals(numCourses, result.length);

    }
}
