public class Question3  {

    public double solve(double x0, double x1) {
        int max = 100; // 最大反復回数
        double oldx = x0, newx = x0, fdx = 0.0, fx;
        boolean flag = true; // trueのうちは反復、falseにしたら反復終了というように使ってもよい
        int iter = 0; // 反復回数を数えるのに使ってもよい

        /////////////// TO DO ////////////////
        // 
        // 100回計算しても収束しないとあきらめるようにしましょう
        // x0とx1の両方を入力できるようになっていますが、この問題はx0のみ使います
        // x0は、配布されたSolverMain.javaで読み込まれ、oldxに代入済みです
        // 
        // f(x0)とf'(x0)を求めます
        // oldx(xiのこと)と、f(x0)とf'(x0)を使って、newx(xi+1のこと)を求めます
        // xiとxi+1の差（絶対値）を見て解が求まっていたら終了
        // 求まっていないようならxi+2へと進むためにループする
        /////////////////////////////////////

        while (iter < 100) {
            System.out.println("Newton: i=" + iter + ", x=" + newx);
            oldx = newx;
            newx = oldx - fun(oldx) / diffFun(oldx);
            iter++;
            if (Math.abs(newx - oldx) <= Math.pow(10.0, -7.0)) {
                break;
            }
        }
        System.out.println("Newton: i=" + iter + ", x=" + newx);
        return newx;

        // 初期値としてx0とx1を与えられたときに解を求めて返す
        // System.out.println("初期値としてx0(とx1)を与えられたときに解を求めて返す");
        // return -1;
        
    }

    public double fun(double x) {
        /////////////// TO DO ////////////////
        // xにおける関数f(x)の値を返す関数を作成する
        /////////////////////////////////////
        // xを与えられたときに対応する値を返す
        // System.out.println("xを与えられたときに対応する値を返す");
        return Math.exp(- x * x) - Math.log10(x);
    }

    public double diffFun(double x) {
        /////////////// TO DO ////////////////
        // xにおける関数f(x)の微分を返す関数を作成する
        /////////////////////////////////////
        // System.out.println("xにおける微分関数の値を返す");
        return - 2 * x * Math.exp(- x * x) - 1 / (x / Math.log(10));
    }

    public double diffFun(double x0, double x1) {
        // x0とx1の2点を使って微分関数の値を返す
        // 微分関数が求まらない場合に有効
        // System.out.println("x0,x1における微分関数の値を返す");
        return (fun(x1) - fun(x0)) / (x1 - x0);
    }

}
