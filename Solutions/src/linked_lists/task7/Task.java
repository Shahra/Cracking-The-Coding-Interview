package linked_lists.task7;

import linked_lists.task7.task_solution_implementations.TaskSolutionImpl;
import structure_implementations.LinkedList;
import structure_implementations.Node;

public class Task {
  private TaskSolution taskSolution;

  public void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  private Node intersection(LinkedList list1, LinkedList list2) {
    return taskSolution.intersection(list1, list2);
  }

  public static void main(String[] args) {
    Task task = new Task();

    task.setTaskSolution(new TaskSolutionImpl());

    LinkedList list1 = new LinkedList(3);
    list1.appendToTail(1);
    list1.appendToTail(5);
    list1.appendToTail(9);

    LinkedList list2 = new LinkedList(4);
    list2.appendToTail(6);

    Node n = new Node(7);
    list1.appendToTail(n);
    list2.appendToTail(n);

    n = new Node(2);
    list1.appendToTail(n);

    n = new Node(1);
    list1.appendToTail(n);

    System.out.println(task.intersection(list1, list2).data);
  }
}
