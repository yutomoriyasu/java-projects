import java.io.*;
import java.util.*;

public class SinSolver {

    // 積分方法を指定するための定数
    private static final int SOL_2P = 1;
    private static final int SOL_4P = 2;

    public static void main(String[] args) {

        // 積分方法毎に異なるインスタンスを生成
        SinSolver solver = new SinSolver();

        try {
            // 積分方法を指定する部分
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("2 points Gauss > Put 1");
            System.out.println("4 points Gauss > Put 2");
            System.out.print("How to solve? >");
            System.out.flush();
            int sol = Integer.parseInt(br.readLine());

            double ans = 0.0;
            if (sol == SOL_2P) {
                ans = solver.solve2point();
            } else if (sol == SOL_4P) {
                ans = solver.solve4point();
            } 
            System.out.println("integral 2 points: " + ans);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


    private double DOWN = 0;
    private double UP = Math.PI / 2;

    private static final double X_4_1 = 0.861136311;
    private static final double X_4_2 = 0.339981043;

    private static final double ALPHA_4_1 = 0.347854845;
    private static final double ALPHA_4_2 = 0.652145154;

    private static final double X_2 = 0.577350269;

    private static final double ALPHA_2 = 1.0;


    public double solve2point() {
        //
        // 課題 1
        //
        return (UP-DOWN)/2 * (ALPHA_2 * fun(changeRange(X_2)) + ALPHA_2 * fun(changeRange(-X_2)));
    }

    public double solve4point() {
        //
        // 課題 2
        //
        return (UP-DOWN)/2 * (
            ALPHA_4_1 * fun(changeRange(X_4_1)) + ALPHA_4_1 * fun(changeRange(-X_4_1))
            +  ALPHA_4_2 * fun(changeRange(X_4_2)) + ALPHA_4_2 * fun(changeRange(-X_4_2))
        );
    }

    // sin(x) を返す　使わなくても良い
    public double fun(double x) {
        double fx = Math.sin(x);
        return fx;
    }

    // 変数変換をsolve4pint()などの中で行う場合はこの関数は使わなくてもよい
    private double changeRange(double x) {
        double changeVariable = ((UP - DOWN) * x / 2) + ((UP - DOWN) / 2);
        return changeVariable;
    }
}