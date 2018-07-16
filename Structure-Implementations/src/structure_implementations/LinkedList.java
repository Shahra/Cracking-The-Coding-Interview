package structure_implementations;

public class LinkedList {
  Node head;
  public LinkedList(int data){
    this.head = new Node(data);
  }
  public Node getHead() {
    return this.head;
  }
  public void appendToTail(int data) {
    Node last = new Node(data);
    Node n = head;
    while(n.next != null) {
      n = n.next;
    }
    n.next = last;
  }
  public void appendToHead(int data) {
    Node first = new Node(data);
    Node n = head;
    head = first;
    first.next = n;
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

  public static void main(String[] args) {
    LinkedList lList = new LinkedList(10);
    lList.appendToTail(131);
    lList.appendToTail(14);
    lList.appendToHead(12);
    lList.appendToTail(167);
    lList.appendToHead(112);
    lList.appendToNode(lList.findNodeWithValue(14), 188);
    lList.printList();
    lList.deleteNode(10);
    System.out.println();
    lList.printList();
  }
}
