package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleTest {

    @Test
    public void testIfCoursesWithoutLoopReturnsTrue() {

        final CourseSchedule courseSchedule = new CourseSchedule();

        final int numCourses = 3;

        final int[][] prerequisites = new int[][] {{1, 0}, {2, 0}};

        final boolean result = courseSchedule.canFinish(numCourses, prerequisites);

        assertTrue(result);
    }

    @Test
    public void testIfCoursesWithLoopReturnsFalse() {

        final CourseSchedule courseSchedule = new CourseSchedule();

        final int numCourses = 3;

        final int[][] prerequisites = new int[][] {{1, 0}, {2, 0}, {0, 1}};

        final boolean result = courseSchedule.canFinish(numCourses, prerequisites);

        assertFalse(result);
    }

    @Test
    public void testIfSingleCourseWithNoPrerequisitesReturnsTrue() {

        final CourseSchedule courseSchedule = new CourseSchedule();

        final int numCourses = 1;

        final int[][] prerequisites = new int[][] {};

        final boolean result = courseSchedule.canFinish(numCourses, prerequisites);

        assertTrue(result);

    }

    @Test
    public void testIfMultipleCoursesWithNoPrerequisitesReturnsTrue() {

        final CourseSchedule courseSchedule = new CourseSchedule();

        final int numCourses = 3;

        final int[][] prerequisites = new int[][] {};

        final boolean result = courseSchedule.canFinish(numCourses, prerequisites);

        assertTrue(result);
    }

}
