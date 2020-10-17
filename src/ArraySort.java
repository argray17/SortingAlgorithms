public class ArraySort extends Thread {
    int[] list;
    int[] sortedList;
    int n;

    public ArraySort(int[] unsortedList) {
        this.list = unsortedList;
        this.sortedList = list.clone();
        this.n = list.length;
    }
    public int[] getSortedList() {
        return this.sortedList;
    }
    public void resetList() {
        this.sortedList = list.clone();
    }
    private static void swap(int[] list, int i, int k) {
        int temp = list[i];
        list[i] = list[k];
        list[k] = temp;
    }
    public void bubbleSort() {
        boolean needNextPass = true;

        for (int i = 1; i < this.n && needNextPass; i++) {
            needNextPass = false;

            for (int k = 0; k < this.n - i; k++) {
                if (sortedList[k] < sortedList[k + 1]) {
                    swap(sortedList, k, k + 1);
                    needNextPass = true;
                }
            }
        }
    }
    public void insertionSort() {
        for (int i = 1; i < this.n; i++) {
            int currentElement = sortedList[i];
            int k;
            for (k = i - 1; k >= 0 && sortedList[k] < currentElement; k--) {
                sortedList[k + 1] = sortedList[k];
            }
            sortedList[k + 1] = currentElement;
        }
    }

    public void run() {
        mergeSortRecursive(this.sortedList, new int[this.n], 0, this.n - 1);
    }
    public void mergeSort() {
        int[] left = new int[this.n / 2];
        int[] right = new int[this.n - left.length];

        for(int i = 0; i < left.length; i++) {
            left[i] = sortedList[i];
        }

        for(int k = 0; k < right.length; k++) {
            right[k] = sortedList[k + left.length];
        }

        ArraySort sortLeft = new ArraySort(left);
        ArraySort sortRight= new ArraySort(right);

        sortLeft.start();
        sortRight.start();

        mergeFinal(sortLeft.getSortedList(), sortRight.getSortedList(), 0, n / 2, this.n - 1);
    }
    private void mergeSortRecursive(int[] sortedTemp, int[] temp, int left, int right) {
        int n = right - left + 1;
        int middle = left + n / 2;
        int i;

        if(n < 2) return;

        for(i = left; i < middle; i++) {
            temp[i] = sortedTemp[i];
        }

        mergeSortRecursive(temp, sortedTemp, left, middle - 1);
        mergeSortRecursive(sortedTemp, temp, middle, right);
        merge(sortedTemp, temp, left, middle, right);
    }
    private void merge(int[] sortedTemp, int[] temp, int left, int middle, int right) {
        int ri = left;
        int ti = left;
        int di = middle;

        while (ti < middle && di <= right) {
            if (sortedTemp[di] > temp[ti]) {
                sortedTemp[ri++] = sortedTemp[di++];
            } else {
                sortedTemp[ri++] = temp[ti++];
            }
        }
        while (ti < middle) {
            sortedTemp[ri++] = temp[ti++];
        }
    }
    private void mergeFinal(int[] sortedLeft, int[] sortedRight, int left, int middle, int right) {
        int[] temp = sortedList.clone();

        for(int i = 0; i < sortedLeft.length; i++) {
            this.sortedList[i] = sortedLeft[i];
        }

        for(int k = 0; k < sortedRight.length; k++) {
            this.sortedList[k + sortedLeft.length] = sortedRight[k];
        }

        mergeSortRecursive(temp, sortedList, left, middle - 1);
        mergeSortRecursive(sortedList, temp, middle, right);
        merge(sortedList, temp, left, middle, right);
    }
    public void quickSort() {
        quickSortRecursive(this.sortedList, 0, this.n - 1);
    }
    private void quickSortRecursive(int[] temp, int left, int right) {
        int pivotIndex;

        if (left < right) {
            pivotIndex = partition(temp, left, right);

            quickSortRecursive(temp, left, pivotIndex - 1);
            quickSortRecursive(temp, pivotIndex + 1, right);

        }
    }
    private int partition(int[] temp, int left, int right) {
        int pivot = temp[left];
        int leftSearch = left + 1;
        int rightSearch = right;

        while (leftSearch < rightSearch) {
            while (leftSearch <= rightSearch && temp[leftSearch] >= pivot) {
                leftSearch++;
            }
            while (leftSearch <= rightSearch && temp[rightSearch] < pivot) {
                rightSearch--;
            }
            if (rightSearch > leftSearch) {
                swap(temp, rightSearch, leftSearch);
            }
        }

        while (rightSearch > left && temp[rightSearch] <= pivot) {
            rightSearch--;
        }

        if (pivot < temp[rightSearch]) {
            temp[left] = temp[rightSearch];
            temp[rightSearch] = pivot;
            return rightSearch;
        } else {
            return left;
        }
    }
}