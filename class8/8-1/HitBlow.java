import java.util.Scanner;

class HitBlow 
{
 static int c = 4;
 static int[] answer = new int[c];
 static int[] input = new int[c];
 static int hit,blow;
	
 public static void makeAnswer(int c)
 {
  int[] array = {0,1,2,3,4,5,6,7,8,9};
  int remainder = 10;
  for (int i = 0; i < c; i++)
  {
   int select = (int)(Math.random() * remainder);
   answer[i] = array[select];
   array[select] = array[remainder-1];
   remainder--;
  }		
 } 	
 public static void typeNumber()
 {
  Scanner scan = new Scanner(System.in);
  String str;
  do {		
   System.out.print("４桁の数字の入力：");			
   str = scan.nextLine();
  }while(chkNum(str) == false || chkRepeat(str) == false);
  for (int i = 0;i < c;i++) input[i] = Integer.parseInt(str.substring(i,i+1));	 
 }
 static boolean chkNum(String n)
 {
  if (n.length() != c) 
  {
   System.out.println("ERROR:" + c + "桁で入力してください");
   return false;
  }try{
   Integer.parseInt(n);
   return true;
  } catch (NumberFormatException e){
   System.out.println("ERROR:数値を入力してください");
   return false;
  }
 }
 static boolean chkRepeat(String n) 
 {
  for (int i = 0;i < c;i++)
  {
   for (int j = i +1;j < c;j++)
   {
    if (n.charAt(i) == n.charAt(j))
    {
     System.out.println("ERROR:重複しないようにしてください");	
     return false;
    }
   }		
  }
  return true;	
 }

 static void getHitBlow(int[] an,int[] in)
 {
  hit = blow = 0;
  for (int i = 0;i < c;i++)
  {
   if(in[i] == an[i]) hit++;
  }
  for (int i = 0;i < c;i++)
  {
   for (int j = 0;j < c;j++)
   {
    if (in[i] == an[j]) blow++;
   }
  }
  blow -= hit;
  System.out.println(hit + "Hit!! : " + blow + "Blow");
 }
 public static void main(String[] args)
 {
  makeAnswer(c);
  int count = 1;		
  while(true)
  {
   System.out.println("" + count + "回目");
   typeNumber();
   getHitBlow(answer,input);
 	
   if (hit == c) break;
    count++;
  }
  System.out.println("正解！！ " + count + "回目で当たりました。");
 }
}
