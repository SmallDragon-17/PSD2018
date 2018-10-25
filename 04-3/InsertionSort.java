import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Insertion{
  public static void main(String args[])throws IOException{

    System.out.println("乱数の最大値を入力してください");

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    String str  = br.readLine();
    int maxValue = Integer.parseInt(str);

    int[] x = new int[10];

    System.out.println("単純挿入ソート");
    System.out.println("要素数：" + x.length);
    generateRandomValues(x, maxValue);
    showArray(x);
    System.out.println();

    insertionSort(x);

    System.out.println();
    System.out.println("result");
    showArray(x);
  }

  static void insertionSort(int[] a){
    for(int i=0; i<a.length; i++){
      int j;
      int tmp = a[i];
      for(j=i; j>=0 && a[j]>tmp; j--){
        a[j+1] = a[j];
        a[j+1] = tmp;
      }
      System.out.println();
      System.out.println("パス" + i);
      showArray(a);
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
