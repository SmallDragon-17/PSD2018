import java.util.Scanner;
import java.util.Random;

class Fsort{

	static void swap(int[] a, int indx1, int indx2){
		int t = a[indx1];
		a[indx1] = a[indx2];
		a[indx2] = t;
	}

	static void fSort(int [] a , int n ){
		int max = a[0];
		for(int i = 1; i<n ; i++)	//配列内の最大値を求める
			if(a[i]>max)
				max = a[i];

		int[] f = new int[max + 1];	//累積度数
		int[] b = new int[n];	//作業用配列

		for(int i = 0; i<n ; i++) f[a[i]]++;		//度数分布表の作成
		showArray(f);
		for(int i = 1; i<=max ; i++) f[i]+=f[i-1];	//累積度数の計算
		for(int i = n-1; i>=0 ; i--) b[--f[a[i]]] = a[i];//目的配列の作成
		for(int i = 0 ; i<n ; i++)   a[i] = b[i];	//bをaにコピー

		showArray(a,f);
	}

	public static void main(String args[]){
		Scanner stdIn = new Scanner(System.in);
		System.out.println("度数ソート");
		System.out.println("要素数");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		generateRandomValues(x,nx);

		for(int i = 0; i<nx;i++)
			System.out.println("x["+i+"] =" + x[i]);

		for(int i = 0; i<nx;i++)
			System.out.print(x[i]+" ");
		System.out.println();

		fSort(x,nx);

	}

	static void generateRandomValues(int[] array, int maxValue){
		Random rand = new Random();
		for(int i = 0 ; i<maxValue ; i++)
			array[i] = rand.nextInt(10);
	}

	static void showArray(int[] a ){	//度数分布表表示
		System.out.println("度数分布");
		for(int i = 0; i<a.length ; i++){
			System.out.print(i +" : "+ a[i]);
			for(int j = 0 ; j < a[i] ;j++)
				System.out.print("*");
			System.out.println();
		}
	}

	static void showArray(int[] a , int[] f){

		System.out.println("累積度数");
		for(int i = 0; i<f.length ; i++){
			System.out.print(i +" : "+ f[i]);
			for(int j = 0 ; j < f[i] ;j++)
				System.out.print("*");
			System.out.println();
                        
		
		}
                System.out.println("result");
                for(int i = 0;i<a.length;i++)
	        System.out.println("x["+i+"] =" + a[i]);

	}
}
