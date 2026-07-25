package com.debu.DataStructure.BTreeLeetCodeExamples;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrder {

    public List<Integer> inorderTraversal(Node root)
    {
        List<Integer> result = new ArrayList<Integer>();
        inorderHelper(root,result);
        return result;
    }
    public void inorderHelper(Node root, List<Integer> result)
    {
       if(root == null)
           return;

        inorderHelper(root.left,result);
        result.add(root.data);
        inorderHelper(root.right,result);

    }
}
