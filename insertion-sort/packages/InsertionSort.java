package packages;
import java.util.Arrays;

public class InsertionSort {

	private int comparisonNum = 0; // # of comparison
  private int exchangeNum = 0; // # of exchange
  private String sortProcess = "Sort process written below\n";

  public int getComparisonNum() {
    return comparisonNum;
  }

  public int getExchangeNum() {
    return exchangeNum;
  }

  public String getSortProcess() {
    return sortProcess;
  }

  public int[] sort(int[] data) {
    sortProcess += Arrays.toString(data) + "\n";
    for(int i = 0; i < data.length - 1; i++){
      int tmp = data[i+1];
      for (int j = i + 1; j > 0; j --) {
        comparisonNum++;
        if (tmp < data[j-1]) {
          data[j] = data[j-1];
          data[j-1] = tmp;
          exchangeNum++;
          sortProcess += Arrays.toString(data) + "\n";
        }
      }
    }
    return data;
  }
}