package linked_lists.task4.task_solution_implementations;

import linked_lists.task4.TaskSolution;
import structure_implementations.LinkedList;
import structure_implementations.Node;

public class SolutionUsingTwoLists implements TaskSolution {
  private int x;
  private LinkedList lessThanX;
  private LinkedList greaterThanOrEqualToX;
  private Node lastNodeSmallerThanX = null;

  @Override
  public LinkedList partition(LinkedList list, int x) {
    initializeVariables(x);

    for(Node node : list) {
      appendToCorrectList(node.data);
    }

    return mergeLessThanXWithGreaterThanX();
  }

  private void initializeVariables(int x) {
    this.x = x;
    lessThanX = new LinkedList();
    greaterThanOrEqualToX = new LinkedList();
    lastNodeSmallerThanX = null;
  }

  private void appendToCorrectList(int nodeData) {
    if(nodeData < x)
      appendToLessThanX(nodeData);
    else
      appendToGreaterThanOrEqualToX(nodeData);
  }

  private void appendToLessThanX(int nodeData) {
    Node node = lessThanX.appendToHead(nodeData);
    if(lastNodeSmallerThanX == null)
      lastNodeSmallerThanX = node;
  }

  private void appendToGreaterThanOrEqualToX(int nodeData) {
    greaterThanOrEqualToX.appendToHead(nodeData);
  }

  private LinkedList mergeLessThanXWithGreaterThanX() {
    if(lastNodeSmallerThanX == null)
      return greaterThanOrEqualToX;
    else
      lastNodeSmallerThanX.next = greaterThanOrEqualToX.getHead();
    return lessThanX;
  }
}
