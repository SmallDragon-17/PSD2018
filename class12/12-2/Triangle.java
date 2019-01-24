class Triangle extends Shape{
  Triangle(int x){
    super(x);
  }

  void draw(){
    for(int i=0; i < x; i++){
      System.out.print("▲ ");
    }
    System.out.println();
  }
}
