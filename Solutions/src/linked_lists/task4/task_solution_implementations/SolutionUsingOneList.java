package linked_lists.task4.task_solution_implementations;

import linked_lists.task4.TaskSolution;
import structure_implementations.LinkedList;
import structure_implementations.Node;

public class SolutionUsingOneList implements TaskSolution {
  private LinkedList partitionedList;
  private Node tail;
  private int x;

  public LinkedList partition(LinkedList list, int x) {
    initializeVariables(x);

    for(Node node : list)
      appendToCorrectPosition(node.data);

    return partitionedList;
  }

  private void initializeVariables(int x) {
    partitionedList = new LinkedList();
    tail = null;
    this.x = x;
  }

  private void appendToCorrectPosition(int data) {
    if(partitionedList.isEmpty())
      tail = partitionedList.appendToHead(data);
    else if (data < x)
      appendToHead(data);
    else
      appendToTail(data);
  }

  private void appendToHead(int data) {
    partitionedList.appendToHead(data);
  }

  private void appendToTail(int data) {
    Node newTail = new Node(data);
    tail.next = newTail;
    tail = newTail;
  }
}
