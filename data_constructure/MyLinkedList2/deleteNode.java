package MyLinkedList2;
/*
删除链表中的节点
 */
public class deleteNode {
    public void deleteNode(ListNode node) {
        while(node.next.next!=null){
            node.val=node.next.val;
            node=node.next;
        }
        node.val= node.next.val;
        node.next=null;
    }
}
