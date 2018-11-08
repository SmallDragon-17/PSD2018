import java.util.Scanner;
import java.util.Random;

class HeapSort{

	static void swap(int[] a, int indx1, int indx2){
		int t = a[indx1];
		a[indx1] = a[indx2];
		a[indx2] = t;
	}

	static void heapSort(int [] a , int n){
		for(int i = (n-1)/2 ; i>=0; i--)	//a[i]〜a[i-1]をヒープ化
			downHeap(a,i,n-1);

		for(int i = n-1 ; i >0 ; i--){
			swap(a,0,i);			//最大要素と未ソート部末尾要素を交換
			downHeap(a,0,i-1);
		}
	}

	static void downHeap(int[] a , int left , int right){
		int temp = a[left];//根
		int child;	//大きいほうの子
		int parent;

		for(parent = left; parent < (right+1)/2 ; parent = child){
			int cl = parent*2+1; 	//右の子
			int cr = cl+1;		//左の子

			child = (cr<=right && a[cr]>a[cl])? cr:cl;
			if (temp >=a[child])
				break;
			a[parent] = a[child];
		}
		a[parent] = temp;

			System.out.println("ヒープ");
			showArray(a);
	
	}

	public static void main(String args[]){
		Scanner stdIn = new Scanner(System.in);
		System.out.println("ヒープソート");
		System.out.println("要素数");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		generateRandomValues(x,nx);

		for(int i = 0; i<nx;i++)
			System.out.println("x["+i+"] =" + x[i]);

		for(int i = 0; i<nx;i++)
			System.out.print(x[i]+" ");
		System.out.println();

		heapSort(x,nx);
                 
                System.out.println("result");
                for(int i=0; i<nx; i++)
                   System.out.println("x[" + i + "]=" + x[i]);
	}

	static void generateRandomValues(int[] array, int maxValue){
		Random rand = new Random();
		for(int i = 0 ; i<maxValue ; i++)
			array[i] = rand.nextInt(100);
	}

	static void showArray(int[] array){
			for(int j = 0;j<array.length;j++)
				System.out.print(array[j]+" ");
			System.out.println();
	}
}
