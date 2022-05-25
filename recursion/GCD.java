import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
				
		// キーボード入力を使う。
    Scanner scanner = new Scanner(System.in);
    System.out.println("大きい方の整数を入力してください。");
    int a = scanner.nextInt();				
    System.out.println("小さい方の整数を入力してください。");
    int b = scanner.nextInt();
    System.out.println("入力された整数は"+a+"と"+b+"ですね。");
    scanner.close(); //Scannerも閉じた方が良い。

    //最大公約数を計算し、表示する
    int result=getCommonDivisor(a,b);
    System.out.println(a+"と"+b+"の最大公約数は"+result+"です。");				
	}
	
	private static int getCommonDivisor(int x, int y) {
    //引数でもらって来たx,yを念のため大小比較し、大きい方を小さい方でわる
		if (x < y) {
      int tmp = x;
      x = y;
      y = tmp;
    }
    int remainder = x % y;

    //その余りが0ならばその時の小さい方の数が答えなのでそれをreturn
    if (remainder == 0) {
      return y;
    }

    // もし0でなければ自分を再帰的に呼び出す
    return getCommonDivisor(y, remainder);
	}
}