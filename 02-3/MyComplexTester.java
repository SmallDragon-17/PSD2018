class MyComplexTester{
  public static void main(String[] args){

    Complex a = new Complex(2, 3);
    Complex b = new Complex(4, 5);
    Complex c,d,e,f;
    Complex g,h,i,j;
    Complex k;

    c = Complex.add(a, b);
    d = Complex.sub(a, b);
    e = Complex.mul(a, b);
    f = Complex.div(a, b);
    g = a.add(b);
    h = a.sub(b);
    i = a.mul(b);
    j = a.div(b);
    k = a.con();

    System.out.println("a = " + a.ToString());
    System.out.println("b = " + b.ToString());
    System.out.println();

    System.out.println("c = a + b = " + c.ToString());
    System.out.println("d = a - b = " + d.ToString());
    System.out.println("e = a * b = " + e.ToString());
    System.out.println("f = a / b = " + f.ToString());
    System.out.println();

    System.out.println("g = a + b = " + g.ToString());
    System.out.println("h = a - b = " + h.ToString());
    System.out.println("i = a * b = " + i.ToString());
    System.out.println("j = a / b = " + j.ToString());
    System.out.println();


    System.out.println("k = a* = " + k.toString());

  }
}
