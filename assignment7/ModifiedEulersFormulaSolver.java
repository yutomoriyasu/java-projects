class ModifiedEulersFormulaSolver extends OrdinaryDifferentialSolver{
    private double k1; //修正Euler法で用いるk1

    //修正Euler法を解くメソッド solve()
    //OrdinaryDifferentialSolverで定義されている変数を使うこと
    //public void set() はOrdinaryDifferentialSolverのものが呼び出される
    public void solve(){
        //ここから記入してください
        int i = 0;
        x[0] = 0 + h;
        while (x[i] <= n) {
            double k1 = h * y[i];
            x[i+1] = x[i] + h;
            y[i+1] = y[i] + h * (y[i] + k1/2);
            i++;
        }
        
        //ここまで記入してください
    }
}