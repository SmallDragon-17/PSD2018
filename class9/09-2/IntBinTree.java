public class IntBinTree{

  static class Node{
    private int key;
    private Node left;
    private Node right;

    Node(int key, Node left, Node right){
      this.key = key;
      this.left = left;
      this.right = right;
    }

    int getKey(){
      return key;
    }

    void print(){
      System.out.println(key);
    }
  }

  private Node root;
  private int level = 0;

  public IntBinTree(){
    root = null;
  }

  public int search(int key){
    Node p = root;

    while(true){
      if(p == null)
        return -1;
      int cond = key - p.getKey();
      if(cond == 0)
        return p.getKey();
      else if(cond < 0)
        p = p.left;
      else
        p = p.right;
    }
  }

  private void addNode(Node node, int key){
    int cond = key - node.getKey();
    if(cond == 0)
      return;
    else if(cond < 0){
      if(node.left == null)
        node.left = new Node(key, null, null);
      else
        addNode(node.left, key);
    }else{
      if(node.right == null)
        node.right = new Node(key, null, null);
      else
        addNode(node.right, key);
    }
  }

  public void add(int key){
    if(root == null)
      root = new Node(key, null, null);
    else
      addNode(root, key);
  }

  public boolean remove(int key){
    Node p = root;
    Node parent = null;
    boolean isLeftChild = true;

    while(true){
      if(p == null)
        return false;
      int cond = key - p.getKey();
      if(cond == 0)
        break;
      else{
        parent = p;
        if(cond < 0){
          isLeftChild = true;
          p = p.left;
        }else{
          isLeftChild = false;
          p = p.right;
        }
      }
    }
    
    if(p.left == null){
      if(p == root)
        root = p.right;
      else if(isLeftChild)
        parent.left = p.right;
      else
        parent.right = p.right;
    }else if(p.right == null){
      if(p == root)
        root = p.left;
      else if(isLeftChild)
        parent.left = p.left;
      else
        parent.right = p.left;
    }else{
      parent = p;
      Node left = p.left;
      isLeftChild = true;
      while(left.right != null){
        parent = left;
        left = left.right;
        isLeftChild = false;
      }
      p.key = left.key;
      if(isLeftChild)
        parent.left = left.left;
      else
        parent.right = left.left;
    }
    return true;
  }

  private void printSubTree(Node node){
    if(node != null){
      level++;
      printSubTree(node.left);
      System.out.print(node.key + " (level=" + level + ")");
      if(node.left == null && node.right == null)
        System.out.println(" leaf");
      else
        System.out.println();
      printSubTree(node.right);
      level--;
    }
  }

  public void print(){
    printSubTree(root);
    level = 0;
  }

  private void printSubTreeR(Node node){
    if(node != null){
      level++;
      printSubTreeR(node.right);
      System.out.print(node.key + " (level=" + level + ")");
      if(node.left == null && node.right == null)
        System.out.println(" leaf");
      else
        System.out.println();
      printSubTreeR(node.left);
      level--;
    }
  }

  public void printReverse(){
    printSubTreeR(root);
    level = 0;
  }

  public int getMinKey(){
    Node p = root;
    if(p == null)
      return -1;
    else{
      while(p.left != null){
        p = p.left;
      }
    }
    return p.getKey();
  }

  public int getMaxKey(){
    Node p = root;
    if(p == null)
      return -1;
    else{
      while(p.right != null){
        p = p.right;
      }
    }
    return p.getKey();
  }
}
