class Complex{
  public double real;
  public double imag;

  public Complex(double r, double i){
    real = r;
    imag = i;
  }

  public Complex(double r){
    real = r;
    imag = 0;
  }

  String ToString(){
    return String.valueOf(this.real) + " +　" + String.valueOf(this.imag) + "i";
  }

  double real(){
    return real;
  }

  double imag(){
    return imag;
  }

  static Complex add(Complex c1, Complex c2){
    double re = c1.real + c2.real;
    double im = c1.imag + c2.imag;
    return new Complex(re, im);
  }

  static Complex sub(Complex c1, Complex c2){
    double re = c1.real - c2.real;
    double im = c1.imag - c2.imag;
    return new Complex(re, im);
  }

  static Complex mul(Complex c1, Complex c2){
    double re = c1.real*c2.real - c1.imag*c2.imag;
    double im = c1.real*c2.imag + c1.imag*c2.real;
    return new Complex(re, im);
  }

  static Complex div(Complex c1, Complex c2){
    double c = c2.real;
    double d = c2.imag;
    double re = (c1.real*c2.real + c1.imag*c2.imag)/(c*c + d*d);
    double im = (c1.imag*c2.real - c1.real*c2.imag)/(c*c + d*d);
    return new Complex(re, im);
  }

  Complex add(Complex c){
    double re = this.real + c.real;
    double im = this.imag + c.imag;
    return new Complex(re, im);
  }

  Complex sub(Complex c){
    double re = this.real - c.real;
    double im = this.imag - c.imag;
    return new Complex(re, im);
  }

  Complex mul(Complex c){
    double re = this.real*c.real - this.imag*c.imag;
    double im = this.real*c.imag + this.imag*c.real;
    return new Complex(re, im);
  }

  Complex div(Complex c){
    double a = c.real;
    double b = c.imag;
    double re = (this.real*c.real + this.imag*c.imag)/(a*a + b*b);
    double im = (this.imag*c.real - this.real*c.imag)/(a*a + b*b);
    return new Complex(re, im);
  }

  Complex con(){
    return new Complex(real, -imag);
  }
}
