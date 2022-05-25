package packages;

import java.util.Arrays;

public class NQueen {
	
	private final int N;	// クイーンの数
	private int[] pos;		// 各行の置かれたクイーンの位置
	private Status[] col;	// クイーンが垂直方向に利いているかを示す配列
	private Status[] down;	// クイーンが右斜め下向きに利いているかを示す配列
	private Status[] up;	// クイーンが右斜め上向きに利いているかを示す配列
	private int count;		// 解の数
	
	private enum Status {
		FREE, //置ける
		NOT_FREE //置けない
	}

	// Nクイーン問題を解くためのオブジェクトを生成する
	public NQueen(int numberOfQueens) {
		// 配列を割り当てる
		//ここに追記してください
		
		// クイーンの位置と利き筋を初期化する
		//ここに追記してください
		
	}

	public boolean tryQueen(int a) {
		//行a以降の行に条件を満たすようにクイーンを置く		
		//左から右に向かって順番にクイーンが置けるかどうかを調べる
		//ここに追記してください		
		
	}

	// クイーンの位置を出力する
	public void print() {
		// 表示形式に沿って出力してください
		//ここに追記してください
		
	}

	public void tryQueenAll(int a) {
		//左から右に順番にクイーンが置けるかどうかを調べる
		//ここに追記してください
	}
	
	public int getcount() {
		return count;
	}

}