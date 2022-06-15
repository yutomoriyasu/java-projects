import java.io.*;
import java.util.*;

// 基本的にはこのファイルを編集する必要はありません。

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int couter = 0;
            System.out.print("Question > ");
            System.out.flush();
            int num = Integer.parseInt(br.readLine());

            System.out.print("x0 > ");
            System.out.flush();
            double x0 = Double.parseDouble(br.readLine());
            double x1 = 0;
            double x = 0;
            
            switch (num) {
            case 1:
                Question1 q1 = new Question1();
                x1 = 0;
	            x = q1.solve(x0, x1);
                break;
            case 2:
                Question2 q2 = new Question2();
                System.out.print("x1 > ");
                System.out.flush();
                x1 = Double.parseDouble(br.readLine());
	            x = q2.solve(x0, x1);
                break;
            case 3:
                Question3 q3 = new Question3();
                x1 = 0;
    	        x = q3.solve(x0, x1);
                break;
            case 4:
                Question4 q4 = new Question4();
                System.out.print("x1 > ");
                System.out.flush();
                x1 = Double.parseDouble(br.readLine());
	            x = q4.solve(x0, x1);
                break;
            case 5:
                Question5 q5 = new Question5();
                x1 = 0;
	            x = q5.solve(x0, x1);
                break;
            }
            System.out.println("root = " + x);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
