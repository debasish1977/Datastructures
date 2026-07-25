package com.debu.DataStructure.BinaryTreeExample;


//Time complexity -- O(N)

public class BTreeInorderTraversal {
    public static void printInOrder(Node root)
    {
        if(root == null)
            return;

        printInOrder(root.left);
        System.out.println("Data-->"+root.data);
        printInOrder(root.right);
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        printInOrder(root);
    }
}
