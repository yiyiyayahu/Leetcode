//First build a cycle: let the tail points to the head and we also know the length of the list
//Then from the tail, move (len - n%len) steps to reach the newtail, break the linked list
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return null;
        if(n == 0) return head;
        ListNode curr = head;
        int len = 1;
        while(curr.next != null) {
            curr = curr.next;
            len ++;
        }
        curr.next = head;
        
        for(int i = 0; i < (len - n%len); i++) {
            curr = curr.next;
        }
        ListNode newhead = curr.next;
        curr.next = null;
        return newhead;
    }
}
