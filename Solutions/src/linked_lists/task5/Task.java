package linked_lists.task5;

import linked_lists.task5.task_solution_implementations.TaskSolutionImpl;
import structure_implementations.LinkedList;

public class Task {
  private LinkedList firstList;
  private LinkedList secondList;
  private TaskSolution taskSolution;

  public void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  private LinkedList sumLists() {
    return taskSolution.sumLists(firstList, secondList);
  }

  public static void main(String[] args) {
    Task task = new Task();
    task.setTaskSolution(new TaskSolutionImpl());
    task.firstList = new LinkedList(6);
    task.firstList.appendToHead(1);
    task.firstList.appendToHead(7);
    task.secondList = new LinkedList(2);
    task.secondList.appendToHead(9);
    task.secondList.appendToHead(5);
    task.sumLists().printList();
  }
}
