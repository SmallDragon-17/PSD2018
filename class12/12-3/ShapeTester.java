class ShapeTester{
  public static void main(String[] args){
    Shape s = new Square(3);
    Shape c = new Circle(5);
    Shape t = new Triangle(2);

    s.draw();
    c.draw();
    t.draw();
  }
}
