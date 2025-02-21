/*
Problem Description: https://leetcode.com/problems/subsets/description/
*/

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        int size = nums.length;

        List<Integer> subset = new ArrayList<>();

        generateSubsets(0, nums, size, subset, result);

        return result;

    }

    private void generateSubsets(int index, int[] nums, int size, List<Integer> subset, List<List<Integer>> result) {

        result.add(new ArrayList(subset));

        for (int i = index; i < size; i++) {

            subset.add(nums[i]);

            generateSubsets(i + 1, nums, size, subset, result);

            subset.remove(subset.size() - 1);

        }

    }
}
