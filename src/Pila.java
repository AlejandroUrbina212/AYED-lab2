import java.util.ArrayList;

public class Pila<E> implements Stack<E> {
    private ArrayList<E> data;

    public Pila() {
        // post: constructs a new, empty stack
        data = new ArrayList<>();
    }

    @Override
    public void push(E item) {
        // post: the value is added to the stack
        //       will be popped next if no intervening push
        {
            data.add(item);
        }
    }

    @Override
    public E pop() {
        if(!this.data.isEmpty()){
            int size = data.size();
            return data.remove(size - 1);
        }
        return null;
    }


    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        //TODO: get rid of this, it is just for tests
        return data.toString();
    }
}
