/*
    Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    column are set to 0.
*/

//TODO Check solution that uses O(1) space

package arrays_and_strings.task8;

interface TaskSolution {
  int[][] zeroMatrix(int[][] matrix);
}

class Solution implements TaskSolution {

  private void deleteRow(int[][] matrix, int index) {
    for(int i = 0; i < matrix.length; i++) {
      matrix[index][i] = 0;
    }
  }

  private void deleteColumn(int[][] matrix, int index) {
    for(int i = 0; i < matrix.length; i++) {
      matrix[i][index] = 0;
    }
  }

  public int[][] zeroMatrix(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    boolean[] rows = new boolean[n];
    boolean[] columns = new boolean[m];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(matrix[i][j] == 0) {
          rows[i] = true;
          columns[j] = true;
        }
      }
    }

    for(int i = 0; i < rows.length; i++) {
      if(rows[i]) {
        deleteRow(matrix, i);
      }
    }

    for(int i = 0; i < columns.length; i++) {
      if(columns[i]) {
        deleteColumn(matrix, i);
      }
    }

    return matrix;
  }
}

public class Task {

  private TaskSolution taskSolution;

  private int[][] zeroMatrix(int[][] matrix) {
    return taskSolution.zeroMatrix(matrix);
  }

  private void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  private static void printMatrix(int[][] matrix) {
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3, 0}, {0, 3 ,4, 5}, {12, 34 , 6, 1}, {44, 22, 1, 5}};
    Task task = new Task();
    task.setTaskSolution(new Solution());
    printMatrix(task.zeroMatrix(matrix));
  }
}
