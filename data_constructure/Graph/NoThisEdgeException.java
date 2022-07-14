package Graph;

class NoThisEdgeException extends Exception {
    public NoThisEdgeException() {
    }

    public NoThisEdgeException(String msg) {
        super(msg);
    }
}
