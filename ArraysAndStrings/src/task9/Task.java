/*
  String Rotation: Assume you have a method i5Substring which checks ifone word is a substring
  of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
  call to isSubstring (e.g., "waterbottle" a rotation "erbottlewat" ).
*/

package task9;

interface TaskSolution {
  boolean stringRotation(String s, String t);
}

class Solution implements TaskSolution {
  public boolean stringRotation(String s, String t) {
    if(s.length() != t.length() || s.length() == 0) {
      return false;
    }
    String duplicateString = t + t;
    return duplicateString.contains(s);
  }
}

public class Task {

  private TaskSolution taskSolution;

  private boolean stringRotation(String s, String t) {
    return taskSolution.stringRotation(s, t);
  }

  private void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  public static void main(String[] args) {
    String s = "waterbottle";
    String t = "erbottlewat";

    Task task = new Task();
    task.setTaskSolution(new Solution());
    System.out.println(task.stringRotation(s, t));
  }
}
