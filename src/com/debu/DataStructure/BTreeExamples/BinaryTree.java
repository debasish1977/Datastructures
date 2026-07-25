package com.debu.DataStructure.BTreeExamples;

public class BinaryTree {
    //Post Order Traversal
    public static void printPostorder(Node node)
    {
        if(node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println("Data-->"+node.data);

    }

}
