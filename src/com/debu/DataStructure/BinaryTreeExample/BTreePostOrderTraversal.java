package com.debu.DataStructure.BinaryTreeExample;

public class BTreePostOrderTraversal {
    void printPostorder(Node root)
    {
        if(root==null)
            return;

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println("data-->"+root.data);
    }
}
