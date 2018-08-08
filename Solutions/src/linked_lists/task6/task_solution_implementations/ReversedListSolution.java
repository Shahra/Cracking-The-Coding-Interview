package linked_lists.task6.task_solution_implementations;

import linked_lists.task6.TaskSolution;
import structure_implementations.LinkedList;
import structure_implementations.Node;

import java.util.Iterator;

public class ReversedListSolution implements TaskSolution {
  private LinkedList reversedList;
  
  public boolean palindrome(LinkedList list) {
    reversedList = getReversedList(list);
    return compareLists(list, reversedList);
  }

  private LinkedList getReversedList(LinkedList list) {
    LinkedList reversedList = new LinkedList();
    for(Node node: list)
      reversedList.appendToHead(node.data);
    return reversedList;
  }

  private boolean compareLists(LinkedList list, LinkedList reversedList) {
    Iterator<Node> it = reversedList.iterator();
    Node n2;
    for(Node n1 : list) {
      if(!it.hasNext())
        return false;
      else {
        n2 = it.next();
        if(n1.data != n2.data)
          return false;
      }
    }
    if(it.hasNext())
      return false;
    return true;
  }
}
