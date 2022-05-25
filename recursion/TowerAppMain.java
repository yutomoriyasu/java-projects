public class TowerAppMain {
	
	public static void doTowers(int topN, char from, char to, char work){
		
		if(topN == 1) {
			System.out.println("Move disk 1 from " + from + " to " + to);
    } else {
			//ここの部分を自分で書いてください
      doTowers(topN - 1, from, work, to);
      System.out.println("Move disk " + topN + " from " + from + " to " + to);
      doTowers(topN - 1, work, to, from);
		}
	}	

	public static void main(String[] args){
		char s = 'a';
    char g = 'b';
    char w = 'c';
    int n = 4; //ここの数字を適宜変更し、動作を確認する
    System.out.println("Number of Plates is " + n );
    doTowers(n, s, g, w);
	}
}
