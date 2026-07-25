package com.debu.DataStructure.BTreeLeetCodeExamples;

public class BinaryTree {
    public static void printinorder(Node node)
    {
        if(node == null)
            return;

        printinorder(node.left);
        System.out.println(node.data + "");
        printinorder(node.right);
    }


}
