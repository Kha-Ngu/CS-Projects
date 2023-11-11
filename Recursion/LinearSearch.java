/**
 * This class provides an iterative and recursive version of the linear
 * search method that looks for a specified element in an array.
 * 
 * @author Khanh Nguyen
 * @version 11/9/23
 */
public class LinearSearch extends SearchAlgorithm {
    
    @Override
    /**
     * Uses the linear search method to search for word from
     * beginning to end of the array until found.
     * @param words Array of words
     * @param wordToFind    target word
     * @return      The index of the word
     * @throws ItemNotFoundException    thrown when word is not found
     */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        super.resetCount();
        if(words.length == 0) { //Check if array is empty
            throw new ItemNotFoundException("Array is empty");
        }
        for(int i = 0; i < words.length; i++) {
            super.incrementCount();
            if(words[i].equals(wordToFind)) {
                return i;
            }
        }
        throw new ItemNotFoundException("Word is not found");
    }

    @Override
     /**
     * Recursive search version for Linear search.
     * @param words     Array of words
     * @param wordToFind    Target word
     * @return  The index of the word
     * @throws ItemNotFoundException    thrown when word is not found
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException{
        super.resetCount();
        return recSearch(words, wordToFind, 0); 
    }
    
    /**
     * Private method where the searching is done.
     * @param words     Array of words
     * @param wordToFind    Target word
     * @param index     The index where we want to start the search
     * @return The index of the word.
     * @throws ItemNotFoundException    thrown when word is not found
     */
    private int recSearch(String[] words,String wordToFind, int index) throws ItemNotFoundException{
        super.incrementCount();
        if(words[index].equals(wordToFind)) {
            return index;
        }
        else if (words.length == index) {
            throw new ItemNotFoundException("Word not found.");
        }
        else {
            return recSearch(words, wordToFind, index + 1); //Recursive call that goes to the next index
        }
    }

    /**
     * REPORT RESULT:
     * - When the iterative version is ran, the program works as expected.
     * - When the recursive version is ran, the linear search encounters stack
     *   overflow because the longwords.txt file is simply too big, so the 
     *   stack cannot handle that many recursive calls. To fix this we 
     *   would have to increase our stack size.
     */
}
