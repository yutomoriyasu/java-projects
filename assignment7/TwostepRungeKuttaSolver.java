class TwostepRungeKuttaSolver extends OrdinaryDifferentialSolver{
    private double k1; //2次のRunge-Kutta法で用いるk1
    private double k2; //2次のRunge-Kutta法で用いるk2

    //2次のRunge-Kutta法を解くメソッド solve()
    //OrdinaryDifferentialSolverで定義されている変数を使うこと
    //public void set() はOrdinaryDifferentialSolverのものが呼び出される
    public void solve(){
        //ここから記入してください
        int i = 0;
        x[0] = 0 + h;
        while (x[i] <= n) {
            double k1 = h * y[i];
            double k2 = h * (y[i] + k1);
            y[i+1] = y[i] + (k1 + k2) / 2;
            x[i+1] = x[i] + h;
            i++;
        }
        //ここまで記入してください
    }    
}
