import java.io.FileReader;
import java.io.StreamTokenizer;
import java.io.FileNotFoundException;
import java.io.IOException;

class WordReading {
public static void main(String[] args) {
// TODO 自動生成されたメソッド・スタブ
		try { // ファイル入出力の部分は，try .. catch で囲みます
			// ファイルをオープンするときは，FileReader を使います
			FileReader fr = new FileReader("word.txt");
			// ファイルの中身を連続した文字列として認識する時はStreamTokenizer を使います．
			// 区切りは，空白や改行やTAB です．
			StreamTokenizer st = new StreamTokenizer(fr);
			// StreamTokenizer は，最初は先頭をさしています．nextToken を呼ぶごとに次の文字列を
			//取り出します．次がなくなったときは，TT_EOF (end of file : ファイル終了)を返します． 
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				// 現在の文字列のタイプを返します．文字列ならTT_WORD,
				// 数字なら TT_NUMBER を返します．
				if (st.ttype == StreamTokenizer.TT_WORD) {
				// 文字列のときは sval, 数値 (double) のときは，nval とします．
				System.out.println(st.sval);
				}
			}
			// ファイルを閉じます．
			fr.close();
			} catch (FileNotFoundException e) { // 例外処理
				System.out.println ("this file was not found.");
			} catch (IOException e) {
				System.out.println ("Error: " + e);
			}
	}
}
