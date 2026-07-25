package com.debu.DataStructure.BinaryTree;

//Time Complexity is O(N), where N is the total no of nodes


import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    //Function to print inorder traversal
    public void inOrderHelper(Node root, List<Integer> result)
    {
        if(root == null)
            return;
        inOrderHelper(root.left,result);
        result.add(root.data);
        inOrderHelper(root.right,result);

    }

    public List<Integer> inOrderTraversal(Node root)
    {
        List<Integer> result = new ArrayList<Integer>();
        inOrderHelper(root,result);
        return result;

    }




}
