package Lists;

public class Node {
    private SodiacKnight knight;
    private Node next;

    public Node(SodiacKnight knight) {
        this.knight = knight;
        this.next=null;
    }

    public SodiacKnight getKnight() {
        return knight;
    }

    public void setKnight(SodiacKnight knight) {
        this.knight = knight;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
