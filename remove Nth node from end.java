public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        ListNode curr = head;
        ListNode runner = head;
        for(int i = 0; i < n; i++) {
            runner = runner.next;
        }
        //Important. If the node to delete is the head
        if(runner == null) {
            return head.next;
        }
        while(runner != null && runner.next != null) {
            curr = curr.next;
            runner = runner.next;
        }
        if(curr.next != null) {
            curr.next = curr.next.next;
        } 
        return head;
    }

}
