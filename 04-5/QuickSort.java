import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Quick{
  public static void main(String args[])throws IOException{

    System.out.println("乱数の最大値を入力してください");

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    String str  = br.readLine();
    int maxValue = Integer.parseInt(str);

    int[] x = new int[10];

    System.out.println("クイックソート");
    System.out.println("要素数：" + x.length);
    generateRandomValues(x, maxValue);
    showArray(x);
    System.out.println();

    quickSort(x, 0, x.length-1);

    System.out.println();
    System.out.println("result");
    showArray(x);
  }

  static void quickSort(int[] a, int left, int right){
    int pl=left;
    int pr=right;
    int x=a[(left+right)/2];
  do{
    while(a[pl] < x)pl++;
    while(a[pr] > x)pr--;
    if(pl<=pr){
      int tmp = a[pl];
      a[pl] = a[pr];
      a[pr] = tmp;
      pl++; pr--;
    }
  }while(pl<=pr);
  if(left < pr)quickSort(a, left, pr);
  if(pl < right)quickSort(a, pl, right);
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
