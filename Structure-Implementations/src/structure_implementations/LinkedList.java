package structure_implementations;

import java.util.Iterator;
import java.util.Random;

public class LinkedList implements Iterable<Node> {
  Node head;

  public LinkedList(){
    this.head = null;
  }

  public LinkedList(int data){
    this.head = new Node(data);
  }

  public boolean isEmpty() {
    return head == null;
  }

  public Node getHead() {
    return this.head;
  }

  public void setHead(Node head) {
    this.head = head;
  }

  public void appendToTail(Node last) {
    if(head == null) {
      head = last;
    }
    else {
      Node n = head;
      while (n.next != null)
        n = n.next;
      n.next = last;
    }
  }

  public void appendToTail(int data) {
    Node last = new Node(data);
    appendToTail(new Node(data));
  }

  public Node appendToHead(int data) {
    Node first = new Node(data);
    Node n = head;
    head = first;
    first.next = n;
    return head;
  }

  public Node appendToNode(Node n, int data) {
    Node newNode = new Node(data);
    Node newNodeNext = n.next;
    n.next = newNode;
    newNode.next = newNodeNext;
    return newNode;
  }

  public Node findNodeWithValue(int value) {
    Node n = head;
    while(n.data != value && n.next != null) {
      n = n.next;
    }
    if(n.data == value) {
      return n;
    }
    else {
      return null;
    }
  }

  public void printList() {
    Node n = head;
    while(n != null) {
      System.out.println(n.data);
      n = n.next;
    }
    System.out.println();
  }

  public void deleteNode(int data) {
    Node n = head;
    if(head.data == data) {
      head = head.next;
    }
    while(n.next != null && n.next.data != data) {
      n = n.next;
    }
    if(n.next != null) {
      n.next = n.next.next;
    }
  }

  public static LinkedList generateRandomList(int numberOfNodes) {
    LinkedList randomList = new LinkedList();

    appendToListNodes(randomList, numberOfNodes);

    return randomList;
  }

  private static void appendToListNodes(LinkedList list, int numberOfNodes) {
    for(int i = 0; i < numberOfNodes; i++) {
      list.appendToTail(randomIntegerBetween(1, 100));
    }
  }

  private static int randomIntegerBetween(int min, int max) {
    return new Random().nextInt(max - min + 1) + min;
  }

  public Node getNthNode(int n) {
    Node nthNode = head;

    for(int i = 0; i < n; i++)
      nthNode = nthNode.next;

    return nthNode;
  }

  @Override
  public Iterator<Node> iterator() {
    return new LinkedListIterator(this);
  }
}
