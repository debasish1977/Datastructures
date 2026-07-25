package com.debu.DataStructure.BTreeExamples;

public class BTreeNode {
    int data;
    Node left;
    Node right;

    BTreeNode(int v)
    {
        this.data = v;
        this.left = null;
        this.right = null;
    }
}
