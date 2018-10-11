
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;


class StringQueue {
  static int front = 0;
  static int end = 0;
  static int deCount = 0;
  static int ArraySize = 20;


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Deque<String> s = new ArrayDeque<String>(20);

    while(true) {
      end = s.size();
      System.out.println("Current number of data: " + (s.size() - deCount) + " / " + capacity());
      System.out.println("(1) Enqueue, (2) Dequeue, (3) Peak, (4) Dump, (0) Finish");

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
            // System.out.println(s.removeFirst()); // remove
            System.out.println(s.getFirst()); // Not remove
            front = front + 1;
            deCount = deCount + 1;
          }
          break;

        case 3:
          if(s.isEmpty()) {
            System.out.println("Stack is empty.");
          } else if(deCount > 0){
            break;
          } else {
            System.out.println(s.peekFirst());
          }
          break;

        case 4:
          //String[] strList = s.toArray(new String[20]);
          dump(s.toArray(new String[20]));
          break;
      }
    }
  }

  public static int capacity() {
    return ArraySize;
  }

  public static void dump(String[] ArrayList) {
    int i = 0;
    for(String str : ArrayList) {
      if (i == front) System.out.println("[" + i + "] " + str + " (front)");
      else if (i == end) System.out.println("[" + i + "] " + str + " (rear)");
      else System.out.println("[" + i + "] " + str);
      i = i + 1;
    }
  }

  public static void reset() {
    front = 0;
    end = 0;
    deCount = 0;
  }
}
