import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import packages.InsertionSort;

public class InsertionSortMain {

	static final String INPUT_FILE_NAME = "data2.txt";
	static final String OUTPUT_FILE_NAME = "03-220995.txt";

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

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] data = readInt(INPUT_FILE_NAME);
      InsertionSort is = new InsertionSort();
      data = is.sort(data);
      try {
        FileWriter fw = new FileWriter(OUTPUT_FILE_NAME);
        fw.write("-- Insertion Sort --" + "\n");
        for (int i = 0; i < data.length; i++) {
          fw.write("[" + i + "]: " + data[i] + "\n");
        }
        fw.write(
          "# of comparison: " + is.getComparisonNum() + "\n"
        );
        fw.write(
          "# of exchange: " + is.getExchangeNum() + "\n"
        );
        fw.write(is.getSortProcess());
        fw.close();
        System.out.println("Output completed");
      } catch (IOException e) {
        System.out.println(e);
      }
	}

}