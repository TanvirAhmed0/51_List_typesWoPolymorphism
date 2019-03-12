/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

    // declare fields here
    private int[] intHolder;
    private int size;
    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
      intHolder = new int[10];
      size = 0;
    }


    /** 
      @return the number of elements in this list
     */
    public int size() {
      return size;
    }


     /** 
       @return a string representation of this list,
       in [a,b,c,] format
      */ 
    public String toString() {
        String finalString = "[";
        for(int counter = 0; counter < size; counter ++) 
            finalString += Integer.toString(intHolder[counter]) + ",";
        finalString += "]";
        return finalString;
    }

    
    /** 
      Appends @value to the end of this list.
      
      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int value) {
      size++;
      if(size == intHolder.length){
        expand();
      } 
        intHolder[size - 1] = value;
      return true;
     }


    /** 
      Double the capacity of the List_inArraySlots, 
      preserving existing data
     */
      private void expand() {
        int[] extraHolder = new int[size];
        for(int index = 0; index < size; index ++){
            extraHolder[index] = intHolder[index];
          }
        intHolder = new int[size + 10];
        for(int index = 0; index < size; index ++){
          intHolder[index] = extraHolder[index];
        }
         //System.out.println( "expand... (for debugging)");
           // /* S.O.P. rules for debugging:
              // Working methods should be silent. But during 
              // development, the programmer must verify that 
              // this method is called when that is appropriate.
              // So test using the println(), then comment it out.
              // */
      }

          /**
      accessor
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether user violated the condition.)
     */
    public int get( int index ) {
      return intHolder[index];
    }


    /**
      Set value at @index to @newValue
      @return old value at @index
      @precondition: @index is within the bounds of this list.
     */
    public int set( int index, int newValue ) {
      int oldValue = intHolder[index];
      intHolder[index] = newValue;
      return oldValue;
    }


    /**
      Insert @value at position @index in this list.
      Shift the element currently at that position (if any)
      and any subsequent elements to the right
      (that is, increase the index associated with each).
     */
     public void add( int index, int value){ 
       if (size == intHolder.length){
         expand();
       }
       for(int targetIndex = size; targetIndex > index; targetIndex --){
         set(targetIndex, intHolder[targetIndex - 1]);
       }
       set(index, value);
       size ++;
     }


    /**
      Remove the element at position @index in this list.
      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).
      @return the value that was removed from the list
     */
     public int remove( int index) {
      int removedInt = intHolder[index];
      remove(index, size);
      size --;
      return removedInt;
     }

    private void remove(int index, int size){
      if(index == size - 1){
        //System.out.println("Replacing " + intHolder[index] + " with "  + 0);
        set(index, size);
      }
      else{
        remove(index, size - 1);
        /**
         * debugging stuff
         */
        //System.out.println("Replacing " + intHolder[size - 2] + " with " + intHolder[size - 1]);
        //System.out.println(toString());
        set(size - 2, intHolder[size - 1]);
      } 
    }
}
