import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Bubble{
  public static void main(String args[])throws IOException{

    System.out.println("乱数の最大値を入力してください");

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    String str  = br.readLine();
    int maxValue = Integer.parseInt(str);

    int[] x = new int[10];

    System.out.println("単純交換ソート（バブルソート）");
    System.out.println("要素数：" + x.length);
    generateRandomValues(x, maxValue);
    showArray(x);
    System.out.println();

    bubbleSort(x);

    System.out.println();
    System.out.println("result");
    showArray(x);
  }

  static void bubbleSort(int[] a){
    int k=0;
    int n = a.length;

    for(int i=0; i<n; i++){

      for(int l=0; l<n; l++)
        System.out.print(a[l] + " ");
      System.out.println();
      System.out.println("パス" + i);

      for(int j=n-1; j>i; j--){
        if(a[j] < a[j-1]){
          int tmp = a[j];
          a[j] = a[j-1];
          a[j-1] = tmp;
        }
      }
  }
}

  static void generateRandomValues(int[] array, int maxValue){
    for(int i=0; i<array.length; i++){
      Random rand = new Random();
      array[i] = rand.nextInt(maxValue);
    }
  }

  static void showArray(int[] array){
    for(int i=0; i<array.length; i++)
      System.out.println("x[" + i + "] = " + array[i]);
  }




}
