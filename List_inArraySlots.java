/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

    private int[]    intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of elements in this list
    
    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
      intElements = new int[INITIAL_CAPACITY];
      doubleElements = new double[INITIAL_CAPACITY];
      stringElements = new String[INITIAL_CAPACITY];
      typeOfElements = new int[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */

    public int size() {
        return filledElements;
     }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
     public String toString() {
       String returnString = "[";
       for(int index = 0; index < filledElements; index ++){
         if(typeOfElements[index] == 0) returnString = returnString + intElements[index] + ",";
         else if(typeOfElements[index] == 1) returnString = returnString + doubleElements[index] + ",";
         else if(typeOfElements[index] == 2) returnString = returnString + stringElements[index] + ",";
       }
       returnString = returnString + "]";
       return returnString;
     }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int    intValue
                       , double doubleValue
                       , String stringValue
                       ) {
        filledElements++;
        if(filledElements == typeOfElements.length){
            expand();
        }
        
        else if (type == 0) {
            typeOfElements[filledElements - 1] = 0;
            intElements[filledElements - 1] = intValue;
        }
        
        else if (type == 1) {
            typeOfElements[filledElements - 1] = 1;
            doubleElements[filledElements - 1] = doubleValue;
        }
        
        else if (type == 2) {
            typeOfElements[filledElements - 1] = 2;
            stringElements[filledElements - 1] = stringValue;
        }
        
        return true;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
        //expanding typeOfElements
        int[] extraHolder = new int[filledElements];
        for(int index = 0; index < filledElements; index ++){
            extraHolder[index] = typeOfElements[index];
          }
        typeOfElements = new int[filledElements + 10];
        for(int index = 0; index < filledElements; index ++){
          typeOfElements[index] = extraHolder[index];
        }
        
        //expanding intElements
        int[] intExtraHolder = new int[filledElements];
        for(int index = 0; index < filledElements; index ++){
            intExtraHolder[index] = intElements[index];
          }
        typeOfElements = new int[filledElements + 10];
        for(int index = 0; index < filledElements; index ++){
          intElements[index] = intExtraHolder[index];
        }
        
        //expanding doubleElements
        double[] doubleExtraHolder = new double[filledElements];
        for(int index = 0; index < filledElements; index ++){
            doubleExtraHolder[index] = doubleElements[index];
          }
        typeOfElements = new int[filledElements + 10];
        for(int index = 0; index < filledElements; index ++){
          doubleElements[index] = doubleExtraHolder[index];
        }
        
        //expanding stringElements
        String[] stringExtraHolder = new String[filledElements];
        for(int index = 0; index < filledElements; index ++){
            stringExtraHolder[index] = stringElements[index];
          }
        typeOfElements = new int[filledElements + 10];
        for(int index = 0; index < filledElements; index ++){
          stringElements[index] = stringExtraHolder[index];
        }
        System.out.println( "expand... (for debugging)");
           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
     }
}
