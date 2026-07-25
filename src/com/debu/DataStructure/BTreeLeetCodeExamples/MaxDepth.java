package com.debu.DataStructure.BTreeLeetCodeExamples;

public class MaxDepth {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
