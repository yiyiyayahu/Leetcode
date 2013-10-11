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
