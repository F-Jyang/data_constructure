package HashTable;

//哈希值用来确定索引，equals方法用来确定链表的key值
public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {//链表节点
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
            /*if (get(key) != null) {//当key存在时
                Node node = first;
                while (node != null) {
                    if (node.key.equals(key)) {
                        node.value = value;
                        break;
                    }
                    node = node.next;
                }
            } else {//当key不存在时
                Node node = first;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = new Node(key, value, null);
            }*/
        for (Node node = first; node != null; node = node.next) {
            if (node.key.equals(key)) {//命中
                node.value = value;
                return;
            }
        }
        first = new Node(key, value, first);//未命中
    }
    public void remove(Key key){//这里的删除并不是删除节点，而是将键对应的值改为null
        for (Node node=first; node!=null ; node=node.next) {
            if(node.key.equals(key)) {
                node.value=null;
                return;
            }
        }
    }
}

