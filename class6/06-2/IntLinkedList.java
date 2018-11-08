import java.util.Comparator;

public class IntLinkedList {

    class Node {          
	private int data;
	private Node next;

	Node(int data, Node next){
	    this.data = data;
	    this.next = next;
	}
    }

    private Node head;
    private Node crnt;

    public IntLinkedList() {
	head = crnt = null;
    }

    public int search(int obj) {
	Node ptr = head;

	while(ptr != null) {
	    if(ptr.data == obj) {
		crnt = ptr;
		return ptr.data;
	    }
	    ptr = ptr.next;
	}
	return -1;
    }

    public void addFirst(int obj) {
	Node ptr = head;
	head = crnt = new Node(obj,ptr);
    }

    public void addLast(int obj) {
	if(head == null)
	    addFirst(obj);
	else {
	    Node ptr = head;
	    while(ptr.next != null)
		ptr = ptr.next;
	    ptr.next = crnt = new Node(obj,null);
	}
    }

    public void removeFirst() {
	if(head != null)
	    head = crnt = head.next;
    }

    public void removeLast() {
	if(head != null) {
	    if(head.next == null)
		removeFirst();
	    else {
		Node ptr = head;
		Node pre = head;

		while (ptr.next != null){
		    pre =ptr;
		    ptr = ptr.next;
		}
		pre.next = null;
		crnt = pre;
	    }
	}
    }

    public void remove(Node p) {
	if (head != null) {
	    if(p == head)
		removeFirst();
	    else {
		Node ptr = head;

		while(ptr.next != p) {
		    ptr = ptr.next;
		    if(ptr == null) return;
		}
		ptr.next = p.next;
		crnt = ptr;
	    }
	}
    }

    public void removeCurrentNode() {
	remove(crnt);
    }

    public void clear() {
	while (head != null)
	    removeFirst();
	crnt = null;
    }

    public boolean next() {
	if(crnt == null || crnt.next == null)
	    return false;
	crnt = crnt.next;
	return true;
    }

    public void printCurrentNode() {
	if(crnt == null)
	    System.out.println("着目ノードはありません");
	else
	    System.out.println(crnt.data);
    }

    public void dump(){
	Node ptr = head;

	while(ptr != null) {
	    if(ptr==crnt)
	    System.out.println(ptr.data + " <--crnt");
	    else
		System.out.println(ptr.data);
	    ptr = ptr.next;
	}
    }
   
   public int size(){
       Node ptr = head;
       int count = 0;
       
       while(ptr != null){
           count++;
           ptr = ptr.next;
       }
       return count;
    }
}
		
				    
		    
