/*
  One Away: There are three types of edits that can be performed on strings: insert a character,
  remove a character, or replace a character. Given two strings, write a function to check if they are
  one edit (or zero edits) away.
  EXAMPLE
    pale, ple -) true
    pales, pale -) true
    pale, bale -) true
    pale, bae -) false
*/

package task5;

interface TaskSolution {
  boolean oneAway(String s, String t);
}

class Solution implements TaskSolution {

  public boolean oneAway(String s, String t) {
    boolean foundDifference = false;
    if(s.length() == t.length()) {
      for(int i = 0; i < s.length(); i++) {
        if(s.charAt(i) != t.charAt(i)) {
          if(foundDifference) {
            return false;
          }
          foundDifference = true;
        }
      }
      return true;
    }

    if(s.length() > t.length()) {
      String temp = s; s = t; t = temp;
    }

    if(s.length() != t.length() - 1) {
      return false;
    }

    for(int i = 0; i < s.length(); i++) {
      if(!foundDifference) {
        if(s.charAt(i) != t.charAt(i)) {
          foundDifference = true; --i;
        }
      }
      else {
        if(s.charAt(i) != t.charAt(i + 1)) {
          return false;
        }
      }
    }

    return true;
  }
}

public class Task {

  private TaskSolution taskSolution;

  private boolean oneAway(String s, String t) {
    return taskSolution.oneAway(s, t);
  }

  private void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  public static void main(String[] args) {
    String s = "pale";
    String t = "bae";

    Task task = new Task();

    task.setTaskSolution(new Solution());
    System.out.println(task.oneAway(s, t));
  }
}
