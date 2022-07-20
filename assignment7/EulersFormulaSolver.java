class EulersFormulaSolver extends OrdinaryDifferentialSolver{
    //Euler法の公式を用いて解くメソッド solve()
    //OrdinaryDifferentialSolverで定義されている変数を使うこと
    //public void set() はOrdinaryDifferentialSolverのものが呼び出される
    public void solve(){
        //ここから記入してください
        int i = 0;
        x[0] = 0 + h;
        while (x[i] <= n) {
            x[i+1] = x[i] + h;
            y[i+1] = y[i] + h * y[i];
            i++;
        }
        //ここまで記入してください
    }
}