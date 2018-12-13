//ボイヤームーア法

import java.util.*;

class BMmatch{

    public static int bmMatch(String txt, String pat){
	int pt;
	int pp;
	int txtLen = txt.length();
	int patLen = pat.length();
	int[] skip = new int[Character.MAX_VALUE + 1];

	for(pt=0; pt<= Character.MAX_VALUE; pt++){skip[pt]=patLen;}
	for(pt=0; pt<patLen-1; pt++){skip[pat.charAt(pt)]=patLen-pt-1;}

	while(pt < txtLen){
	    pp = patLen-1;
	    while(txt.charAt(pt) == pat.charAt(pp)){
		if(pp==0){return pt;}
		pp--;
		pt--;
	    }
	    pt += (skip[txt.charAt(pt)]>patLen - pp)? skip[txt.charAt(pt)]:patLen - pp;
	}
	return -1;
    }

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	
	System.out.print("テキスト:");
	String s1 = sc.next();
	
	System.out.print("パターン:");
	String s2 = sc.next();
	
	int idx = bmMatch(s1, s2);
	
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
	    System.out.printf(String.format("パターン:%%%ds\n", len),s2);
	}			      
    }
}
