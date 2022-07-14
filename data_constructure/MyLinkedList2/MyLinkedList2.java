package MyLinkedList2;


public class MyLinkedList2 {
    private int size;
    private ListNode head;
    private ListNode tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public ListNode getCurrentNode(int index){
        if (index < 0 || index >= size) {
            return null;
        }
        ListNode curr = head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if(index<0){
            index=0;
        }
        ListNode curr=head;
        for (int i = 0; i < index+1; i++) {
            curr=curr.next;
        }
        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.next = curr;
        toAdd.prev = curr.prev;
        curr.prev.next = toAdd;
        curr.prev = toAdd;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        ListNode curr=getCurrentNode(index);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }
}