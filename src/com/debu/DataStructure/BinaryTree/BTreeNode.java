package com.debu.DataStructure.BinaryTree;

public class BTreeNode {
    int val;
    BTreeNode left;
    BTreeNode right;
    BTreeNode() {}
    BTreeNode(int val)
    {
        this.val = val;
    }

    BTreeNode(int val,BTreeNode left,BTreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
