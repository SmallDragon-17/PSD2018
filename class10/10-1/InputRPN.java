import java.io.*;

class InputRPN{

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

    for(int j=0; j < tokens.length; j++){
      if(isDigit(tokens[j])){
        System.out.println(j + ": " + tokens[j] + " (digit)");
      }
      else{
        System.out.println(j + ": " + tokens[j] + " (operator)");
      }
    }
  }
}
