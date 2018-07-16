/*
  Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
  bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
*/

package arrays_and_strings.task7;

interface TaskSolution {
  int[][] rotateMatrix(int[][] matrix);
}

class Solution implements TaskSolution {
  public int[][] rotateMatrix(int[][] matrix) {
    int n = matrix.length;
    for(int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;
      for(int i = first; i < last; i++) {
        int offset = i - first;
        int top = matrix[first][i];
        matrix[first][i] = matrix[last - offset][first];
        matrix[last - offset][first] = matrix[last][last - offset];
        matrix[last][last - offset] = matrix[i][last];
        matrix[i][last] = top;
      }
    }
    return matrix;
  }
}

public class Task {

  private TaskSolution taskSolution;

  private int[][] rotateMatrix(int[][] matrix) {
    return taskSolution.rotateMatrix(matrix);
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
    int[][] matrix = {  {1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18},
                        {19, 20, 21, 22, 23, 24},
                        {25, 26, 27, 28, 29, 30},
                        {31, 32, 33, 34, 35, 36}    };
    Task task = new Task();
    task.setTaskSolution(new Solution());
    printMatrix(task.rotateMatrix(matrix));
  }
}
