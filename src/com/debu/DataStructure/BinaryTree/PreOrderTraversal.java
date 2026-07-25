package com.debu.DataStructure.BinaryTree;

import com.sun.source.tree.BinaryTree;
//Time Complexity is O(N)
public class PreOrderTraversal {
    Node root;

    public static void printPreOrder(Node node)
    {
        if(node == null)
        {
            return;
        }

        System.out.println(node.data+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void main(String[] args)
    {
        PreOrderTraversal tree = new PreOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.printPreOrder(tree.root);
    }
}
