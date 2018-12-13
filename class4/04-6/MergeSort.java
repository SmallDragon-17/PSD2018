import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Merge{
  public static void main(String args[])throws IOException{

    System.out.println("乱数の最大値を入力してください");

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    String str  = br.readLine();
    int maxValue = Integer.parseInt(str);

    int[] x = new int[10];

    System.out.println("マージソート");
    System.out.println("要素数：" + x.length);
    generateRandomValues(x, maxValue);
    showArray(x);
    System.out.println();

    mergeSort(x);

    System.out.println();
    System.out.println("result");
    showArray(x);
  }

  static void mergeSort(int[] a){

    int n=a.length;
    if(n>1){
      int center = n/2;
      int[] former = new int[center];
      int[] later = new int[n-center];

      for(int i=0; i<former.length; i++)
        former[i] = a[i];
      for(int j=0; j<later.length; j++)
        later[j] = a[center + j];

      System.out.println("分割");
      mergeSort(former);//from here
      mergeSort(later);
      merge(former,later, a);//to here
    }
  }

  static void merge(int[] f, int[] l, int[] a){
    int pf=0, pl=0, pa=0;

    while(pf<f.length && pl<l.length){
      if(f[pf] <= l[pl])
        a[pa++] = f[pf++];
      else
        a[pa++] = l[pl++];
    }
    while(pf<f.length)
       a[pa++] = f[pf++];
    while(pl<l.length)
       a[pa++] = l[pl++];
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
