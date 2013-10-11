/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        
        ListNode prev = new ListNode(0);
        prev.next = head;
        head = prev;
        
        ListNode curr = head;
        while(curr.next != null) {
            ListNode runner = curr.next;
            //find all the duplicated elements
            while(runner.next!=null && runner.val == runner.next.val) {
                runner = runner.next;
            }
            if(curr.next != runner) {
                //delete them
                curr.next = runner.next;
            } else {
                curr = curr.next;
            }
        }
        return head.next;
    }
}
