package Node;

//链表的内容：当前节点的内容，连接到下一个节点，下一个节点的内容
public class Node {
    //当前节点的内容
    int data;
    //下一个节点
    Node next;

    public Node(int data) {
        this.data = data;
    }

    //连接下一个节点
    public Node append(Node node) {
        //当前节点
        Node currentNode = this;
        //循环向后找
        while (true) {
            if (currentNode.next == null) {
                break;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return this;
    }

    //获取下一个节点
    public Node next() {
        return this.next;
    }

    //获得节点的数据
    public int getData() {
        return this.data;
    }

    //查看当前节点是否是最后一个节点
    public boolean isLast() {
        return this.next == null;
    }

    //删除下一个节点
    public void removeNext() {
        //取出下下个节点
        Node newNode = next.next;
        //令下一个节点等于下一个节点
        this.next = newNode;
    }

    //在node后面插入一个节点
    public void insert(Node node) {
//        //这样子创建了一个新地址nextNext，所以接下来节点的内容都是nextnext的节点
//        Node newNext = this.next;
//        //令当前对象的下一个节点等于插入的节点
//        newNext = node;
//        //令插入的节点的下一个节点等于插入前的下一个节点
//        newNext.next = this.next;

        //取出下个节点作为下下个节点
        Node nextNext = this.next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把下下一个节点设置为新节点的下一个节点
        node.next = nextNext;
    }

    //展示所有的节点
    public void show() {
        Node currentNode = this;
        while (true) {
            if (currentNode == null) {
                break;
            }
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.next;
        }
    }
}
