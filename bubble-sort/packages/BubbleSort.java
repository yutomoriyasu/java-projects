package packages;

public class BubbleSort {
	private int comparisonNum = 0; // # of comparison
	private int exchangeNum = 0; // # of exchange
	
	public int getComparisonNum() {
		return comparisonNum;
	}
	
	public int getExchangeNum() {
		return exchangeNum;
	}

	public int[] sort(int[] data) {
		comparisonNum = 0;
		exchangeNum = 0;
    int length = data.length;
		// 配列の中身を順番に比較します
		for (int i = 0; i < length - 1; i++) {
			for (int j = length - 1; j > i; j--) {
				// ここに処理内容を追記してください//
        comparisonNum++;
				if (data[j - 1] > data[j]) {
          int tmp = data[j - 1];
          data[j - 1] = data[j];
          data[j] = tmp;
          exchangeNum++;
        }
			}
		}
		return data;
	}
}