import java.io.*;

class StringStack{
  private int max;
  private int ptr;
  private String[] stk;
  private int count;

  public class EmptyStringStackException extends RuntimeException{
    public EmptyStringStackException() { }
  }

  public class OverflowStringStackException extends RuntimeException{
    public OverflowStringStackException() { }
  }

  public StringStack(int capacity){
    ptr = 0;
    max = capacity;
    try{
      stk = new String[max];
    }
    catch(OutOfMemoryError e){
      max = 0;
    }
  }

  public int size(){
    return ptr;
  }

  public int capacity(){
    return max;
  }

  public void push(String x) throws OverflowStringStackException{
    if(ptr >= max){
      throw new OverflowStringStackException();
    }
    stk[ptr] = x;
    ptr++;
    count++;
  }

  public String pop() throws EmptyStringStackException{
    if(ptr <= 0){
      throw new EmptyStringStackException();
    }
    ptr--;
    count--;
    return stk[ptr];
    
  }

  public String peek() throws EmptyStringStackException{
    if(ptr <= 0){
      throw new EmptyStringStackException();
    }
    return stk[ptr-1];
  }

  public void dump(){
    if(ptr <= 0){
      System.out.println("スタックは空です。");
    }
    else{
      for(int i=0; i < count; i++){
        System.out.print(stk[i] + " ");
      }
      System.out.println();
    }
  }
}

class CalcRPN{

  static boolean isDigit(String s){
    try{
      Integer.parseInt(s);
      return true;
    }
    catch(NumberFormatException e){
      return false;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));

    System.out.print("逆ポーランド記法の数式 : ");
    String str = br.readLine();
    String targetRPN = str;

    String[] tokens = targetRPN.split(" ", 0);

    System.out.print("targetRPN = ");
    for(int i=0; i < tokens.length; i++){
      System.out.print(tokens[i] + " ");
    }
    System.out.println();

    System.out.println("tokenNum = " + tokens.length);

    StringStack stack = new StringStack(tokens.length);

    for(int j=0; j < tokens.length; j++){
      if(isDigit(tokens[j])){
        System.out.println(j + ": " + tokens[j] + " (digit)");
        stack.push(tokens[j]);
        System.out.print("手元 : ");
        stack.dump();
      }
      else{
        System.out.println(j + ": " + tokens[j] + " (operator)");
        int num1 = Integer.parseInt(stack.pop());
        int num2 = Integer.parseInt(stack.pop());
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
        
        stack.push(String.valueOf(num3));
        System.out.print("手元 : ");
        stack.dump();
      }
    }
    
    System.out.print("targetRPN = ");
    for(int i=0; i < tokens.length; i++){
      System.out.print(tokens[i] + " ");
    }
    System.out.println();

    System.out.println("ans = " + stack.peek());
  }
}
