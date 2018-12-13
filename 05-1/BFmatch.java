 //力まかせ法による文字列探索

import java.util.*;

class BFmatch{

    //最も先頭に近いパターンを探す
    public static int bfmatch(String txt, String pat){
	int pt=0;  //txtをなぞるカーソル
	int pp=0;  //patをなぞるカーソル

	while(pt != txt.length() && pp != pat.length()){
	    if(txt.charAt(pt)==pat.charAt(pp)){
		pt++;
		pp++;
	    }
	    else{
		pt = pt-pp+1;
		pp=0;
	    }
	}
	if(pp==pat.length()){return pt-pp;}  //探索成功
	return -1;  //探索失敗
    }

    //最も末尾に近いパターンを探す
    public static int bfmatchLast(String txt, String pat){
	int pt = txt.length()-1;
	int pp = pat.length()-1;

	while(pt >= 0 && pp >= 0){
	    if(txt.charAt(pt)==pat.charAt(pp)){
		pt--;
		pp--;
	    }
	    else{
		pt = pt + (pat.length() - pp) - 2;
		pp = pat.length()-1;
	    }
	}
	if(pp < 0){return pt+1;}  //探索成功
	return -1;  //探索失敗
    }
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	System.out.print("テキスト:");
	String s1 = sc.next();

	System.out.print("パターン:");
	String s2 = sc.next();

	int idx = bfmatch(s1, s2);

	if(idx==-1){System.out.println("テキスト中にパターンは存在しません");}
	else{
	    //マッチ文字の直前までの半角での文字列を求める
	    int len=0;
	    for(int i=0; i<idx; i++){
		len += s1.substring(i, i+1).getBytes().length;
	    }
	    len += s2.length();

	    System.out.println((idx+1)+"文字目にマッチします。");
	    System.out.println("テキスト:"+s1);
	    System.out.printf(String.format("パターン:%%%ds\n", len), s2);
	}
    }
}
