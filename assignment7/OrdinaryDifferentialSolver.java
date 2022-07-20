import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class OrdinaryDifferentialSolver {
    double[] x = new double[10]; // xi用配列
    double[] y = new double[10]; // yi用配列
    double h; // 刻み幅 h
    double n; // xの範囲用変数 n

    public void solve() {

    }

    // 値を出力するメソッドprintSolution()
    public void printSolution() {
        for (int i = 0; i < n / h ; i++) {
            System.out.println("x" + (i + 1) + "=" + x[i] + ", y" + (i + 1) + "=" + y[i + 1]);
        }
        System.out.println("Solution : y[" + n + "] = " + y[ ((int)(n / h))]);
	}

    // 値をセットするメソッドset()
    public void set() {
        try {
            BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("step_size = ");
            System.out.flush();
            h = Double.parseDouble(sr.readLine());
            System.out.print("x <= ");
            System.out.flush();
            n = Double.parseDouble(sr.readLine());

            //ここから記入してください


            System.out.print("y(0) = ");
            System.out.flush();
            y[0] = Double.parseDouble(sr.readLine());
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
}