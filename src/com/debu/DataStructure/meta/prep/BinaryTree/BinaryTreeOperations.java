package com.debu.DataStructure.meta.prep.BinaryTree;

public class BinaryTreeOperations {
    public static void printInOrder(Node root)
    {
        if(root == null)
            return;

        printInOrder(root.left);
        System.out.println("Data-->" +root.data);
        printInOrder(root.right);
    }

    //Function to calculate the height of a binary tree
    static int height(Node root)
    {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    static boolean isBalanced(Node root)
    {
        if(root == null)
            return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //Maximum Depth Of Binary Tree
    public int maxDepth(Node root)
    {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth,rightDepth);
    }

    public static boolean isSameTree(Node p,Node q)
    {
        if(p == null && q == null)
            return true;
        if(p== null || q ==null)
            return false;
        return (p.data == q.data) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
