
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;


class StringStack {
  static int ptr;
  static int ArraySize = 20;


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Deque<String> s = new ArrayDeque<String>(20);

    while(true) {
      System.out.println("Current number of data: " + s.size() + " / " + capacity());
      System.out.println("(1) Push, (2) Pop, (3) Peak, (4) Dump, (0) Finish");
      ptr = s.size();

      int select = scan.nextInt();
      if (select == 0) {
        reset();
        break;
      }

      String str;
      switch(select) {
        case 1:
          System.out.println("What data to push? : ");
          str = scan.next();
          if (str == "" || s.size() == 20) break;

          s.addLast(str);
          break;

        case 2:
          if(s.isEmpty()) {
            System.out.println("Stack is empty.");
          }else { 
            System.out.println(s.removeLast());
          }
          break;

        case 3:
          if(s.isEmpty()) {
            System.out.println("Stack is empty.");
          }else {
            System.out.println(s.peekFirst());
          }
          break;

        case 4:
          //String[] strList = s.toArray(new String[20]);
          dump(s.toArray(new String[20]));
          break;
      }
      ptr = ptr + 1;
    }
  }

  public static int capacity() {
    return ArraySize;
  }

  public static void dump(String[] ArrayList) {
    int i = 0;
    for(String str : ArrayList) {
      if (i == ptr) System.out.println("[" + i + "] " + str + "<- ptr");
      else System.out.println("[" + i + "] " + str);
      i = i + 1;
    }
  }

  public static void reset() {
    ptr = 0;
  }
}
