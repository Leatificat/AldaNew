package alda.linear;

//kommentaar

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
        private Node<E> node = first;

        @Override
        public boolean hasNext() {
            if(node.next ==null){
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            if(!hasNext()){throw new IndexOutOfBoundsException();

            }else{
                return node.data;
            }
        }
    }

    //Slut

    private Node<E> first;
    private Node<E> last;

    public MyALDAList(){

    }

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

        else if(i == 0){
            Node<E> node = new Node<>(data);
            node.next = first;
            first = node;
        }

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

    public E remove(int index){
        if(first == null){
            throw new IndexOutOfBoundsException();
        }

        if(index ==0){
            first = first.next;
        }
        Node<E> temp = first;
        Node<E> temp2;
        for(int c = 0; c < size(); c++){
            if(c == index-1){
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
//Kanske borde va annat exception, är inte säker
        if(!contains(element)) throw new NoSuchElementException("No such element in list!");

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
