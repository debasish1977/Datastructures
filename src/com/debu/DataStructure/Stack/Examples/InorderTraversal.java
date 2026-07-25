package com.debu.DataStructure.Stack.Examples;

public class InorderTraversal {
    public static void printInOrder(Node node)
    {
        if(node==null)
            return;

        //First recur on left subtree
        printInOrder(node.left);
        System.out.println(node.data + " ");
        printInOrder(node.right);

    }
}
