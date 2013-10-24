    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode n = new ListNode(head.val);
        ListNode sublist = reverseList(head.next);
        sublist.next = n;
        return sublist;
    }
    
    public ListNode reverseIter(ListNode head) {
        ListNode n = head; ListNode newtail = null;
        while(n != null) {
            ListNode next = n.next;
            n.next = newtail;
            newtail = n;
            n = next;
        }
        return newtail;
    }
