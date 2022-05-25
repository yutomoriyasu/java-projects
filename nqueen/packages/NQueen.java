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
		N = numberOfQueens;
    count = 0;
    pos = new int[N];
    col = new Status[2 * N - 1];
    down = new Status[2 * N - 1];
    up = new Status[2 * N - 1];
		// クイーンの位置と利き筋を初期化する
		//ここに追記してください
    Arrays.fill(pos, -1);
    Arrays.fill(col, Status.FREE);
    Arrays.fill(down, Status.FREE);
    Arrays.fill(up, Status.FREE);
	}

  public boolean tryQueen(int a) {
    //行a以降の行に条件を満たすようにクイーンを置く		
    //左から右に向かって順番にクイーンが置けるかどうかを調べる
    //ここに追記してください
    for (int i = pos[a] + 1; i < N; i++) {
      if (pos[a] != -1) {
        continue;
      }
      if (col[i] == Status.NOT_FREE) {
        continue;
      }
      if (down[N - a + i - 1] == Status.NOT_FREE) {
        continue;
      }
      if (up[a + i] == Status.NOT_FREE) {
        continue;
      }
      pos[a] = i;
      col[i] = Status.NOT_FREE;
      down[N - a + i - 1] = Status.NOT_FREE;
      up[a + i] = Status.NOT_FREE;
      if (a == N - 1) {
        return true;
      }
      if (tryQueen(a + 1)) {
        return true;
      } else {
        col[pos[a]] = Status.FREE;
        down[N - a + pos[a] - 1] = Status.FREE;
        up[a + pos[a]] = Status.FREE;
        pos[a] = -1;
      }
    }
    return false;
  }

	// クイーンの位置を出力する
	public void print() {
		// 表示形式に沿って出力してください
		//ここに追記してください
		for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (pos[i] == j) {
          System.out.print('Q');
        } else {
          System.out.print('.');
        }
      }
      System.out.println();
    }
	}

	public void tryQueenAll(int a) {
		//左から右に順番にクイーンが置けるかどうかを調べる
		//ここに追記してください
	}
	
	public int getcount() {
		return count;
	}

}