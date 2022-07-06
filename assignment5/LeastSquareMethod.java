import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeastSquareMethod {

    private double[] x = new double[10];
    private double[] y = new double[10]; // 入力データ
    private int n; // 入力データ数
    private int d; // 次数
    private double a[][]; // 答えを格納するための拡大係数行列
    private String defInput; // default values inputs

    public static void main(String args[]){
		
		LeastSquareMethod lsm = new LeastSquareMethod();
		lsm.set();
		lsm.solve();
		lsm.print();
	}

    // double[] x, y, int n, dを初期化する
    public void set() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Want to use default values? [y/n]:");
            System.out.flush();
            defInput = br.readLine();
            if (defInput.equals("y")) {
                n = 6;
                d = 2 + 1;
                double[] x_default = { 0, 1, 2, 3, 4, 5 };
                double[] y_default = { 1, 3, 5, 5, 2, 0 };

                for (int i = 0; i < x_default.length; i++) {
                    x[i] = x_default[i];
                    y[i] = y_default[i];
                }

                System.out.print(" x[]:");
                for (int i = 0; i < x_default.length; i++) {
                    System.out.print(x[i] + " ");
                }
                System.out.println(" ");
                System.out.print(" y[]:");
                for (int i = 0; i < y_default.length; i++) {
                    System.out.print(y[i] + " ");
                }
                System.out.println(" ");

            } else {
                System.out.print("input the number of data:");
                System.out.flush();
                n = Integer.parseInt(br.readLine());
                System.out.print("input the degree of x:");
                System.out.flush();
                d = Integer.parseInt(br.readLine()) + 1;

                for (int i = 0; i < n; i++) {
                    System.out.print("input No." + i + " x:");
                    System.out.flush();
                    x[i] = Double.parseDouble(br.readLine());
                    System.out.print("input No." + i + " y:");
                    System.out.flush();
                    y[i] = Double.parseDouble(br.readLine());
                }
            }

        } catch (IOException e) {
            System.out.println("Error:" + e);
        }

    }

    // double[] x, y, int n, dを使ってa[][]を求める
    public void solve() {

        //
        // ここを作成
        //
        // 例えば以下のような流れとなる。
        // f0(x) = 1, f1(x) = x, f2(x) = x^2
        // Aの転置行列を作る 1, a*a, a*a*a
        double A[][] = new double[n][d];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < d; j ++) {
                if(j == 0) {
                    A[i][j] = 1;
                    continue;
                }
                if(j == 1) {
                    A[i][j] = x[i];
                    continue;
                }
                if(j == 2) {
                    A[i][j] = x[i] * x[i];
                    continue;
                }
            }
        }

        // Aを作る 1, a*a, a*a*a
        double At[][] = new double[d][n];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < d; j ++) {
                At[j][i] = A[i][j];
            }
        }
        
        // W=At*A を計算
        double W[][] = new double[d][d];
        for(int i = 0; i < d; i ++) {
            for(int j = 0; j < d; j ++ ) {
                for(int k = 0; k < n; k ++) {
                W[i][j] += At[i][k] * A[k][j];
                }
            }
        }
        
        // z=At*yを計算
        double z[] = new double[d];
        for(int i = 0; i < d; i ++) {
            for(int j = 0; j < n; j ++ ) {
                z[i] += At[i][j] * y[j];
            }
        }

        // Wとzを連結して拡大係数行列aを作成
        a = new double[d][d+1];
        for(int i = 0; i < d; i++) {
            for(int j = 0; j < d; j++) {
                a[i][j] = W[i][j];
            }
            a[i][d] = z[i];
        }

        //
        // ここまでを作成
        //

        // aをガウスの消去法で解く
        a = this.PivotGauss(a);

        return;
    }

    // aを出力する
    public void print() {
        for (int k = 0; k < a.length; k++) {
            System.out.println("a[" + k + "]: " + a[k][a[0].length - 1]);
        }
    }

    /*
     * ガウス消去法 m元連立方程式の解を求める手法である 解くにあたり係数行列と右辺ベクトルを合わせてm×(m+1)の行列求め、引数matrixとして用いる
     * ガウス消去法の処理が行われ、戻り値aのm+1列目がm元連立方程式の解にあたる
     */
    private double[][] PivotGauss(double[][] matrix) {
        double TINY = 1.0E-10;
        int N = matrix.length, j = 0, status = 0;
        double pivot, multi, sum, max, aik;
        double tmp[][] = new double[N][N + 1];

        for (int k = 0; k < N - 1; k++) {
            max = 0.0;
            for (int i = k; i < N; i++) {
                aik = Math.abs(matrix[i][k]);
                if (aik > max) {
                    max = aik;
                    j = i;
                }
            }
            if (j != k) {
                for (int i = 0; i < N + 1; i++) {
                    tmp[k][i] = matrix[k][i];
                    matrix[k][i] = matrix[j][i];
                    matrix[j][i] = tmp[k][i];
                }
            }
            // 前進消去

            pivot = 1.0 / matrix[k][k];
            multi = matrix[k + 1][k] * pivot;
            if (Math.abs(multi) > TINY) {
                for (int i = k + 1; i < N; i++) {
                    multi = matrix[i][k] * pivot;
                    for (j = k; j < N + 1; j++) {
                        matrix[i][j] -= multi * matrix[k][j];
                    }
                }
            } else {
                matrix[j][k] = 0.0;
            }
        }
        if (Math.abs(matrix[N - 1][N - 1]) < TINY)
            status = 9;

        if (status == 0) { // 後退代入
            for (int k = N - 1; k >= 0; k--) {
                sum = matrix[k][N];
                for (j = k + 1; j < N; j++) {
                    sum -= matrix[k][j] * matrix[j][N];
                }
                matrix[k][N] = sum / matrix[k][k];
            }
        } else {
            System.out.println(">pivotGauss, Failed! the system is singular.");
        }
        return matrix;
    }
}