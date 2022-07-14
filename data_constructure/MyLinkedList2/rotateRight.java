package MyLinkedList2;
public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        ListNode node=head;
        int size=1;//链表长度
        while (node.next!=null){//得到链表长度，并将node指向最后一个节点
            node=node.next;
            size++;
        }
        node.next=head;//将链表连成一个环
        //走了k步之后链表的最后一个节点应该是size-k%size-1(对于环的问题经常用到mod)
        for (int i = 0; i <size-k%size-1; i++) {
            head=head.next;
        }
        node=head;
        head=head.next;
        node.next=null;
        return head;
    }
}
