package alda.tree;

/**
 *
 * Detta är den enda av de tre klasserna ni ska göra några ändringar i. (Om ni
 * inte vill lägga till fler testfall.) De ändringar som är tillåtna är dock
 * begränsade av följande:
 * <ul>
 * <li>Ni får INTE lägga till några fler instansvariabler.
 * <li>Ni får INTE lägga till några statiska variabler.
 * <li>Ni får INTE använda några loopar någonstans.
 * <li>Ni FÅR lägga till fler metoder, dessa ska då vara privata.
 * </ul>
 *
 * @author henrikbe
 *
 * @param <T>
 */
@SuppressWarnings("unused") // Denna rad ska plockas bort. Den finns här
// tillfälligt för att vi inte ska tro att det är
// fel i koden. Varningar ska normalt inte döljas på
// detta sätt, de är (oftast) fel som ska fixas.
public class BinarySearchTreeNode<T extends Comparable<T>> {

    private T data;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T data) {
        this.data = data;
    }

    public boolean add(T data) {
//Finns säkert ett snyggare sätt att göra denna!
        if(data==null){
            return false;
        }else if(this.data.compareTo(data)==0){
            return false; //Vet inte hur man skulle göra med dubletter

        }else if(this.data.compareTo(data)<0 && this.right!=null){
            return this.right.add(data);

        }else if(this.data.compareTo(data)<0 && this.right==null){
            right = new BinarySearchTreeNode<T>(data);

        }else if(this.data.compareTo(data)>0 && this.left!=null){
            return this.left.add(data);

        }else if(this.data.compareTo(data)<0 && this.left==null){
            left = new BinarySearchTreeNode<T>(data);

        }
        return false;
    }

    private T findMin() {

        if(this.left != null){
            return this.left.findMin();
        }
        return this.data;
    }

    public BinarySearchTreeNode<T> remove(T data) {




        return this;
    }

    public boolean contains(T data) {
        if(this.data==null){
            return false;
        }else if(this.data.compareTo(data)==0){
            return true;

        }else if(this.data.compareTo(data)<0){
            return this.right.contains(data);

        }else if(this.data.compareTo(data)>0){
            return this.left.contains(data);

        }


        return false;
    }

    public int size() {
        return 0;
    }

    public int depth() {
        return -1;
    }

    public String toString() {
        return "";
    }
}