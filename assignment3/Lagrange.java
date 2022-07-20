import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Lagrange{
	static double LagrangeCalc(double[] x, double[] f, double xint){
		 // x[]: x座標 f[]: 関数値 xint: f(x)を求めたい補間点のx
		 // xintに3.5を指定したら、f(3.5)の近似値が返される
    int n = x.length;
    double fint = 0.0;
    for (int i=0; i<n; i++) {
      double li = 1;
      for (int j=0; j<n; j++) {
        if (x[j] == x[i]) continue;
        li = li * (xint - x[j]) / (x[i] - x[j]);
      }
      fint = fint + li * f[i];
    }
    return fint;
	}

	public static void main(String agrs[]){
		try{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.print("input the number of known points:");
			System.out.flush();
			int n=Integer.parseInt(br.readLine());
            int flag=0;
            while(n<2&&flag==0){
                System.out.print("unexpected input, please input again(input -1 to exit): ");
                System.out.flush();
                n=Integer.parseInt(br.readLine());
                if(n==-1){
                    flag=1;
                }
            }
            
            if(flag==0){
			double x[]=new double[n];
			double f[]=new double[n];
			
			for(int i=0; i<n; i++){
				System.out.print("input No."+i+" x:");
				System.out.flush();
				x[i]=Double.parseDouble(br.readLine());
				System.out.print("input No."+i+" f(x):");
				System.out.flush();
				f[i]=Double.parseDouble(br.readLine());
			}
			
			// DecimalFormatを使います
			DecimalFormat dfxint = new DecimalFormat("0.0");
			DecimalFormat dfans = new DecimalFormat("0.0000");

			for (double xint = 1.0; xint < 5; xint += 0.1) {
				double ans = LagrangeCalc(x, f, xint);
				System.out.println("(" + dfxint.format(xint) + "," + dfans.format(ans) + ")");
			}

            }
		}catch (IOException e){
			System.out.println("Error:"+e);
		}
	}
}
