package lab8;

public class TitanProbeHashMap<K,V> extends LinearProbingHashTable<K,V> {
    public TitanProbeHashMap(int N){
        super(N);
    }
    @Override
    public String toString(){
        String resultString = "";
        for( int i = 0; i < tableSize; i++){
            if ( keys[i] == null ){
                resultString += "E";
            }
            else{
                resultString += "O";
            }
            
        }
        return resultString;
    }
    /**
     * Computes average search miss cost of this object
     * @return The average search miss cost in a given hashtable, based on which indexes are full and empty
     * @throws Exception An exception shouldn't really get thrown from this method, it is however for the overloaded version
     */
    public double empiricalAverageSearchMissCost() throws Exception{
        return empiricalAverageSearchMissCost(this.toString());
    }
    
    /**
     * Computes average search miss cost of a given string representing a hashtable
     * @param tableCells
     * @return The average search miss cost in a given hashtable, based on which indexes are full and empty
     * @throws Exception If part of the string isn't an O, E, or newline character
     */
    public double empiricalAverageSearchMissCost(String tableCells) throws Exception{
        int numChecks = 0;  // Total number of checks
        boolean occFound;   // This is actually meant to be EmptyFound, but I only realized that after writing it all
                            // occFound identifies when to move on to the next character in the string, IE when an empty is found
        int checkedAll;     // Used in case of a string like "OOOOOO" where there will never be an empty.
        int newLineSize = 0;// used to remove newline characters from the final average calculation
        int j;
        int i;
        char[] cells = tableCells.toCharArray();    //Converting to array for easier usage
        for ( i = 0; i < cells.length; i++){        //For every element in the string, iterate
            occFound = false;                       //Initially starts looking for empty
            j = i;                                  //Starts at current index
            checkedAll = 0;                              
            while ( ! occFound ){                   //While it isn't an empty cell
                if ( j == cells.length){            //Go to the beginning of the array once the end is reached
                    j = 0;
                }
                if( cells[j] == 'O'){               //Occupied cell, check the next
                    j++;
                    numChecks++;                    //Adding check
                    checkedAll++;   
                }
                else if (cells[j] == 'E'){          //Empty cell, count a check but do not continue checking
                    j++;
                    numChecks++;
                    occFound = true;
                }
                else if ( cells[j] == '\n'){        //Ignoring newlines
                    j++;
                    newLineSize++;                  //Used to subtract from total length at the end
                }
                else{
                    throw new Exception();          //shouldnt be any other options, invalid string, throw an exception
                }

                if ( checkedAll == cells.length){
                    occFound = true;                //Used if all elements are "O" to break the loop
                }
            }
        }
        return numChecks / ((double)cells.length - newLineSize); // total checks divided by the number of cells that aren't newlines
    }
}
