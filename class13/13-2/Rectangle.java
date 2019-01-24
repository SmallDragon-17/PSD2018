class Rectangle{
  int nvertex;
  int nside;
  int width;
  int height;

  public Rectangle(int w, int h){
    nvertex = 4;
    nside = 4;
    width = w;
    height = h;
  }
 
  public int getArea(){
    return width*height;
  }

  public int getNVertex(){
    return nvertex;
  }

  public int getNSide(){
    return nside;
  }
}
