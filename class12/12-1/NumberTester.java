class NumberTester{
  public static void main(String[] args){
    DecimalNumber n10 = new DecimalNumber(12);
    BinaryNumber n2 = new BinaryNumber(12);
    OctalNumber n8 = new OctalNumber(12);
    HexNumber n16 = new HexNumber(12);

    System.out.println("10進数: " + n10);
    System.out.println("2進数: " + n2);
    System.out.println("8進数: " + n8);
    System.out.println("16進数: " + n16);
  }
}
