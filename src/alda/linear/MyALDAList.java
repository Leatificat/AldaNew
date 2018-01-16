//Sebastian Söderblom sesd1880 och Hampus Larsson laha2282
package alda.linear;



import java.util.NoSuchElementException;
import java.util.Iterator;

public class MyALDAList<E> implements ALDAList<E>{



    private static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
        }


    }
// Start
    public Iterator<E> iterator(){

        MyIterator<E> it =  new MyIterator<E>();
        return it;
    }

    public class MyIterator<T> implements Iterator<E>{
        private Node<E> node = null;
        private Node<E> lastNode = null;
        private boolean removable = false;

        @Override
        public boolean hasNext() {

            if(size()!=0 && node == null){
                return true;
            }
            else if(node == last){
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            System.out.println("12");
            if(node == null && size() !=0){
                node = first;
                System.out.println(node.data);
                removable = true;
                return node.data;
            }

            else if(!hasNext())throw new NoSuchElementException();

            else{
                lastNode = node;
                node=node.next;
                System.out.println(node.data+"1");
                removable = true;
                return node.data;
            }

        }
        public void remove(){
            System.out.println(removable);
            if(!removable)throw new IllegalStateException();

            if(lastNode == null){
                first = node.next;
                System.out.println(first.data+"4");
                lastNode = null;
                node = null;
            }
            else{
                System.out.println(lastNode.data+ "3");
                lastNode.next = lastNode.next.next;
                node=lastNode;
            }
            removable = false;
        }
    }

    //Slut

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
        if(first == null){
            add(data);
        }
        if(i < 0 || i > size()){
            throw new IndexOutOfBoundsException();
        }
        else if(i == 0){
            Node<E> node = new Node<>(data);
            node.next = first;
            first = node;
        }
        else if(i<=size()){
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

    public E remove(int index){

        Node<E> temp = first;
        Node<E> temp2;
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        if(index ==0){
            first = first.next;
            return temp.data;

        }
        for(int c = 0; c < size(); c++){
            if(c == index -1){
                if(temp.next==last){
                    temp2 = temp.next;
                    temp.next = null;
                    last = temp;
                    return temp2.data;
                }
                else{
                    temp2 = temp.next;
                    temp.next = temp.next.next;
                    return temp2.data;
                }
            }
            else{
                temp = temp.next;
            }

        }
        return null;
    }

    public boolean remove(E element){
        int index = indexOf(element);
        if(index >=0){
            remove(index);
            return true;
        } else {
            return false;
        }

    }

    public E get(int index){
        Node<E> temp = first;
        if(first == null)throw new IndexOutOfBoundsException();
        if(index < 0  || index >= size())throw new IndexOutOfBoundsException();
        for(int c = 0; c<=index;c++){
            if(c == index){
                System.out.println(toString());
                System.out.println(temp.data+"45");
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

    public int indexOf(E element){
        int index = 0;
        if(!contains(element)) return -1;

        for(Node<E> temp = first; temp!= null; temp=temp.next){

            if(temp.data==element || temp.data.equals(element)){
                return index;
            }
            index++;
        }
        return index;
    }

    public void clear(){
        first = null;
        last = null;
    }

    public int size(){
        int value = 0;
        if(first == null) {
            return value;
        }

        for(Node<E> temp = first; temp.next != null; temp = temp.next){
            value++;
        }
        return ++value;
    }

    public String toString(){

        String values ="";
        for(Node<E> temp = first; temp!= null; temp=temp.next){
            values = values+temp.data;
            if(temp.next!=null){
                values = values + ", ";
            }

        }

        return "[" + values + "]";
    }


}
