//merge sort
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        ListNode l1 = lists.get(0);
        for(int i = 1; i < lists.size(); i++) {
            l1 = mergeTwoLists(l1, lists.get(i));
        }
        return l1;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode head = new ListNode(0);
        ListNode ret = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l1 != null) head.next = l1;
        else head.next = l2;
        return ret.next;
    }
}
