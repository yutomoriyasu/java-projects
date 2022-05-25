package packages;

public class Queue {
	
	private int capacity;
	private int front;
	private int rear;
  private int size;
	private String[] dataSet;
	private String[] dataSetTemp;

	public Queue(int initSize) {
		capacity = initSize;
		front = 0;
		rear = 0;
    size = 0;
		dataSet = new String[capacity];		
	}

	public boolean isEmpty() {
		
		// ここにisEmptyの処理を書く
		return size == 0;
	}
	
	public int next(int a) {
		return (a+1) % capacity;
	}

	public void insert(String s) {
		
		// ここにinsertの処理を書く	
    if (size == capacity) {
			doubleCapacity();
    }
		if (isEmpty()) {
			dataSet[front] = s;
    } else {
			rear = next(rear);
			dataSet[rear] = s;	
		}
		size++;
	}

	public String remove() {
		
		// ここにremoveの処理を書く
		if (size == 0) {
			return ("");
    }
		String j = dataSet[front];
		dataSet[front] = null;
		front = next(front);
		size--;
		return (j);
	}

	public String peek() {
		
		// ここにpeekの処理を書く
		if (isEmpty()) {
      return "";
    } else {
      return dataSet[front];
    }
	}

	private void doubleCapacity() {
		
		// ここにdoubleCapacityの処理を書く
		System.out.println(
      "Capacity: " + Integer.toString(capacity) + " -> " + Integer.toString(capacity * 2)
    );
    // dataSetTemp に dataSet の中身を移す
    dataSetTemp = new String[capacity];
    for (int i = 0; i < dataSetTemp.length; i++) {
      if (front <= capacity) {
        dataSetTemp[i] = dataSet[front + i];
      } else {
        dataSetTemp[i] = dataSet[rear + i - capacity];
      }
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