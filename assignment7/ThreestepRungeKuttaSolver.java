class ThreestepRungeKuttaSolver extends OrdinaryDifferentialSolver{
    private double k1; //3次のRunge-Kutta法で用いる k1
    private double k2; //同じく k2
    private double k3; //同じく k3

    //3次のRunge-Kutta法を解くメソッド solve()
    //OrdinaryDifferentialSolverで定義されている変数を使うこと
    //public void set() はOrdinaryDifferentialSolverのものが呼び出される
    public void solve(){
        //ここから記入してください
        int i = 0;
        x[0] = 0 + h;
        while (x[i] <= n) {
            double k1 = h * y[i];
            double k2 = h * (y[i] + k1/2);
            double k3 = h * (y[i] - k1 + 2 * k2);
            y[i+1] = y[i] + (k1 + 4 * k2 + k3) / 6;
            x[i+1] = x[i] + h;
            i++;
        }
        //ここまで記入してください
    }
}