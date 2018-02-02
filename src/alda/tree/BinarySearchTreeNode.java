//Sebastian Söderblom sesd1880 och Hampus Larsson hala2282
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
// Denna rad ska plockas bort. Den finns här
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

        if(data==null){
            return false;
        }else if(this.data.compareTo(data)==0){
            return false;

        }else if(data.compareTo(this.data)>0 && this.right==null){
            right = new BinarySearchTreeNode<T>(data);
            return true;


        }else if(data.compareTo(this.data)>0 && this.right!=null){
            return right.add(data);

        }else if(data.compareTo(this.data)<0 && this.left==null){
            left = new BinarySearchTreeNode<T>(data);
            return true;


        }else if(data.compareTo(this.data)<0 && this.left!=null){
            return left.add(data);

        }
        return false;
    }

    private T findMin() {

        if(this.left != null){
            return this.left.findMin();
        }
        return this.data;
    }

    private T findMax(){

        if(this.right!= null){
            return this.right.findMax();
        }
        return this.data;
    }

    public BinarySearchTreeNode<T> remove(T data) {


        if(data.compareTo(this.data)<0 && left!= null){
            left = left.remove(data);

        }else if(data.compareTo(this.data)>0 && right!=null){
            right = right.remove(data);

        }else if(data.compareTo(this.data) == 0){


            if(left!=null){

                this.data = left.findMax();
                left = left.remove(this.data);

            }else if(right != null){

                this.data = right.findMin();
                right = right.remove(this.data);
            }else{
                return null;
            }



        }

        return this;




    }

    public boolean contains(T data) {
        if(data==null){
            return false;
        }else if(this.data.compareTo(data)==0){
            return true;

        }else if(this.data.compareTo(data)<0 && right != null){
            return this.right.contains(data);

        }else if(this.data.compareTo(data)>0 && left!= null){
            return this.left.contains(data);

        }


        return false;
    }

    public int size() {

        int size = 1;
        if( left != null){

            size += left.size();
        }
        if(right != null){
            size += right.size();

        }

        return size;

    }

    public int depth() {
        if (left == null && right != null) {

            return 1 + right.depth();

        } else if (right == null && left != null) {

            return 1 + left.depth();

        } else if (left == null && right == null){

            return 0;

        }else{
            return 1 + left.depth() + right.depth();
        }
    }

    public String toString() {

        if (left == null && right != null) {

            return data + ", " + right.toString();

        } else if (right == null && left != null) {

            return left.toString() + ", " + data;

        } else if (left == null && right == null){

            return data.toString();

        }else{
            return left.toString() + ", " + data + ", " + right.toString();
        }



    }

}