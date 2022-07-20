import java.io.*;

public class DifferentialSolver {
    // 読み込むファイル名
    private static final String INPUT_FILE_NAME = "points.txt";
    // 読み込む点の数(上から数えて)
    private static final int NUM_POINT = 3;
    // 点の次元数
    private static final int DIM_POINT = 2;

    // 実行用のmain関数
    public static void main(String[] args) {
        DifferentialSolver solver = new DifferentialSolver();
        double points[][] = solver.readPoints();
        double diff = solver.getDiff(points);
        System.out.println("Differential coefficient = " + diff);
    }

    // ファイルを読んでNUM_POINT*DIM_POINTの配列を投げるメソッド
    static double[][] readPoints() {
        double points[][] = new double[NUM_POINT][DIM_POINT];
        try {
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            int i = 0;
            String str = null;
            // ファイルを行単位で読む
            while ((str = br.readLine()) != null) {
                // コンマ","で文字列を区切って配列へ格納
                String strArray[] = str.split(",");
                // 次元がおかしい場合はエラーを投げる
                if (strArray.length != DIM_POINT)
                    throw new NumberFormatException();
                // 点の情報を配列として格納
                for (int j = 0; j < DIM_POINT; j++) {
                    points[i][j] = Double.parseDouble(strArray[j]);
                    System.out.println("" + points[i][j]);
                }
                i++;
                // 規定の数の点を読み込んだら終了
                if (i == NUM_POINT) {
                    break;
                }
            }
            System.out.println("End of reading");
            br.close();
            // 例外処理の記述
        } catch (NumberFormatException e) {
            System.out.println("File format is wrong.");
        } catch (FileNotFoundException e) {
            System.out.println("text file \"" + INPUT_FILE_NAME + "\" was not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return points;
    }

    // 資料中のhの定義
    private static final double H = 1.0E-01;

    // 数値計算で微分係数を求めるメソッド
    static double getDiff(double[][] points) {

        //
        // 課題ここ
        // 
        return (1/(2*0.1)) * (points[NUM_POINT-1][DIM_POINT-1] - points[0][DIM_POINT-1]);


    }

}