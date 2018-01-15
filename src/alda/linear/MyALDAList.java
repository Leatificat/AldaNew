package alda.linear;

//ladidiadido

public class MyALDAList<E>{



    private static class Node<E>{
        E data;
        Node<E> next;

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
        else {
            last.next = new Node<>(data);
            last = last.next;
        }
    }

    public void add(int i, E data){
        //kanske fungerar
        if(i==0 && first == null)
            add(data);
        else if(i<size()){
            Node<E> temp = first;
            for(int c = 0; c<i+1; c++){
                if(c==i-1){
                    Node<E> node = new Node<>(data);
                    node.next = temp.next;
                    temp.next = node;
                }
                else{
                    temp = temp.next;
                }
            }
        }
        else{
            add(data);
        }
    }

    public E get(int index){
        Node<E> temp = first;
        for(int c = 0; c<=index;c++){
            if(c == index){
                return temp.data;
            }
            else{
                temp = temp.next;
            }
        }
        return null;
    }

    public boolean contains(E element){
        for(Node<E> temp = first; temp!= null; temp=temp.next){
            if(temp.data==element || temp.data.equals(element)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        first = null;
        last = null;
    }

    public int size(){
        int value = 0;
        if(first == null)
            return value;
        for(Node<E> temp = first; temp.next != null; temp = temp.next){
            value++;
        }
        return value;
    }

}
