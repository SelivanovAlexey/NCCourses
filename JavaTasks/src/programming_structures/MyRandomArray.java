package programming_structures;

import java.util.Arrays;

public class MyRandomArray {

    private int size;
    private int[] array;
    private long time;

    public MyRandomArray(int size) {
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*100);
        }
    }

    public void BubbleSort() {
        time = 0;
        long start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        this.time = System.nanoTime() - start;

    }

    public void SelectionSort() {
        time = 0;
        long start = System.nanoTime();
        for (int i = 0; i < array.length - 1; i++) {
            int least = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[least]) {
                    least = j;
                }
            }
            int tmp = array[i];
            array[i] = array[least];
            array[least] = tmp;
        }
        this.time = System.nanoTime() - start;
    }

    public int[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return  Arrays.toString(array);
    }

    public long getTime() {
        return time;
    }
}

