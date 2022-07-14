package Stack;

public interface StackMethod<anyType> {
    public anyType push(anyType val);
    public anyType pop();
    public anyType top();
}
