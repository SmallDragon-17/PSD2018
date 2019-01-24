class Triangle extends Figure implements FigureArea{
  int base;
  int height;

  public Triangle(int b, int h){
    super(3,3);
    base = b;
    height = h;
  }

  public int getArea(){
    return base*height/2;
  }
}
