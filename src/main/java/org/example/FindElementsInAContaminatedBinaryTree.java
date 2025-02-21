/*
Problem Description: https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/
*/

package org.example;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInAContaminatedBinaryTree {

    Set<Integer> nodes = new HashSet<>();

    public FindElementsInAContaminatedBinaryTree(TreeNode root) {

        root.val = 0;

        nodes.add(root.val);

        traverseTree(root);
    }

    public boolean find(int target) {

        return nodes.contains(target);
    }

    private void traverseTree(TreeNode root) {

        if (root == null) {

            return;
        }

        int val = root.val;

        if (root.left != null) {

            root.left.val = (2 * val) + 1;

            nodes.add(root.left.val);

            traverseTree(root.left);
        }

        if (root.right != null) {

            root.right.val = (2 * val) + 2;

            nodes.add(root.right.val);

            traverseTree(root.right);
        }

    }
}
