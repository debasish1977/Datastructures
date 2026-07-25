package com.debu.DataStructure.BinaryTreeExample;

//Time Complexity -- O(N)

public class BinaryTree {
    public static void printInOrder(Node node)
    {
        if(node == null)
        {
            return;
        }
        printInOrder(node.left);
        System.out.println("Data-->" + node.data);
        printInOrder(node.right);
    }

    public static void main(String[] args)
    {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
    }
}
