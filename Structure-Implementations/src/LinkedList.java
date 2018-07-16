class Node {
  int data;
  Node next;
  public Node(int data) {
    this.data = data;
  }
}

public class LinkedList {
  Node head;
  public LinkedList(Node head){
    this.head = head;
  }
  void appendToTail(int data) {
    Node last = new Node(data);
    Node n = head;
    while(n.next != null) {
      n = n.next;
    }
    n.next = last;
  }
  void appendToHead(int data) {
    Node first = new Node(data);
    Node n = head;
    head = first;
    first.next = n;
  }
  Node appendToNode(Node n, int data) {
    Node newNode = new Node(data);
    Node newNodeNext = n.next;
    n.next = newNode;
    newNode.next = newNodeNext;
    return newNode;
  }
  Node findNodeWithValue(int value) {
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
  void printList() {
    Node n = head;
    while(n != null) {
      System.out.println(n.data);
      n = n.next;
    }
  }
  void deleteNode(int data) {
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
    LinkedList lList = new LinkedList(new Node(10));
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
