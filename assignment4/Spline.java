import java.io.*;

public class Spline {
    public static void main(String[] args) {
        Spline s = new Spline();
        
        // 入力節点のデータ
        int Nnode = 0; // 節点数
        double x[] = null; // 節点のx座標
        double f[] = null; // 節点のy座標
        double[] fdash = null; // 節点での1次微係数

        // 補間曲線のデータ
        double x_int_start = 0; // 補間の開始x座標
        double x_int_end = 0; // 補間の終了x座標
        int Nint = 20; // 出力する補間曲線の点数
        double[] intX = new double[Nint]; // 補間データを保持する配列
        double[] intY = new double[Nint]; // 補間データを保持する配列

        // 入力処理
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("節点データの数？ = ");
            System.out.flush();
            Nnode = Integer.parseInt(br.readLine());

            x = new double[Nnode];
            f = new double[Nnode];
            fdash = new double[Nnode];

            for (int i = 0; i < Nnode; i++) {
                // x座標を昇順に入力することとする
                System.out.print("x,y {1 3, 2 7, 3 5, 4 6}" + (i + 1) + "点目>");
                System.out.flush();
                String[] str = br.readLine().split(" ");
                x[i] = Double.parseDouble(str[0]);
                f[i] = Double.parseDouble(str[1]);
            }

            // 補間する範囲はx[]を使って決める
            x_int_start = x[0];
            x_int_end = x[x.length - 1];
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        // 補間の準備 補間曲線のx座標をセット
        double dx = (x_int_end - x_int_start) / (double) (Nint - 1);
        for (int i = 0; i < Nint; i++) {
            intX[i] = x_int_start + dx * (double) i;
        }

        // hiを準備
        double h[] = new double[Nnode];
        for (int i = 0; i < x.length - 1; i++) {
            h[i] = x[i + 1] - x[i];
        }
        
        //--------------------------------------------------------------------
        // ここから課題部分
        //--------------------------------------------------------------------
        // [a][fdash] = [b]
        // 拡大係数行列aaを作成
        double aa[][] = new double[x.length][x.length  + 1];

        // (11)式を参考に拡大係数行列を作成する。
        // 最初の行と最後の行は自然条件
        // 中間の行は繰り返し



        
        // aaをガウスの消去法で解く
        aa = s.PivotGauss(aa);
        
        
        // aaの中にfdashの値が含まれているはずなので、その部分をfdashに転記する
        
        
        
        
        
        //--------------------------------------------------------------------
        // 課題ここまで
        //--------------------------------------------------------------------

        // 式(5a-d)を使って、 ai, bi, ci, diを求める
        // 式(1)によってy=f(x)を求める
        double ai, bi, ci, di; // , dx;
        for (int j = 0, i = 0; i < x.length - 1; i++) {
            // (5a)(5b)(5c)(5d)
            ai = (2.0 * (f[i] - f[i + 1]) / h[i] + fdash[i] + fdash[i + 1]) / (h[i] * h[i]);
            bi = (3.0 * (f[i + 1] - f[i]) / h[i] - 2.0 * fdash[i] - fdash[i + 1]) / h[i];
            ci = fdash[i];
            di = f[i];
            while (intX[j] < x[i + 1]) {
                dx = intX[j] - x[i];
                // 式(1)
                intY[j] = ai * (dx * dx * dx) + bi * (dx * dx) + ci * dx + di;
                if (j < intX.length)
                    j++;
            }

            System.out.println("a[" + i + "]: " + ai);
            System.out.println("b[" + i + "]: " + bi);
            System.out.println("c[" + i + "]: " + ci);
            System.out.println("d[" + i + "]: " + di);
        }
        intY[intX.length - 1] = f[x.length - 1];

        // 補間結果
        System.out.println("補間曲線の出力");
        for (int i = 0; i < Nint; i++) {
            System.out.println(intX[i] + "," + intY[i]);
        }
    }

    /*
     * ガウス消去法 m元連立方程式の解を求める手法である 
     * 解くにあたり係数行列と右辺ベクトルを 合わせてm×(m+1)の行列求め、引数matrixとして用いる
     * ガウス消去法の処理が行われ、戻り値aのm+1列目がm元連立方程式の解にあたる
     */
    public double[][] PivotGauss(double[][] matrix) {
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