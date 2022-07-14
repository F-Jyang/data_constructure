package Node;

public class TestNode {
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);

        //两种方式只能选一种，debug会发现两种方式一起的时候会出现死循环
//        n1.append(n2);
//        n1.append(n3);
        n1.append(n2).append(n3).append(new Node(4));

        System.out.println(n1.isLast());
        System.out.println(n3.isLast());


        n1.removeNext();
        n1.insert(new Node(5));
        n1.show();


    }
}
