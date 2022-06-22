import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ErrorEstimate {
	public static void main(String args[]){
		try{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.print("input points' interval h:");
			System.out.flush();
			double h=Double.parseDouble(br.readLine());
			double x0=-h;


			DecimalFormat dfans=new DecimalFormat("0.0000000000");
			DecimalFormat dfx=new DecimalFormat("0.0000");

			double ans=MaxErrorEstimate(h);
			double ansx=MaxErrorEstimateX(h);
			System.out.println("The absolute value of maximum error is: "+dfans.format(ans)+" at x="+dfans.format(ansx));

			for(double x=x0; x<h+0.00000000000001; x+=h/10){
				ans=ErrorEstimateCalc(h,x);
				System.out.println("error("+dfx.format(x)+")="+dfans.format(ans));
			}


		}catch (IOException e){
			System.out.println("Error:"+e);
		}
	}

	static double ErrorEstimateCalc(double h,double x){
		/*

		ここを編集してください

		hとxから誤差を計算する式を（手計算で）求めてプログラム化する。

		*/
	}

	static double MaxErrorEstimate(double h){
		/*

		ここを編集してください

		hが与えられた際の最大誤差を計算する式を（手計算で）求めてプログラム化する。

		*/
	}

	static double MaxErrorEstimateX(double h){
		/*

		ここを編集してください

		最大誤差を取るときのxの値を求める式を（手計算で）求めてプログラム化する。

		*/
	}

}
