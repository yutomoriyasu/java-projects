import packages.NQueen;

public class NQueenMain {

	public static void abort(String msg) {
        // messageを表示して，プログラムを終了させる
		System.err.println(msg);
        System.exit(1);
    }

	 public static void main(String[] args) {
	 	if (args.length != 1){
	 		abort("Invalid length of args");
	 		return;
	 	}
	 	int n = 0;
	 	try {
	 		n = Integer.parseInt(args[0]);
	 	} catch(NumberFormatException e) {
	 		abort("Invalid # of queens: " + args[0]);
	    }
	 	if (n<=0) {
	 		abort("Invalid # of queens: " + args[0]);
	 	}		
	 	
	 	NQueen nq = new NQueen(n);

		//Nクイーンのはじめの解を表示する
		
		 if (nq.tryQueen(0)) { nq.print(); } 
		 else {
		 System.out.println("No solution."); }
				 
	 	
	 	//Nクイーンの全ての解を表示する
		//追記してください
		 if (nq.tryQueenAll(0)) { System.out.println(nq.getcount()); } 
		 else {
		 System.out.println("No solution."); }

	}

}