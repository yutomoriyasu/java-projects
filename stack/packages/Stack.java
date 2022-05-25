package packages;

import java.util.Arrays;

public class Stack {
	private static final int DEFAULT_INIT_SIZE = 16;

	private int capacity;
	private int size;
	private String[] dataSet;
	private String[] dataSetTemp;

	public Stack() {
		this(DEFAULT_INIT_SIZE); //thisを使って別のコンストラクタを呼び出す
	}

	public Stack(int initSize) {
		capacity = initSize; //スタック用配列のサイズ
		size = 0; //使用した配列の数
		dataSet = new String[capacity]; //スタックのデータ項目
	}

	public boolean isEmpty() {
		
		//isEmptyの処理をここに書く
    return size == 0;
	}

	public void push(String s) {
		
		//pushの処理をここに書く
		if (size == capacity) {
      // dataSetTemp に dataSet の中身を移す
      dataSetTemp = new String[capacity];
      for (int i = 0; i < dataSetTemp.length; i++) {
        dataSetTemp[i] = dataSet[i];
      }
      // capacity を１増やす
      capacity++;
      // dataSet に dataSetTemp の中身を移す
      dataSet = new String[capacity+1];
      for (int i = 0; i < dataSetTemp.length; i++) {
        dataSet[i] = dataSetTemp[i];
      }
      size++;
      dataSet[size-1] = s;
    } else {
      size++;
      dataSet[size-1] = s;
    }
	}

	public String pop() {
		
		//popの処理をここに書く
		if (isEmpty()) {
      return "";
    } else {
      String topValue = dataSet[size - 1];
      dataSet[size - 1] = "";
      size--;
      return topValue;
    }
	}

	public String peek() {
		
		//peakの処理をここに書く
		if (isEmpty()) {
      return "";
    } else {
      String topValue = dataSet[size - 1];
      return topValue;
    }
	}

	private void doubleCapacity() {
							
		//doubleCapacityの処理をここに書き込む		
		System.out.println(
      "Capacity: " + Integer.toString(capacity) + " -> " + Integer.toString(capacity * 2)
    );
    // dataSetTemp に dataSet の中身を移す
    dataSetTemp = new String[capacity];
    for (int i = 0; i < dataSetTemp.length; i++) {
      dataSetTemp[i] = dataSet[i];
    }
    // capacity を 2 倍にする
    capacity = capacity * 2;
    // dataSet に dataSetTemp の中身を移す
    dataSet = new String[capacity * 2];
    for (int i = 0; i < dataSetTemp.length; i++) {
      dataSet[i] = dataSetTemp[i];
    }
	}
}