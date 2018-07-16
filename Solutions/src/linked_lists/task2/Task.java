/*
  Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
*/

package linked_lists.task2;


import structure_implementations.LinkedList;
import structure_implementations.Node;

import java.util.HashSet;
import java.util.Set;

interface TaskSolution {
  Node returnKthToLast(LinkedList list, int k);
}

class SolutionWithRecursion implements TaskSolution {
  public Node findPrevious(LinkedList list, Node n) {
    Node runner = list.getHead();
    while(runner.next != n) {
      runner = runner.next;
    }
    return runner;
  }

  public Node returnKthToNode(LinkedList list, Node n, int k) {
    if(k == 0) {
      return n;
    }
    if(list.getHead() == n) {
      return null;
    }
    return returnKthToNode(list, findPrevious(list, n), k - 1);
  }

  public Node returnKthToLast(LinkedList list, int k) {
    System.out.println("Solution with recursion");
    Node n = list.getHead();
    while(n.next != null) {
      n = n.next;
    }
    return returnKthToNode(list, n, k);
  }
}

class SolutionWithoutRecursion implements TaskSolution {
  public Node returnKthToLast(LinkedList list, int k) {
    System.out.println("Solution without recursion");
    Node firstRunner = list.getHead();
    Node secondRunner = firstRunner;
    for(int i = 0; i <= k; i++) {
      if(secondRunner == null) {
        return null;
      }
      secondRunner = secondRunner.next;
    }
    while(secondRunner != null) {
      firstRunner = firstRunner.next;
      secondRunner = secondRunner.next;
    }
    return firstRunner;
  }
}

public class Task {

  private TaskSolution taskSolution;

  private Node returnKthToLast(LinkedList list, int k) {
    return taskSolution.returnKthToLast(list, k);
  }

  private void setTaskSolution(TaskSolution taskSolution) {
    this.taskSolution = taskSolution;
  }

  private LinkedList initializeList() {
    LinkedList list = new LinkedList(1);
    list.appendToTail(2);
    list.appendToTail(3);
    list.appendToTail(4);
    list.appendToTail(5);
    list.appendToTail(6);
    list.appendToTail(7);
    list.appendToTail(8);
    list.appendToTail(9);
    list.appendToTail(10);
    list.appendToTail(11);
    list.appendToTail(12);
    return list;
  }

  public static void main(String[] args) {
    Task task = new Task();

    LinkedList list = task.initializeList();
    int k = 11;
    Node solution;

    list.printList();

    task.setTaskSolution(new SolutionWithRecursion());
    solution = task.returnKthToLast(list, k);
    if(solution == null) {
      System.out.println("Ne postoji " + k + ". element od kraja!");
    }
    else {
      System.out.println(solution.data);
    }

    list = task.initializeList();

    task.setTaskSolution(new SolutionWithoutRecursion());
    solution = task.returnKthToLast(list, k);
    if(solution == null) {
      System.out.println("Ne postoji " + k + ". element od kraja!");
    }
    else {
      System.out.println(solution.data);
    }
  }
}
