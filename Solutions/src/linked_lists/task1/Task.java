/*
  Remove Dups: Write code to remove duplicates from an unsorted linked list.
  FOLLOW UP
  How would you solve this problem if a temporary buffer is not allowed?
*/

package linked_lists.task1;


import structure_implementations.LinkedList;
import structure_implementations.Node;

import java.util.HashSet;
import java.util.Set;

interface TaskSolution {
  void removeDups(LinkedList list);
}

class SolutionWithBuffer implements TaskSolution {
  public void removeDups(LinkedList list) {
    System.out.println("Solution with buffer. Time complexity: O(n). Space complexity: O(n).");
    Set<Integer> usedValues = new HashSet<>();
    Node runner = list.getHead();
    usedValues.add(runner.data);
    while(runner.next != null) {
      if(usedValues.contains(runner.next.data)) {
        runner.next = runner.next.next;
        continue;
      }
      else {
        usedValues.add(runner.next.data);
      }
      runner = runner.next;
    }
  }
}

class SolutionWithoutBuffer implements TaskSolution {
  public void removeDups(LinkedList list) {
    System.out.println("Solution without buffer. Time complexity: O(n^2). Space complexity: O(1).");
    Node first = list.getHead();
    while(first != null) {
      Node n = first;
      while (n.next != null) {
        if (n.next.data == first.data) {
          n.next = n.next.next;
          continue;
        }
        n = n.next;
      }
      first = first.next;
    }
  }
}

public class Task {

  private TaskSolution taskSolution;

  private void removeDups(LinkedList list) {
    taskSolution.removeDups(list);
  }

  private void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  private LinkedList initializeList() {
    LinkedList list = new LinkedList(1);
    list.appendToTail(5);
    list.appendToTail(8);
    list.appendToTail(1);
    list.appendToTail(5);
    list.appendToTail(6);
    list.appendToTail(6);
    list.appendToTail(1);
    list.appendToTail(2);
    list.appendToTail(5);
    list.appendToTail(8);
    list.appendToTail(14);
    return list;
  }

  public static void main(String[] args) {

    Task task = new Task();

    LinkedList list = task.initializeList();

    task.setTaskSolution(new SolutionWithBuffer());
    task.removeDups(list);

    list.printList();

    list = task.initializeList();

    task.setTaskSolution(new SolutionWithoutBuffer());
    task.removeDups(list);

    list.printList();
  }
}
