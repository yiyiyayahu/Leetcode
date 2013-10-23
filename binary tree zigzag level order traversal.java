public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Stack<TreeNode> curr = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        boolean leftToRight = true;
        curr.push(root);
        while(!curr.isEmpty()) {
            TreeNode node = curr.pop();
            if(node != null) {  
                list.add(node.val);
            
                if(leftToRight) {
                    next.push(node.left);
                    next.push(node.right);
                } else {
                    next.push(node.right);
                    next.push(node.left);
                }
            }
            
            if(curr.isEmpty()) {
                leftToRight = (leftToRight == false)? true: false;
                if(list.size() > 0) result.add(list);
                list = new ArrayList<Integer>();
                Stack<TreeNode> temp = curr;
                curr = next;
                next = temp;
            }
        }
        return result;
    }
}
