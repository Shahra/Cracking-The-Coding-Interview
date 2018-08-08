package structure_implementations;

import java.util.Iterator;

public class LinkedListIterator implements Iterator<Node> {
  Node position;

  public LinkedListIterator(LinkedList list) {
    position = list.getHead();
  }

  @Override
  public boolean hasNext() {
    if(position == null)
      return false;
    return true;
  }

  @Override
  public Node next() {
    Node node = position;
    if(hasNext())
      position = position.next;
    return node;
  }
}
