import java.util.Comparator;

public class LinkedListTester{
  static class Data{
    private Integer no;
    private String name;

    public String toString(){
      return "(" + no + ")" + name;
    }

    public void setData(int no, String name){
      this.no = no;
      this.name = name;
    }

    public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

    public static class NoOrderComparator implements Comparator<Data>{
      public int compare(Data d1, Data d2){
        return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
      }
    }

    public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

    public static class NameOrderComparator implements Comparator<Data>{
      public int compare(Data d1, Data d2){
        return d1.name.compareTo(d2.name);
      }
    }
  }

  public static void main(String[] args){

    LinkedList<Data> list = new LinkedList<Data>();


    String[] nameArray = {"fukuoka", "saga", "nagasaki", "kumamoto", "oita", "miyazaki", "kagoshim"};

    Data data;
    Data searchData = new Data();
    Data ptr;


    list.dump();


    for(int i=0; i<nameArray.length; i++){
      data = new Data();
      data.setData(i+1, nameArray[i]);
      list.addFirst(data);
    }

    list.dump();

    System.out.println();
    System.out.println("removeFirst");
    list.removeFirst();
    list.dump();

    System.out.println();
    System.out.println("removeLast");
    list.removeLast();
    list.dump();

    System.out.println();
    System.out.print("着目ノード：");
    list.printCurrentNode();


    System.out.println("removeCurrentNode");
    list.removeCurrentNode();
    list.dump();

    System.out.println();
    System.out.println("removeFirst");
    list.removeFirst();
    list.dump();

    System.out.println();
    System.out.println("next");
    list.next();
    list.dump();

    System.out.println();
    searchData.setData(-1, "oita");
    if(list.search(searchData, Data.NAME_ORDER) != null)
      System.out.println("探索成功：" + searchData);
    else
      System.out.println("探索失敗：" + searchData);


    searchData.setData(-1, "fukuoka");
    if(list.search(searchData, Data.NAME_ORDER) != null)
      System.out.println("探索成功：" + searchData);
    else
      System.out.println("探索失敗：" + searchData);


    System.out.println("clear");
    list.clear();
    list.dump();
  }
}
