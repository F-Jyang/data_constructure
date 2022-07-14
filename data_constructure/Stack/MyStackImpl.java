package Stack;

public interface MyStackImpl<E extends Comparable<E>> {
    public E push(E val);

    public E pop();

    public E peek();

    public boolean empty();

    public int search(E val);

    public int size();
}
