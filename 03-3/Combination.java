 import java.util.Scanner;

 class Combination{

   public static int C(int n, int r){
      if(n==0 || r==0 || n==r)
        return 1;
      else if(n<=r)
        return 00;
      else
        return C(n-1,r)+C(n-1,r-1);
   }

   public static void main(String args[])
   {
      Scanner scan = new Scanner(System.in);

      System.out.print("n=");
      int n = scan.nextInt();
      System.out.print("r=");
      int r = scan.nextInt();

      System.out.println(n+"C"+r+" = "+C(n,r));
   }

 }
