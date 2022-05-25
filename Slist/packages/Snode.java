package packages;

public class Snode {
	private String data;//ノードのデータ要素
  private int count;//このデータが入力された回数
  private Snode prev;//前のノード
  private Snode next;//次のノード
  
  public Snode(String x) {
    data  = x;
    count = 1;
  }
  public Snode getPrev() {
    return prev;
  }
  public Snode getNext() {
      // ここに記述します
    return next;
  }
  public void setPrev(Snode prev) {
    this.prev = prev;
  }
  public void setNext(Snode next) {
    this.next = next;
  }
  public String getData() {
    return this.data; 
  }
  public int getCount() {
    return this.count;
  }
  public void increaseCount() {
    this.count++;
  }
  public void decreaseCount() {
    this.count--;
  }
}