import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import packages.BubbleSort;

public class BubbleSortMain {
	
	static final String INPUT_FILE_NAME = "data.txt";
	
	//static final修飾子を指定すると、そのクラスで固有の値となる（変数の値が変更できなくなる）

	//ファイルの行数を数える
	public static int countLine(String fileName) {
		int count = 0;
		try {
			FileReader fr = new FileReader(fileName);
			StreamTokenizer st = new StreamTokenizer(fr);
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				if (st.ttype == StreamTokenizer.TT_NUMBER) {
					count++;
				}
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("text file \"" + fileName + "\" was not found.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		return count;
	}
	
	//ファイル内の数字を配列に格納する
	public static int[] readInt(String fileName){
		int count = 0;
		int[] data = new int[countLine(fileName)];
		try {
			FileReader fr = new FileReader(fileName);
			StreamTokenizer st = new StreamTokenizer(fr);
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				if (st.ttype == StreamTokenizer.TT_NUMBER) {
					data[count] = (int)st.nval;
					count++;
					}
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("text file \"" + fileName + "\" was not found.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		return data;
	}

	//Main
	public static void main(String[] args) {
		int[] data = readInt(INPUT_FILE_NAME);
		BubbleSort bs = new BubbleSort();
		data = bs.sort(data);
		System.out.println("-- Bubble Sort --");
		for (int i = 0; i < data.length; i++) {
			System.out.println("[" + i + "]: " + data[i]);
		}
		System.out.println("# of comparison: " + bs.getComparisonNum());
		System.out.println("# of exchange: " + bs.getExchangeNum());
	}

}