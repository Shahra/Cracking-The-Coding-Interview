package linked_lists.task5.task_solution_implementations;

import linked_lists.task5.TaskSolution;
import structure_implementations.LinkedList;
import structure_implementations.Node;
import java.util.Iterator;

public class TaskSolutionImpl implements TaskSolution {
  private LinkedList sumList;
  private Iterator<Node> firstListIterator;
  private Iterator<Node> secondListIterator;
  private int carry;

  public LinkedList sumLists(LinkedList firstList, LinkedList secondList) {
    initializeVariables(firstList, secondList);

    addLists();

    return sumList;
  }

  private void initializeVariables(LinkedList firstList, LinkedList secondList) {
    sumList = new LinkedList();
    firstListIterator = firstList.iterator();
    secondListIterator = secondList.iterator();
    carry = 0;
  }

  private void addLists() {
    while(firstListIterator.hasNext() && secondListIterator.hasNext()) {
      int a = firstListIterator.next().data;
      int b = secondListIterator.next().data;
      addDigits(a, b);
    }

    while(firstListIterator.hasNext()) {
      int a = firstListIterator.next().data;
      addDigits(a, 0);
    }

    while(secondListIterator.hasNext()) {
      int b = secondListIterator.next().data;
      addDigits(0, b);
    }
  }

  private void addDigits(int a, int b) {
    int sum = a + b + carry;
    sumList.appendToTail(sum % 10);
    carry = sum / 10;
  }
}
