package packages;

public class QuickSort {

  public static int[] sort(int[] data, int left, int right) {
    quickSort(data, left, right);
    return data;
	}

  private static void quickSort(int[] data, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivotIndex = (left + right) / 2;
    int pivot = data[pivotIndex];
    int l = left;
    int r = right;
    while(l <= r) {
      while(data[l] < pivot) {
        l++;
      }
      while(data[r] > pivot) {
        r--;
      }
      if (l <= r) {
        int tmp = data[l];
        data[l] = data[r];
        data[r] = tmp;
        l++;
        r--;
      }
    }
    quickSort(data, left, r);
    quickSort(data, l, right);
  }
}