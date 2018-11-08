public class IntLinkedListTester {
    public static void main(String[] args){
	
	IntLinkedList list = new IntLinkedList();

	list.dump();
	list.addFirst(10);
	list.addFirst(20);
	list.addFirst(30);
        list.addFirst(40);

	list.addLast(50);
	list.addLast(60);
	list.addLast(70);
	list.addLast(80);
	list.dump();

	System.out.println("ノード数：" + list.size());
        System.out.println("removeFirst" );
	
	list.removeFirst();
	list.dump();

	System.out.println("ノード数：" + list.size());
	System.out.println("removeLast");

	list.removeLast();
	list.dump();

	System.out.println("ノード数：" + list.size());
        System.out.print("着目ノード:");

	list.printCurrentNode();

	System.out.println("removeCurrentNode");

	list.removeCurrentNode();
	list.dump();

	System.out.println("ノード数：" + list.size());
	System.out.println("removeFirst");

	list.removeFirst();
	list.dump();

	System.out.println("ノード数：" + list.size());
	System.out.println("next");

	list.next();
	list.dump();

	int searchData = 10;

	if(list.search(searchData) != -1)
	    System.out.println("探索成功：" + searchData);
	else
	    System.out.println("探索失敗：" + searchData);

	searchData = 80;

	if(list.search(searchData) != -1)
	    System.out.println("探索成功：" + searchData);
	else
	    System.out.println("探索失敗：" + searchData);

	System.out.println("ノード数：" + list.size());
	System.out.println("clear");

	list.clear();
	list.dump();

	System.out.println("ノード数：" + list.size());
    }
}
	

	
