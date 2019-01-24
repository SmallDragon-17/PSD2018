abstract class Figure{
  int nvertex;
  int nside;

  public Figure(int a, int b){
    nvertex = a;
    nside = b;
  }

  public int getNVertex(){
    return nvertex;
  }

  public int getNSide(){
    return nside;
  }
}
