package com.debu.DataStructure.meta.prep.BinaryTree;

public class MaxDepthOfBinaryTree {
    public int maxDepth(Node root)
    {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth,rightDepth);
    }
}
