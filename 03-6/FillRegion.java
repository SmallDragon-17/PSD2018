import java.util.Scanner;

class FillRegion{
  public final static int BACK = 0; // 背景画素値
  public final static int BORDER = 1; // 境界画素値
  public final static int REGION = 2; // 領域画素値
  static int target; // 注目画素値
  static int width,height; // 画像サイズ
  static int[][] dot = {
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
    {0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
    {0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
    {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
    {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
    {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
    {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
    {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
    {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
    {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
  };
  static void fill(int x, int y){
    dot[x][y] = REGION;
    if(dot[x][y-1] == target) fill(x, y-1);
    if(dot[x+1][y] == target) fill(x+1, y);
    if(dot[x][y+1] == target) fill(x, y+1);
    if(dot[x-1][y] == target) fill(x-1, y);
  }

  static void show(){
    System.out.println(width + " x " + height);
    System.out.print(" ");
    for(int y=0; y<height; y++){
      System.out.printf("%2d", y);
    }
    System.out.println();
    for(int x=0; x<width; x++){
      System.out.printf("%2d ", x);
      for(int y=0; y<height; y++){
      switch (dot[x][y]){
        case BACK:
          System.out.print("□");
          break;
        case BORDER:
          System.out.print("■");
          break;
        case REGION:
          System.out.print("＊");
          break;
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args){
    width = dot.length;
    height = dot[0].length;
    show(); // 表示（塗りつぶし前）
    target = dot[8][8];
    fill(5, 8);
    show(); // 表示（塗りつぶし後）
  }
}
