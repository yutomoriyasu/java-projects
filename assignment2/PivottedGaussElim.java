import java.io.*;

public class PivottedGaussElim{
    int status;

    public static void main(String[] args){
        PivottedGaussElim g = new PivottedGaussElim();
        g.solvePivotGauss();
    }
    void solvePivotGauss(){
    	
    	try{
    		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    		System.out.print("Numbers of variables = ");
    		System.out.flush();
    		int n=Integer.parseInt(br.readLine());
    		double a[][] = new double[n][n+1];
    	     for(int i=0;i<n;i++){
    	    	 System.out.print("Row"+(i+1)+">");
    	    	 System.out.flush();
    	    	 String stri=br.readLine();
    	    	 String[] str=stri.split(" ");
    	    	 for(int j=0;j<n+1;j++){
    	    		 a[i][j]=Double.parseDouble(str[j]);
    	    	 }
    	     }
    		
    	        int N = a.length;
    	        PivotGauss(a);
    	        if(status == 0){
    	            for (int i=0; i<N; i++) System.out.println("i="+i+",  "+a[i][N]);
    	        }
    	}catch (IOException e){
    		System.out.println("Error:"+e);
    	}
    }

    /**ピボット選択Gauss消去法による連立方程式の解析メソッド
     * status変数(エラーコード):  0:正常, 9:異常
     * 入力 : a[][]=係数行列および右辺ベクトル
     * 出力 : a[][N]                                    */
    void PivotGauss(double[][] a){
        double TINY = 1.0E-10;
        int N = a.length, status = 0;
        double pivot, multi, sum, max, aik;
        double tmp[][] = new double[N][N+1];

        //ここから入力してください。
		// 前進消去
		for (int k = 0; k < N - 1; k++) {
			// 並び替え
			max = a[k][k];
			int maxRowIndex = k;
			for (int l = k + 1; l < N - 1; l++) {
				if (Math.abs(max) < Math.abs(a[l][k])) {
					max = a[l][k];
					maxRowIndex = l;
				}
			}
			tmp[k] = a[maxRowIndex];
			a[maxRowIndex] = a[k];
			a[k] = tmp[k];

			double d = 1 / a[k][k];
			for (int i = k + 1; i < N; i++) {
				multi = a[i][k] * d;
				for (int j = 0; j < N + 1; j++) {
					a[i][j] = a[i][j] - multi * a[k][j];
				}
			}
		}
		// 後退代入
		for (int k = N - 1; k > 0; k--) {
			double d = 1 / a[k][k];
			for (int i = 0; i < k; i++) {
				multi = a[i][k] * d;
				for (int j = 0; j < N + 1; j++) {
					a[i][j] = a[i][j] - multi * a[k][j];
				}
			}
		}
		// Aを単位行列にする
		for (int i = 0; i < N; i++) {
			a[i][N] = a[i][N] / a[i][i];
			a[i][i] = 1;
			for (int j = 0; j < N + 1; j++) {
				// System.out.print(a[i][j] + " ");
			}
			System.out.print("\n");
		}
        //ここまで入力してください。
    }
}
