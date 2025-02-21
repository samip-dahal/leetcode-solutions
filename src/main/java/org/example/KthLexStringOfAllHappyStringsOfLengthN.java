/*
Problem Description: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description
*/

package org.example;

import java.util.ArrayList;
import java.util.List;

public class KthLexStringOfAllHappyStringsOfLengthN {

    private final char[] happyCharacters = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {

        List<String> allHappyStrings = new ArrayList<>();

        generateHappyStrings("", ' ', n, allHappyStrings);

        return returnKthHappyString(allHappyStrings, k);

    }

    private void generateHappyStrings(String str, int prevChar, int reqLen, List<String> strings) {

        int currSize = str.length();

        if (currSize == reqLen) {

            strings.add(str);

            return;
        }

        for (char ch : happyCharacters) {

            if (ch != prevChar) {

                generateHappyStrings(str + ch, ch, reqLen, strings);
            }

        }

    }

    private String returnKthHappyString(List<String> strings, int k) {

        return strings.size() < k ? "" : strings.get(k - 1);
    }

}

