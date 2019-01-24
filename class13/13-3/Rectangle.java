class Rectangle extends Figure{
  int width;
  int height;

  public Rectangle(int w, int h){
    super(4,4);
    width = w;
    height = h;
  }
 
  public int getArea(){
    return width*height;
  }
}
