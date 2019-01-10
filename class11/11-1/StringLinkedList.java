public class StringLinkedList{//コンストラクタ

  class Node{
    private String data;
    private Node next;
  
    Node(String data, Node next){
      this.data = data;
      this.next = next;
    }
  }

  private Node head;
  private Node crnt;

  public StringLinkedList(){
    head = crnt = null;
  }

  public void addFirst(String obj){
    Node ptr = head;
    head = crnt = new Node(obj, ptr);
  }

  public void addLast(String obj){//末尾へノードを挿入するメソッド
    if(head == null)
      addFirst(obj);
    else{
      Node ptr = head;
      while(ptr.next != null)
        ptr = ptr.next;
      ptr.next = crnt = new Node(obj, null);
    }
  }

  public void removeFirst(){
    if(head != null)
      head = crnt = head.next;
  }

  public void removeLast(){
    if(head != null){
      if(head.next == null)
        removeFirst();
      else{
        Node ptr = head;
        Node pre = head;

        while(ptr.next != null){
          pre = ptr;
          ptr = ptr.next;
        }
        pre.next = null;
        crnt = pre;
      }
    }
  }

  public void dump(){//全ノードを返すメソッド
    Node ptr = head;

    while(ptr != null){
      System.out.print(ptr.data);
      if(crnt == ptr)
        System.out.println(" <-- crnt");
      else
        System.out.println();
      ptr = ptr.next;
    }
    System.out.println();
  }

  public int size(){//ノード数を返すメソッド
    int num = 0;
    if(head != null){
      Node ptr = head;

      while(ptr.next != null){
        num++;
        ptr = ptr.next;
      }
      return num+1;
    }
    else{
      return num;
    }
  }

  public String getFirstNode(){//先頭ノードを取得するメソッド、取得したメソッドは削除する
    String str = head.data;
    head = crnt = head.next;
    return str;
  }
}
