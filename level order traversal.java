public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        
        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        
        curr.offer(root);
       
        while(!curr.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(TreeNode n : curr) {
                list.add(n.val);
            }
            result.add(list);
            
            Queue<TreeNode> parent = new LinkedList<TreeNode>(curr);
            curr = new LinkedList<TreeNode>();
            for(TreeNode n: parent) {   
                if(n.left != null) {
                    curr.offer(n.left);
                }
                if(n.right != null) {
                    curr.offer(n.right);
                }
            }
        }
       
        return result;
    }
}
