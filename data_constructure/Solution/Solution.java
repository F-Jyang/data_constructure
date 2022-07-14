package Solution;


public class Solution {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }

    public static int lastRemaining(int n, int m) {
        MyLinkedList mylist = new MyLinkedList();
        ListNode curr = mylist.head;
        ListNode last = mylist.head;
        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
            last = curr;
        }
        curr.next = mylist.head;
        curr = mylist.head;
        //得到当前节点的前一个节
        while (curr.next != curr) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    ListNode temp = curr.next;
                    last.next = temp;
                    curr = temp;
                }
            } else {
                ListNode pre = mylist.head;
                ListNode succ = mylist.head;

                for (int i = 0; i < m - 1; i++) {
                    pre=curr;
                    curr = curr.next;
                    succ=curr.next;
                }
                pre.next=succ;
                curr=succ;
            }
        }
        return curr.val;
    }
}

class MyLinkedList {
    private int size;
    ListNode head = new ListNode(0);
//    public void addLast(int val){
//        ListNode node=new ListNode(val);
//        ListNode curr=head;
//        curr.next=node;
//    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}


