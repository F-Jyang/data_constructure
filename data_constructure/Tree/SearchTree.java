package Tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class SearchTree<anyType extends Comparable<? super anyType>> {
    private BinaryNode<anyType> root;
    private Comparator<? super anyType> cmp;

    public SearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(anyType x) {
        return contains(x, root);
    }

    public boolean contains(anyType x, BinaryNode<anyType> t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.theElement);
        if (compareResult == 0) {
            return true;
        } else if (compareResult > 0)
            return contains(x, t.right);
        else
            return contains(x, t.left);
    }

    public anyType findMax() {
        if (isEmpty()) throw new NullPointerException();
        return findMax(root).theElement;

    }

    public BinaryNode<anyType> findMax(BinaryNode<anyType> t) {
        if (t == null) return null;
        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    public anyType findMin() {
        if (isEmpty()) throw new NullPointerException();
        return findMin(root).theElement;
    }

    public BinaryNode<anyType> findMin(BinaryNode t) {
        if (t == null) return null;
        else if (t.left == null) return t;
        return findMin(t.left);
    }

    public void insert(anyType x) {
        insert(x,root);
    }

    public BinaryNode<anyType> insert(anyType x, BinaryNode<anyType> t) {
        if (t == null) return new BinaryNode<anyType>(x, null, null);
        int compareResult = x.compareTo(t.theElement);
        if (compareResult > 0) t.right=insert(x,t.right);
        else if(compareResult<0)t.left=insert(x,t.left);
        else ;
        return t;
    }

    public void remove(anyType x) {
        remove(x,root);
    }
    public BinaryNode<anyType> remove(anyType x,BinaryNode<anyType> t){
        if(t==null)return t;
        int compareResult=x.compareTo(t.theElement);
        if(compareResult>0) t.right=remove(x,t.right);
        else if(compareResult<0) t.left=remove(x,t.left);
        else if(t.left!=null&&t.right!=null){
            t.theElement=findMin(t.right).theElement;
            t.right=remove(t.theElement,t.right);
        }
        else t=(t.left!=null)?t.left:t.right;
        return t;
    }

    private int myCompare(anyType lhs, anyType rhs) {
        if (cmp != null) return cmp.compare(lhs, rhs);
        else return ((Comparable) lhs).compareTo(rhs);
    }

    private static class BinaryNode<anyType> {
        BinaryNode(anyType element) {
            this(element, null, null);
        }

        BinaryNode(anyType element, BinaryNode<anyType> lt, BinaryNode<anyType> rt) {
            theElement = element;
            left = lt;
            right = rt;
        }

        BinaryNode<anyType> left;
        BinaryNode<anyType> right;
        anyType theElement;
    }
}

