public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateBST(1, n);
    }
    public ArrayList<TreeNode> generateBST(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        if(start > end) list.add(null);
        for(int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = generateBST(start, i - 1);
            ArrayList<TreeNode> right = generateBST(i + 1, end);
            for(int j = 0; j < left.size(); j++) {
                for(int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    list.add(root);
                }
            }
        }
        return list;
    }
}
