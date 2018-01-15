package alda.linear;

public class MyALDAList<E>{



    private static class Node<E>{
        E data;
        Node next;

        public Node(E data){
            this.data = data;
        }
    }

    private Node<E> first;
    private Node<E> last;

    public void add(E data){
        if(first == null){
            first = new Node<>(data);
            last = first;
        }
    }

}
