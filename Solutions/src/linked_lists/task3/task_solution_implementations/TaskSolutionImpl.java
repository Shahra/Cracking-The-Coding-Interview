package linked_lists.task3.task_solution_implementations;

import linked_lists.task3.TaskSolution;
import structure_implementations.Node;

public class TaskSolutionImpl implements TaskSolution {
  @Override
  public void deleteMiddleNode(Node node) {
    if(node != null && node.next != null) {
      node.data = node.next.data;
      node.next = node.next.next;
    }
  }
}
