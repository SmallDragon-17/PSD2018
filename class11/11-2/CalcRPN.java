import java.io.*;

class StringLinkedList{

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

  public void addLast(String obj){
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

  public void dump(){
    Node ptr = head;

    while(ptr != null){
      System.out.print(ptr.data + " ");
      ptr = ptr.next;
    }
    System.out.println();
  }

  public int size(){
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

  public String getFirstNode(){
    String str = head.data;
    head = crnt = head.next;
    return str;
  }

  public String getLastNode(){
    Node ptr = head;
    Node pre = head;
    if(head.next == null)
      removeFirst();
    else{
      while(ptr.next != null){
        pre = ptr;
        ptr = ptr.next;
      }
      pre.next = null;
      crnt = pre;
    }
    return ptr.data;
  }
}

class CalcRPN{
  
  static String[] tokens;

  static boolean isDigit(String s){
    try{
      Integer.parseInt(s);//数字である時実行
      return true;
    }
    catch(NumberFormatException e){
      return false;
    }
  }

  static int calcRPN(StringLinkedList RPN){
    for(int j=0; j < tokens.length; j++){//数字の長さ分繰り返す
      if(isDigit(tokens[j])){//数字の時
        System.out.println(j + ": " + tokens[j] + " (digit)");
        RPN.addLast(tokens[j]);
        System.out.print("手元 : ");
        RPN.dump();
      }
      else{//記号の時
        System.out.println(j + ": " + tokens[j] + " (operator)");
        int num1 = Integer.parseInt(RPN.getLastNode());
        int num2 = Integer.parseInt(RPN.getLastNode());
        int num3 = 0;

        if(tokens[j].equals("+")){
          num3 = num2 + num1;
        }
        else if(tokens[j].equals("-")){
          num3 = num2 - num1;
        }
        else if(tokens[j].equals("*")){
          num3 = num2 * num1;
        }
        else if(tokens[j].equals("/")){
          num3 = num2 / num1;
        }
        
        RPN.addLast(String.valueOf(num3));
        System.out.print("手元 : ");
        RPN.dump();
      }
    }
    return Integer.parseInt(RPN.getFirstNode());
  }
//--メイン--//
  public static void main(String[] args) throws IOException{
    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));

    System.out.print("逆ポーランド記法の数式 : ");
    String str = br.readLine();
    String targetRPN = str;

    tokens = targetRPN.split(" ", 0);
    System.out.println("targetRPN = " + targetRPN);

    StringLinkedList RPN = new StringLinkedList(); 
    

    System.out.println("ans = " + calcRPN(RPN));
  }
}
