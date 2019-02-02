import java.util.Vector;

/**
 * Stack implementation
 * @param <E> DataType
 */
public class Pile<E> implements Stack<E> {
    /**
     * Vector with items to operate
     */
    private Vector<E> data;

    /**
     * Constructor to initialize a new Pile
     */
    public Pile() {
        // post: constructs a new, empty stack
        data = new Vector<>(2,0);
    }

    /**
     * To add an item to the pile
     * @param item object added to the stack
     */
    @Override
    public void push(E item) {
        // post: the value is added to the stack
        //       will be popped next if no intervening push
        {
            data.add(item);
        }
    }

    /**
     * To return the last item of the pile
     * @return the last item of the pile
     */
    @Override
    public E pop() {
        if(!this.data.isEmpty()){
            int size = data.size();
            return data.remove(size - 1);
        }
        return null;
    }

    /**
     * To get the next element
     * @return the next element of the pile
     */
    @Override
    public E peek() {
        return null;
    }

    /**
     * To check if there's not items present
     * @return false cos always have an element
     */
    @Override
    public boolean empty() {
        return false;
    }

    /**
     * Returns the size of the pile
     * @return number of the items in the pile
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Custom toString() method
     * @return displays custom pile info
     */
    @Override
    public String toString() {
        //TODO: get rid of this, it is just for tests
        return data.toString();
    }
}
