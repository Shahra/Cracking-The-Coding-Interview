package linked_lists.task6.task_solution_implementations;

import linked_lists.task6.TaskSolution;
import structure_implementations.LinkedList;
import structure_implementations.Node;
import java.util.Iterator;
import java.util.Stack;

public class SolutionUsingStack implements TaskSolution {
  private Stack<Integer> stack = new Stack<>();
  private Iterator<Node> it;
  private int size;

  public boolean palindrome(LinkedList list) {
    size = sizeOfList(list);

    pushFirstHalfOfLinkedListToStack(list);

    adjustIterator();

    return checkIfPalindrome();
  }

  private void adjustIterator() {
    if(isOdd(size))
      it.next();
  }

  private int sizeOfList(LinkedList list) {
    int size = 0;
    for(Node n : list)
      ++size;
    return size;
  }

  private void pushFirstHalfOfLinkedListToStack(LinkedList list) {
    stack.clear();
    it = list.iterator();
    for(int i = 0; i < size / 2; i++)
      stack.push(it.next().data);
  }

  private boolean isOdd(int size) {
    return size % 2 == 1;
  }

  private boolean checkIfPalindrome() {
    while(it.hasNext())
      if(it.next().data != stack.pop())
        return false;
    return stack.empty();
  }
}
