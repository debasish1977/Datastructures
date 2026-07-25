package com.debu.DataStructure.BinaryTreeExample;

//Given the root of a binary tree return its maximum depth

public class BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
