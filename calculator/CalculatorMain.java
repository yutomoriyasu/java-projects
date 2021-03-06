import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import packages.Calculator;

public class CalculatorMain {

	public static void main(String[] args) {
				
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.print("input > ");
				System.out.flush();

				String line = br.readLine();
				if (line.equals("quit")) {
					break;
				}

				Calculator calc = new Calculator();
				
				// 中置記法の数式まで含める人は下記を使う
				 System.out.println(calc.getEquation(line) + " = " + calc.getAnswer(line));
				
				// 答えだけ書く人は下記
				System.out.println("Answer = " + calc.getAnswer(line));
			}
		} 
		
		catch (IOException e) {
			System.out.println("Error: " + e);
		}

	}

}