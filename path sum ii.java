public class Solution {
    //backtracking

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathSum(root, sum, list, path);
        return list;
    }
    //if searching through till the leaf then back up to add these nodes along the path will take too much time,
    //so add the root each time while traversing, if not, then delete
    //Thus, pass the ArrayList<Integer> as well
    public void pathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> path) {
        if(root == null) return;
        
        if(root.left == null && root.right == null && root.val == sum) {
            ArrayList<Integer> newlist = new ArrayList<Integer>(path);
            newlist.add(root.val);
            list.add(newlist);
            return;
        } 
        path.add(root.val);
        if(root.left != null) pathSum(root.left, sum-root.val, list, path);
        if(root.right != null) pathSum(root.right, sum-root.val, list, path);
        path.remove(path.size()-1);
        
    }
}
