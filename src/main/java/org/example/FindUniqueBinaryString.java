/*
Problem Description: https://leetcode.com/problems/find-unique-binary-string/description/
*/

package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;

        List<String> allPossibleStringList = new ArrayList<>();

        generateStrings("", allPossibleStringList, n);

        return findTheMissingString(allPossibleStringList, nums);
    }

    private void generateStrings(String temp, List<String> list, int len) {

        if (temp.length() > len) {

            return;
        }

        if (temp.length() == len) {

            list.add(temp);

            return;
        }

        generateStrings(temp + "0", list, len);

        generateStrings(temp + "1", list, len);

    }

    private String findTheMissingString(List<String> candidates, String[] nums) {

        Set<String> numsSet = new HashSet<>();

        for (String s : nums) {

            numsSet.add(s);
        }

        for (String candidate : candidates) {

            if (!numsSet.contains(candidate)) {

                return candidate;
            }
        }

        return "";
    }
}
