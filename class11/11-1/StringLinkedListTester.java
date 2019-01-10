public class StringLinkedListTester{
    public static void main(String[] args){

      // リストを生成
	StringLinkedList list = new StringLinkedList();
      // リストの表示
        list.dump();
      // 末尾にノードを挿入
        System.out.println("addLast");
	list.addLast("A");
        list.dump();
        System.out.println("addLast");
        list.addLast("B");
        list.dump();
        System.out.println("addLast");
        list.addLast("C");
        list.dump();
        System.out.println("addLast");
        list.addLast("D");
	list.dump();
      // リストのノード数
	System.out.println("ノード数：" + list.size());
        System.out.println();
      // 先頭ノードを取得
	System.out.println("getFirstNode");
	System.out.println(list.getFirstNode());
	list.dump();
      // リストのノード数
	System.out.println("ノード数：" + list.size());
    }
}
