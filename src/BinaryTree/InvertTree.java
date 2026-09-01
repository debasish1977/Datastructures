package BinaryTree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root)
    {
        //Edge case
        if(root==null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
