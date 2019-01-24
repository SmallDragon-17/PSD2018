class OctalNumber extends Number{
  OctalNumber(int n){
    super(n);
  }

  public String toString(){
    String str = Integer.toOctalString(num);
    return str;
  }
}
