/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int n = 0;
        ListNode curr = head;      //remember to assign head to another variable
        while(curr != null) {         
            n ++;
            curr = curr.next;
        }
        return sortedListToBSTHelper(head, 0, n-1);
    }
    public TreeNode sortedListToBSTHelper(ListNode head, int start, int end) {
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        ListNode curr = head;
        for(int i = start; i < mid; i++) {
            curr = curr.next;
        }
        TreeNode root = new TreeNode(curr.val);
        root.left = sortedListToBSTHelper(head, start, mid - 1);   
        root.right = sortedListToBSTHelper(curr.next, mid + 1, end);     //curr.next, pay attention
        return root;
    }
}

//O(n)
public class Solution {
    public int i = 0;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode curr = head;
        int n = 0;
       
        while(curr != null) {
            curr = curr.next;
            n ++;
        }
        return BSTHelper(new ListNode[]{head}, 0, n-1);
    }
    public TreeNode BSTHelper(ListNode[] head, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode left = BSTHelper(head, start, mid - 1);
        TreeNode n = new TreeNode(head[0].val);
        n.left = left;
        head[0] = head[0].next; //head[0] is a ListNode, so head[0].next will return the next ListNode
        //head = head.next is wrong. Because we need head to be changed after one iteration, but we first pass in head,
        //after executing the left treenode, the head should be changed, but here it is still the original head.
        n.right = BSTHelper(head, mid + 1, end);
        return n;
    }
}
