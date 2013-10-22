public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.right != null) flatten(root.right);
        if(root.left != null) {
            flatten(root.left);
            TreeNode end = rightMost(root.left);
            end.right = root.right;
            root.right = root.left;
            root.left = null; //important
        }
    }
    public TreeNode rightMost(TreeNode n) {
        TreeNode root = n;
        if(root == null) return null;
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }
}
