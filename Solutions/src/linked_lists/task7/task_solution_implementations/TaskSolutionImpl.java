package linked_lists.task7.task_solution_implementations;

import linked_lists.task7.TaskSolution;
import structure_implementations.LinkedList;
import structure_implementations.Node;
import java.util.Iterator;

public class TaskSolutionImpl implements TaskSolution {
  private LinkedList firstList;
  private LinkedList secondList;
  private int firstListSize;
  private int secondListSize;
  private Iterator<Node> firstListIterator;
  private Iterator<Node> secondListIterator;

  public Node intersection(LinkedList firstList, LinkedList secondList) {
    initializeVariables(firstList, secondList);
    makeSureThatTheFirstListIsBigger();
    adjustFirstListIterator();
    return findIntersection();
  }

  private void initializeVariables(LinkedList list1, LinkedList list2) {
    firstList = list1;
    secondList = list2;

    firstListSize = sizeOf(firstList);
    secondListSize= sizeOf(secondList);

    firstListIterator = firstList.iterator();
    secondListIterator = secondList.iterator();
  }

  private int sizeOf(LinkedList list) {
    int size = 0;
    for(Node n : list)
      ++size;
    return size;
  }

  private void makeSureThatTheFirstListIsBigger() {
    if(firstListSize < secondListSize) {
      LinkedList temp = firstList;
      firstList = secondList;
      secondList = temp;
    }
  }

  private void adjustFirstListIterator() {
    for(int i = 0; i < distanceBetweenNumbers(firstListSize, secondListSize); i++)
      firstListIterator.next();
  }

  private int distanceBetweenNumbers(int a, int b) {
    return Math.abs(a - b);
  }

  private Node findIntersection() {
    while(secondListIterator.hasNext()) {
      Node n1 = firstListIterator.next();
      Node n2 = secondListIterator.next();
      if(n1 == n2)
        return n1;
    }
    return null;
  }
}
