/*
Problem Description: https://leetcode.com/problems/find-special-substring-of-length-k/description/
*/

package org.example;

import java.util.HashSet;
import java.util.Set;

public class FindSpecialSubstringOfLengthK {

    public boolean hasSpecialSubstring(String s, int k) {

        int sLength = s.length();

        for (int i = 0; i <= sLength - k; i++) {

            String subStr = s.substring(i, i + k);

            if (hasSpecialSubstring(subStr, s, i, i + k - 1)) {

                return true;
            }

        }

        return false;

    }

    private boolean hasSpecialSubstring(String subStr, String s, int start, int end) {

        return checkIfDistinctConditionHolds(subStr) && checkIfCharBeforeDifferentHolds(subStr, s, start, end) && checkIfCharAfterDifferentHolds(subStr, s, start, end);

    }

    private boolean checkIfDistinctConditionHolds(String subStr) {

        Set<Character> set = new HashSet<>();

        for (char ch : subStr.toCharArray()) {

            set.add(ch);
        }

        return set.size() == 1;
    }

    private boolean checkIfCharBeforeDifferentHolds(String subStr, String s, int start, int end) {

        if (start == 0) {

            return true;
        }

        char ch = subStr.charAt(0);

        char prev = s.charAt(start - 1);

        return ch != prev;
    }

    private boolean checkIfCharAfterDifferentHolds(String subStr, String s, int start, int end) {

        if (end == s.length() - 1) {

            return true;
        }

        char ch = subStr.charAt(0);

        char next = s.charAt(end + 1);

        return ch != next;
    }

}
