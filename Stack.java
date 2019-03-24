/**
 *
 * @author Osman Cetin
 */

public class Stack<Type> {

    private Type[] stack;
    private int size;

    /**
     * Returns size of stack
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
    *
    * default constructor
    */
    public Stack() {
        stack = (Type[])new Object[5];
        size=0;
    }

    /**
     * copy constructor
     *
     * @param obj
     */
    public Stack(Stack obj) {
        this.stack = (Type[]) obj.stack;
        this.size=obj.size;
    }

    /**
     * Puts a value on top of stack
     * @param element
     */
      public void push(Type element){

          if(size==stack.length){
              increaseCapacity();
          }
          stack[size]=element;
          size++;
      }

    /**
     *
     *  Removes the top value from stack and returns it.
     * @return top
     */
    public Type pop(){
        Type top;
        if(size==0){
            throw new ArrayIndexOutOfBoundsException();
        }

        top=stack[size-1];
        stack[size-1]=null;
        size--;
        return top;
    }

    /**
     * Returns but does not remove top of stack
     * @return top
     */
    public Type peek(){

        if(size==0){
            throw new ArrayIndexOutOfBoundsException();
        }

        return stack[size-1];
    }

    /**
     * Returns true if array is empty
     */
     public boolean isEmpty(){
            if(size==0) return true;
            else return false;
    }

    /**
     * This increases stacks capacitiy
     */
     public void increaseCapacity(){

         Type[] temp = (Type[])new Object[2* this.stack.length];

         for(int i=0;i<this.stack.length;i++){
            temp[i]=this.stack[i];
         }
         this.stack=temp;
     }

    /**
     *
     * Prints stack on screen
     */
     public void print(){
         for(int i=0;i<size;i++){

             System.out.print(stack[i]);
             System.out.print(" ");
         }
     }
}
