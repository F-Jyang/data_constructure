package MyLinkedList2;

public class ListNode {
    ListNode next;
    ListNode prev;
    int val;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
    public ListNode(int val,ListNode prev){
        this.val=val;
        this.prev=prev;
    }
}
