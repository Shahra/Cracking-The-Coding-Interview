/*
  Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
  before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
  to be after the elements less than x (see below). The partition element x can appear anywhere in the
  "right partition"; it does not need to appear between the left and right partitions.
  EXAMPLE
  Input: 3 -) 5 -) 8 -) 5 -) 113 -) 2 -) 1 [partition = 5]
  Output: 3 -) 1 -) 2 -) 113 -) 5 -) 5 -) 8
*/

package linked_lists.task4;

import linked_lists.task4.task_solution_implementations.SolutionUsingOneList;
import linked_lists.task4.task_solution_implementations.SolutionUsingTwoLists;
import structure_implementations.LinkedList;

public class Task {
  private LinkedList list;
  private TaskSolution taskSolution;

  public void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  public LinkedList partition(int x) {
    return taskSolution.partition(list, x);
  }

  public static void main(String[] args) {
    Task task = new Task();

    task.setTaskSolution(new SolutionUsingTwoLists());

    task.list = LinkedList.generateRandomList(10);

    task.partition(50).printList();

    task.setTaskSolution(new SolutionUsingOneList());

    task.partition(50).printList();
  }
}
