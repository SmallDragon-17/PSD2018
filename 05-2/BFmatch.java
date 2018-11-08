import java.util.Scanner;

class BFmatch{
    static int bfMatchCount(String txt, String pat){
        int pt = 0;
        int pp = 0;
        int i = 0;

        while(pt != txt.length()){
            if(txt.charAt(pt) == pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt = pt - pp + 1;
                pp = 0;
            }
            if(pp == pat.length()){
                i++;
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        return i;
    }

    static char[] bfMatchChange(String txt, String pat){
        int pt = 0;
        int pp = 0;
        char[] txtList = new char[txt.length()];
        for(int i=0; i<txt.length(); i++) txtList[i] = txt.charAt(i);

        while(pt != txt.length()){
            if(txt.charAt(pt) == pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt = pt - pp + 1;
                pp = 0;
            }
            if(pp == pat.length()){
                for(int i = pt-pp; i<pt-pp+pat.length(); i++)
                    txtList[i] = '@';
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        return txtList;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("テキスト：");
        String s1 = sc.next();

        System.out.print("パターン：");
        String s2 = sc.next();

        int idx = bfMatchCount(s1, s2);

        char[] ans = bfMatchChange(s1, s2);

        System.out.println(s1);
        for(int i=0; i<s1.length(); i++)
            System.out.print(ans[i]);
        System.out.println();
        System.out.println("出現回数：" + idx);
        System.out.println("置換文字数：" + (idx * s2.length()));
    }
}
