/**
 * @param <E> DataType of the Stack
 */
public interface Stack<E> {

   /**
    * @param item object added to the stack
    */
   public void push(E item);
   // pre: 
   // post: item is added to stack
   // will be popped next if no intervening push

   /**
    * @return the last item of the stack
    */
   public E pop();
   // pre: stack is not empty
   // post: most recently pushed item is removed and returned

   /**
    * @return top value of the stack
    */
   public E peek();
   // pre: stack is not empty
   // post: top value (next to be popped) is returned


   /**
    * @return true if stack is empty
    */
   public boolean empty();
   // post: returns true if and only if the stack is empty

   /**
    * @return the number of elements in the stack
    */
   public int size();
   // post: returns the number of elements in the stack

}