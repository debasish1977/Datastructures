package com.debu.DataStructure.BTreeLeetCodeExamples;

public class HeightOfBinaryTree {
    static int height(Node root)
    {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
}
