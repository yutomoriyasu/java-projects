import java.io.*;
import java.util.*;

public class IntegralSolver {

    public static final int SOL_TRA = 1;
    public static final int SOL_GAU = 2;

    public static void main(String[] args) {

        IntegralSolver solver = new IntegralSolver();
        try {
            // 積分方法を指定する部分
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Trapezoidal rule > Put 1");
            System.out.println("Gaussian quadrature > Put 2");
            System.out.print("How to solve? >");
            System.out.flush();
            int sol = Integer.parseInt(br.readLine());

            // 積分方法毎に呼び出す関数を選択
            double ans = 0.0;
            if (sol == SOL_TRA) {
                ans = solver.trapezoidal_solve(-1.0, 1.0);
            } else if (sol == SOL_GAU) {
                ans = solver.gauss_solve(-1.0, 1.0);
            }
            
            System.out.println("Integration = " + ans);

            // 例外処理の記述
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // aからbまでの関数f(x)の台形積分結果を返す
    public double trapezoidal_solve(double a, double b) {
        //
        //　課題部分 1
        //
        return ((b-a)/2) * (fun(b)+fun(a));
    }

    // aからbまでの関数f(x)の2点のガウス積分結果を返す
    public double gauss_solve(double a, double b) {
        //
        //　課題部分 2
        //
        return 1*fun(1/Math.sqrt(3))+1*fun(-1/Math.sqrt(3));
    }

    // exp(x) を返す
    // 使わなくてもよい
    public double fun(double x) {
        return Math.exp(x);
    }
}