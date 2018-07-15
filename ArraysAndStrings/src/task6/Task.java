/*
  String Compression: Implement a method to perform basic string compression using the counts
  of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
  "compressed" string would not become smaller than the original string, your method should return
  the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

package task6;

interface TaskSolution {
  String compressString(String s);
}

class Solution implements TaskSolution {
  public String compressString(String s) {
    int i = 0; int count;
    StringBuilder compressedStringBuilder = new StringBuilder();
    while(i != s.length()) {
      count = 1;
      while(s.charAt(i) == s.charAt(i + 1)) {
        ++count; ++i;
        if(i == s.length() - 1) {
          break;
        }
      }
      compressedStringBuilder.append(s.charAt(i));
      compressedStringBuilder.append((char) (count + '0'));
      ++i;
    }
    String compressedString = compressedStringBuilder.toString();
    if(s.length() <= compressedString.length()) {
      return s;
    }
    else {
      return compressedString;
    }
  }
}

public class Task {

  private TaskSolution taskSolution;

  private String compressString(String s) {
    return taskSolution.compressString(s);
  }

  private void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  public static void main(String[] args) {
    String s = "aarraddfdaaaadddddbcccccaaa";
    Task task = new Task();

    task.setTaskSolution(new Solution());
    System.out.println(task.compressString(s));
  }
}
