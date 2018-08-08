/*
  Palindrome: Implement a function to check if a linked list is a palindrome.
*/

package linked_lists.task6;

import linked_lists.task6.task_solution_implementations.ReversedListSolution;
import linked_lists.task6.task_solution_implementations.SolutionUsingStack;
import structure_implementations.LinkedList;

public class Task {
  private LinkedList list;
  private TaskSolution taskSolution;

  public void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  public boolean palindrome() {
    return taskSolution.palindrome(list);
  }

  public static void main(String[] args) {
    Task task = new Task();
    task.list = new LinkedList(0);
    task.list.appendToTail(22);
    task.list.appendToTail(21);
    task.list.appendToTail(32);
    task.list.appendToTail(21);
    task.list.appendToTail(22);
    task.list.appendToTail(0);

    task.setTaskSolution(new ReversedListSolution());
    System.out.println(task.palindrome());

    task.setTaskSolution(new SolutionUsingStack());
    System.out.println(task.palindrome());
  }
}
