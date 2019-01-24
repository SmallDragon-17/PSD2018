class HexNumber extends Number{
  HexNumber(int n){
    super(n);
  }

  public String toString(){
    String str = Integer.toHexString(num);
    return str;
  }
}
