package packages;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.Stack;

public class Calculator {
	private boolean isOperator(String token) {
		
		// token が演算子 +, -, *, / のいずれかならば true を返すプログラムを以下に書きます。
		String[] operators = {"+", "-", "*", "/"};
    for (String operator: operators) {
      if (token.equals(operator)) return true;
    }
    return false;
	}

	private boolean isNumber(String token) {
		// token が数値ならば true を返すプログラムを以下に書きます。
		if (token.matches("[0-9]")) {
      return true;
    }
    return false;
	}

	public String getAnswer(String equation) {
		Stack stack = new Stack();
		StringTokenizer st = new StringTokenizer(equation);
    int a;
    int b;

		while (st.hasMoreElements()) {
			String token = st.nextToken();
			
			// token に数字や演算子が一つずつ順番に代入されていきます。
			// 演算子なら式を評価した結果を，数値ならその値が 
			// stack の先頭に格納されるプログラムを以下に書きます.
      if (isNumber(token)) {
        stack.push(token);
        continue;
      }
      if (isOperator(token)) {
        a = Integer.parseInt(String.valueOf(stack.pop()));
        b = Integer.parseInt(String.valueOf(stack.pop()));
        if (token.equals("+")) {
          stack.push(String.valueOf(b + a));
          continue;
        }
        if (token.equals("-")) {
          stack.push(String.valueOf(b - a));
          continue;
        }
        if (token.equals("*")) {
          stack.push(String.valueOf(b * a));
          continue;
        }
        if (token.equals("/")) {
          stack.push(String.valueOf(b / a));
          continue;
        }
		  }
    }
		
		// stack の先頭を数字に変換して返します。

		return String.valueOf(stack.peek());
	}

	// 答えだけ書く人は、この関数は削除する。
	public String getEquation(String equation) {
		Stack stack = new Stack();
		StringTokenizer st = new StringTokenizer(equation);
    String a;
    String b;

		while (st.hasMoreElements()) {
			String token = st.nextToken();
			
			// token に数字や演算子が一つずつ順番に代入されていきます。
			// それらを処理して、中置記法の数式が stack の先頭に格納されるよ
			// うなプログラムを以下に書きます.
      if (isNumber(token)) {
        stack.push(token);
        continue;
      }
      if (isOperator(token)) {
        a = String.valueOf(stack.pop());
        b = String.valueOf(stack.pop());
        stack.push("(" + b + token + a + ")");
      }
		}

		return String.valueOf(stack.peek());
	}
}