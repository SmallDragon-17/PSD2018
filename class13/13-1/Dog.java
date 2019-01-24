class Dog extends Animal{
  public Dog(int age){
    super(age);
  }

  public void walk(){
    System.out.println("犬(" + age + "歳)が歩く");
  }

  public void bite(){
    System.out.println("犬(" + age + "歳)が噛む");
  }
}
