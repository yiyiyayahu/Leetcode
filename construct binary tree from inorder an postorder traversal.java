public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null && postorder == null) return null;
        if(inorder.length != postorder.length) return null;
        if(inorder.length == 0) return null;
        if(inorder.length == 1) return new TreeNode(inorder[0]);
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == postorder[postorder.length-1]) {
                index = i;
                break;
            }
        }
        int[] leftInorder = new int[index];
        int[] leftPostorder = new int[index];
        for(int i = 0; i < index; i ++) {
            leftInorder[i] = inorder[i];
            leftPostorder[i] = postorder[i];
        }
        root.left = buildTree(leftInorder, leftPostorder);
        int[] rightInorder = new int[inorder.length - index - 1];
        int[] rightPostorder = new int[postorder.length - index - 1];
        int mid = index+1;
        for(int i = 0; i < inorder.length-index-1; i++) {
            rightInorder[i] = inorder[mid++];
        }
        int post = index;
        for(int i=0; i < postorder.length-index-1; i++) {
            rightPostorder[i] = postorder[post++];
        }
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }
}
