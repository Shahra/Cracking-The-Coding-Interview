/*
  Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
  the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
  that node.
  EXAMPLE
  Input: the node c from the linked list a -> b -> d -> e -> f
  Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f
 */

package linked_lists.task3;

import linked_lists.task3.task_solution_implementations.TaskSolutionImpl;
import structure_implementations.LinkedList;
import structure_implementations.Node;

public class Task {
  private LinkedList list;
  private TaskSolution taskSolution;

  public void deleteMiddleNode(Node n) {
    taskSolution.deleteMiddleNode(n);
  }

  public void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  public static void main(String[] args) {
    Task task = new Task();

    task.list = LinkedList.generateRandomList(10);

    task.setTaskSolution(new TaskSolutionImpl());

    task.deleteMiddleNode(task.list.getNthNode(5));

    task.list.printList();
  }
}
