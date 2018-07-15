/*
    Palindrome Permutation: Given a string, write a function to check if it is a permutation of
    a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
    permutation is a rearrangement of letters. The palindrome does not need to be limited to just
    dictionary words.
    EXAMPLE
    Input: Tact Coa
    Output: True (permutations:"taco cat'; "atco cta'; etc.)
*/

package template;

interface TaskSolution {
  boolean functionName();
}

class Solution1 implements TaskSolution {
  public boolean functionName() { return true; }
}

class Solution2 implements TaskSolution {
  public boolean functionName() { return false; }
}

public class Task {

  private TaskSolution taskSolution;

  private boolean functionName() {
    return taskSolution.functionName();
  }

  private void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  public static void main(String[] args) {
    //Scanner scanner = new Scanner(System.in);
    //String s = "abecd"; //String s = scanner.next();

    Task task = new Task();

    task.setTaskSolution(new Solution1());
    System.out.println(task.functionName());

    task.setTaskSolution(new Solution2());
    System.out.println(task.functionName());
  }
}
