package com.debu.DataStructure.neetcode.problems;
//Time complexity: O(n)
//Space complexity: O(n) -- Worst case
//Space complexity: O(log n) -- Best case


public class MaxDepth {
    public int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth,rightDepth);
    }
}
