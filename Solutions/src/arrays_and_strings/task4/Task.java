/*
    Palindrome Permutation: Given a string, write a function to check if it is a permutation of
    a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
    permutation is a rearrangement of letters. The palindrome does not need to be limited to just
    dictionary words.
    EXAMPLE
    Input: Tact Coa
    Output: True (permutations:"taco cat'; "atco cta'; etc.)
*/

package arrays_and_strings.task4;


interface TaskSolution {
    boolean isPalindromePermutation(String s);
}

class SolutionUsingHashTable implements TaskSolution {

  private int[] createFrequencyTable(String s) {

    int[] frequencyTable = new int[(int) 'z' - (int) 'a' + 1];

    for(int i = 0; i < s.length(); i++) {

      int charIndex = s.charAt(i) - 'a';

      if(0 <= charIndex && charIndex <= ('z' - 'a')) {
        ++frequencyTable[charIndex];
      }
    }

    return frequencyTable;
  }
  public boolean isPalindromePermutation(String s) {

    System.out.println("Solution using HashTable. Time complexity: O(n). Space complexity: O(1).");

    int[] frequencyTable = createFrequencyTable(s);

    boolean foundOddNumber = false;

    for(int i = 0; i < frequencyTable.length; i++) {

      if(frequencyTable[i] % 2 == 1) {

        if(foundOddNumber) {
          return false;
        }

        foundOddNumber = true;
      }

    }
    return true;
  }
}

class SolutionUsingHashTableImprovement implements TaskSolution {

  public boolean isPalindromePermutation(String s) {

    System.out.println("Solution using HashTable (improvement). Time complexity: O(n). Space complexity: O(1).");

    int[] frequencyTable = new int[(int) 'z' - (int) 'a' + 1];

    int countOddNumbers = 0;

    for(int i = 0; i < s.length(); i++) {

      int charIndex = s.charAt(i) - 'a';

      if(0 <= charIndex && charIndex <= ('z' - 'a')) {

        ++frequencyTable[charIndex];

        if(frequencyTable[charIndex] % 2 == 1) {
          ++countOddNumbers;
        }
        else {
          --countOddNumbers;
        }
      }
    }

    return countOddNumbers <= 1;
  }
}

class SolutionUsingBitVectors implements TaskSolution {

  int toggle(int bitVector, int index) {

    if(index < 0) {
      return bitVector;
    }

    int mask = 1 << index;

    if((bitVector & mask) == 0) {
      bitVector |= mask;
    }
    else {
      bitVector &= ~mask;
    }

    return bitVector;
  }

  public boolean isPalindromePermutation(String s) {

    System.out.println("Solution using BitVectors. Time complexity: O(n). Space complexity: O(1).");

    int oddNumberOfAppearances = 0;

    for(int i = 0; i < s.length(); i++) {

      int charIndex = s.charAt(i) - 'a';

      if(0 <= charIndex && charIndex <= ('z' - 'a')) {
        oddNumberOfAppearances = toggle(oddNumberOfAppearances, charIndex);
      }
    }

    return (oddNumberOfAppearances & (oddNumberOfAppearances - 1)) == 0 || oddNumberOfAppearances == 0;
  }
}

public class Task {

  private TaskSolution taskSolution;

  private boolean isPalindromePermutation(String s) {
      return taskSolution.isPalindromePermutation(s);
  }

  private void setTaskSolution(TaskSolution taskSolution) {
      this.taskSolution = taskSolution;
  }

  public static void main(String[] args) {

    String s = "aadaadd";
    Task task = new Task();

    task.setTaskSolution(new SolutionUsingHashTable());
    System.out.println(task.isPalindromePermutation(s));

    task.setTaskSolution(new SolutionUsingHashTableImprovement());
    System.out.println(task.isPalindromePermutation(s));

    task.setTaskSolution(new SolutionUsingBitVectors());
    System.out.println(task.isPalindromePermutation(s));
  }
}
