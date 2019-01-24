class Cat extends Animal{
  public Cat(int age){
    super(age);
  }

  public void walk(){
    System.out.println("猫(" + age + "歳)が歩く");
  }

  public void scratch(){
    System.out.println("猫(" + age + "歳)がひっかく");
  }
}
