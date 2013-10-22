//O(n) space, inorder traversal
public class Solution {
    public void recoverTree(TreeNode root) {
        //inorder traversal - arraylist
        ArrayList<TreeNode> list = inorderTraversal(root);
        for(int i = 0; i < list.size()-1; i ++) {
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(j).val < list.get(i).val) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(j).val;
                    list.get(j).val = temp;
                }
            }
        }
    }
    
    public ArrayList<TreeNode> inorderTraversal(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr != null || !s.isEmpty()) {
            if(curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                list.add(curr);
                curr = curr.right;
            }
        }
        return list;
    }
}

//find from the Internet, O(n)
public class Solution {
    public void recoverTree(TreeNode root) {

        TreeNode n1=null, n2 =null;

        TreeNode current=root,prev=null,a=null;
        boolean first=true;
        while(current!=null){
            if(current.left==null){
                if(a!=null && a.val>current.val) {
                    if(first){
                        n1=a;
                        first=false;
                    }else{
                        n2=current;
                    }
                }
                if(n1!=null && a==n1) n2=current;
                a=current;
                current=current.right;
            }else{
                prev=current.left;
                while(prev.right!=null && prev.right!=current)
                    prev=prev.right;
                if(prev.right==null){
                    prev.right=current;
                    current = current.left;
                }else{
                    if(a!=null && a.val>current.val) {
                        if(first){
                            n1=a;
                            first=false;
                        }else{
                            n2=current;
                        }
                    }
                    if(n1!=null && a==n1) n2=current;
                    a=current;
                    prev.right=null;
                    current=current.right;
                }
            }
        }
        assert(n1!=null && n2!=null);
        int temp =n1.val;
        n1.val=n2.val;
        n2.val=temp;
    }
}
