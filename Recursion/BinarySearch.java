/**
 * This class provides an iterative and recursive version of the binary
 * search method that looks for a specified element in an array.
 * 
 * @author Khanh Nguyen
 * @version 11/9/23
 */
public class BinarySearch extends SearchAlgorithm{
    
    @Override
    /**
     * This method is the iterative version of a binary search,
     * which searches for a word from the beginning to the end of the 
     * array until found. 
     * @param words         Array of words
     * @param wordToFind    The target word
     * @return              The index where the word is found
     */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        super.resetCount();
        int leftIndex = 0;
        int rightIndex = words.length - 1;
        int midIndex = 0;

        if(words.length == 0) { //Check if the array is empty
            throw new ItemNotFoundException("Array is empty");
        }
        
        while(leftIndex <= rightIndex) {
            super.incrementCount();
            midIndex = (leftIndex + rightIndex) / 2;
            if(words[midIndex].equals(wordToFind)) {
                return midIndex;
            }
            if(wordToFind.compareTo(words[midIndex]) > 0) {
                leftIndex = midIndex + 1;
            }
            if(wordToFind.compareTo(words[midIndex]) < 0) {
                rightIndex = midIndex - 1;
            }
        }
        throw new ItemNotFoundException("Word not found");
    }

    @Override
    /**
     * This method is the recursive version of a binary search,
     * it utilizes another method in its recursive call.
     * @param words     The array of words
     * @param wordToFind    The target word
     * @return    The index where the word is found
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return recSearch(words, wordToFind, 0, words.length - 1);
    }

    /**
     * Private method that performs the recursive searching
     * @param words         Array of words
     * @param leftIndex     The left index
     * @param rightIndex    The right index
     * @param wordToFind    The target word
     * @return              The index where the word is found
     * @throws ItemNotFoundException    Thrown if word is not found
     */
    private int recSearch(String[] words, String wordToFind, int leftIndex, int rightIndex) throws ItemNotFoundException {
        super.resetCount();
        int midIndex = (leftIndex + rightIndex) / 2;

        if(leftIndex <= rightIndex) {
            super.incrementCount();
            if(words[midIndex].equals(wordToFind)) {
                return midIndex;
            }
            if(wordToFind.compareTo(words[midIndex]) > 0) {
                return recSearch(words, wordToFind, midIndex + 1, rightIndex);
            }
            if(wordToFind.compareTo(words[midIndex]) < 0) {
                return recSearch(words, wordToFind, leftIndex, midIndex - 1);
            }
        }
        throw new ItemNotFoundException("Word not found");
    }
}
