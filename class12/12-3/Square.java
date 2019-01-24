class Square implements Shape{
  int x;

  Square(int x){
    this.x = x;
  }

  public void draw(){
    for(int i=0; i < x; i++){
      System.out.print("■ ");
    }
    System.out.println();
  }
}
