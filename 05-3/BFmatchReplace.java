import java.util.HashMap;
import java.util.Scanner;

class BFmatchReplace{
    static HashMap<String, Object> bfMatchReplace(String txt, String pat, String word){
        HashMap<String, Object> hashmap = new HashMap<>();
        StringBuilder sb = new StringBuilder().append(txt);

        int pt = 0;
        int pp = 0;
        int i = 0;

        while(pt != txt.length()){
            if(sb.charAt(pt) == pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt = pt - pp + 1;
                pp = 0;
            }
            if(pp == pat.length()){
                sb.replace(pt - pat.length(), pt, word);
                i++;
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        hashmap.put("text", sb.toString());
        hashmap.put("count", i);
        return hashmap;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("テキスト：");
        String s1 = sc.next();

        System.out.print("検索パターン：");
        String s2 = sc.next();

        System.out.print("置換後のパターン：");
        String s3 = sc.next();

        HashMap<String, Object> ans = bfMatchReplace(s1, s2, s3);

        System.out.println(s1);
        System.out.println(ans.get("text"));
        System.out.println("置換回数：" + ans.get("count"));
    }
}
