class Triangle implements Shape{
  int x;

  Triangle(int x){
    this.x = x;
  }

  public void draw(){
    for(int i=0; i < x; i++){
      System.out.print("▲ ");
    }
    System.out.println();
  }
}
