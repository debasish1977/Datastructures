package com.debu.DataStructure.meta.prep.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BTreeInorderTraversal {

    public List<Integer> inOrderTraversal(Node root)
    {
        List<Integer> result = new ArrayList<Integer>();
        inOrderHelper(root,result);
        return result;
    }

    public void inOrderHelper(Node root, List<Integer> result)
    {
        if(root == null)
            return;

        inOrderHelper(root.left,result);
        result.add(root.data);
        inOrderHelper(root.right,result);
    }
}
