import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import packages.Slist;

public class SlistMain {

	public static void main(String[] args) {
		
		Slist list = new Slist();
		
		if(args.length==0){
            // 【1】 ファイル名入力なし
            Slist fruitsList = new Slist();
            fruitsList.insert ( "Apple" ); // 一回ずつ入力
            fruitsList.insert ( "Banana" );
            fruitsList.insert ( "Orange" );
            fruitsList.sort ();
            fruitsList.printNodes(0);
            fruitsList.insert ( "Banana" ); // データを重複させる。
            fruitsList.insert ( "Banana" );
            fruitsList.insert ( "Apple" );
            fruitsList.sort ();
            fruitsList.printNodes(0);
            fruitsList.remove ( "Banana" ); // remove のチェック
            fruitsList.remove ( "Orange" );
            fruitsList.sort ();
            fruitsList.printNodes(0);
            for(int i=0;i<3;i++) { // 過剰に remove する
                fruitsList.remove ( "Banana" );
                fruitsList.remove ( "Orange" );
                fruitsList.remove ( "Apple" );
            }
            fruitsList.sort ();
            fruitsList.printNodes(0);
        }else{
            // 【2】 「java SlistMain alice.txt」と実行すると
            // alice.txtファイル内に出てくる単語を読み取り
            // リストに挿入し、ソートしてプリント
            // 文字の読み込み方法は、以前の課題のコードを参考にしてください
            try {
                FileReader fr = new FileReader(args[0]);
                StreamTokenizer st = new StreamTokenizer(fr);
                Slist wordslist = new Slist();
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    if (st.ttype == StreamTokenizer.TT_WORD) {
                        String word = String.valueOf(st.sval);
                        wordslist.insert(word);
                    }
                }
                wordslist.sort();
                wordslist.printNodes(5);
                fr.close();
			} catch (FileNotFoundException e) { // 例外処理
				System.out.println ("this file was not found.");
			} catch (IOException e) {
				System.out.println ("Error: " + e);
			}
        }

	}

}