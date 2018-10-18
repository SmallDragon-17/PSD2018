import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Shell{
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

    shellSort(x);

    System.out.println();
    System.out.println("result");
    showArray(x);
  }

  static void shellSort(int[] a){
    int n = a.length;
    for(int h=n/2; h>0; h/=2){
      for(int l=0; l<a.length; l++)
        System.out.print(a[l] + " ");
      System.out.println();
      System.out.println(h + "ソート");

      for(int i=h; i<n; i++){
        int j;
        int tmp = a[i];
        for(j = i-h; j>=0 && a[j] > tmp; j-=h)
          a[j+h] = a[j];
        a[j+h] = tmp;
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
