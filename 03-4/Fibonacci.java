import java.util.Scanner;
class Fibonacci
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("n = "); int n = sc.nextInt();
		for(int i=0;i<=n;i++){
			if(i==n)
				System.out.println(Fibo(i)+", ");
			else
				System.out.print(Fibo(i)+", ");
		}
	}
	public static int Fibo(int n)
	{
		int num;
		if(n>=2)
			num = Fibo(n-1)+Fibo(n-2);
		else
			num = n;
		return num;
	}
}
