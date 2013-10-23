public class Solution {
    class IntWrapper {
        public int value = 0;
        public IntWrapper(int v) {
            value = v;
        }
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        IntWrapper csum = new IntWrapper(0);
        IntWrapper maxsum = new IntWrapper(Integer.MIN_VALUE);
        
        maxPathSumHelper(root, csum, maxsum);
        return maxsum.value;
    }
    public void maxPathSumHelper(TreeNode root, IntWrapper csum, IntWrapper maxsum) {
        if(root == null) {
            csum.value = 0;
            return;
        }
        IntWrapper lsum = new IntWrapper(0);
        IntWrapper rsum = new IntWrapper(0);
        maxPathSumHelper(root.left, lsum, maxsum);
        maxPathSumHelper(root.right, rsum, maxsum);
        csum.value = Math.max(root.val, Math.max(root.val+lsum.value, root.val+rsum.value));
        maxsum.value = Math.max(maxsum.value, Math.max(csum.value, lsum.value + root.val + rsum.value));
    }
}
