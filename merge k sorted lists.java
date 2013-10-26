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

//use a heap to help sort the linked lists
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
                public int compare(ListNode n1, ListNode n2) {
                    if(n1.val < n2.val) return -1;
                    else if(n1.val == n2.val) return 0;
                    else return 1;
                }
            });
        for(ListNode node:lists) {
            if(node != null) heap.add(node);
        }
        ListNode head = null;
        ListNode curr = null;
        while(!heap.isEmpty()) {
            if(head == null) {
                head = heap.poll();
                curr = head;
            } else {
                curr.next = heap.poll();
                curr = curr.next;
            }
            if(curr.next != null) heap.add(curr.next);
        }
        return head;
    }
}
