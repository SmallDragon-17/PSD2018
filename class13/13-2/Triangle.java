class Triangle{
  int nvertex;
  int nside;
  int base;
  int height;

  public Triangle(int b, int h){
    nvertex = 3;
    nside = 3;
    base = b;
    height = h;
  }

  public int getArea(){
    return base*height/2;
  }

  public int getNVertex(){
    return nvertex;
  }

  public int getNSide(){
    return nside;
  }
}
