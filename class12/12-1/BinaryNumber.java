class BinaryNumber extends Number{
  BinaryNumber(int n){
    super(n);
  }

  public String toString(){
    String str = Integer.toBinaryString(num);
    return str;
  }
}
