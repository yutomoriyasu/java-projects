import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import packages.Stack;

public class StackMain {

	public static void main(String[] args) {
		String command, input; // コマンドと入力
		int initSize = 4; // スタックの配列初期サイズ
		Stack theStack = new Stack(initSize); // スタック作成
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //標準入力をバッファに格納

		while (true) { // quitが入力されるまでループ
			command = "";
			input = "";
			System.out.print("command > ");
			System.out.flush();
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());

				// この部分では，キーボードから入力された文字列を
				// String 型の変数 command (コマンド名) と input (入力データ)
				// に代入する．たとえば，"push test" とキーボードから打つと，
				// command: "push", input: "test" が代入される．
				
				if (st.hasMoreElements()) { //列挙にさらに要素があるか判定 true false
					command = st.nextToken();
				}
				if (st.hasMoreElements()) {
					input = st.nextToken();
				}

				System.out.println(command + " " + input);
				System.out.flush();
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}

			if (command.equals("quit")) {
				// ここにquitと入力されたときの処理を書く
        System.out.println("StackMain Terminated");
        return;

			} else if (command.equals("push")) {

				// ここにpushと入力されたときの処理を書く
        theStack.push(input);
        System.out.println(input + " pushed to the stack");

			} else if (command.equals("pop")) {
				
				// ここにpopと入力されたときの処理を書く
        String popResult = theStack.pop();
        if (popResult != "") {
          System.out.println(popResult + " is popped from the stack");
        } else {
          System.out.println("The stack is empty. There is nothing to pop");
        }

			} else if (command.equals("peek")) {
				
				// ここにpeakと入力されたときの処理を書く
        String peekResult = theStack.peek();
        if (peekResult != "") {
          System.out.println(peekResult + " is on top of the stack");
        } else {
          System.out.println("The stack is empty. There is nothing to peek");
        }

			} else {
				System.out.println("Command is not found: " + command); //指定コマンド以外が入力されたときに表示される
			}
		}
	}

}