package ProgrammingStructures;

import java.util.Arrays;

public class Sorts {
    public static void main(String[] args) {

        MyRandomArray arr1 = new MyRandomArray(15);
        MyRandomArray arr2 = new MyRandomArray(15);
        MyRandomArray arr3 = new MyRandomArray(15);


        System.out.println("Сортировка пузырьком\nИсходный массив: " +arr1);
        arr1.BubbleSort();
        System.out.println("Отсортированный массив: "+arr1);
        System.out.println("Время: "+arr1.getTime());


        System.out.println("\nСортировка выбором\nИсходный массив: " +arr2);
        arr2.SelectionSort();
        System.out.println("Отсортированный массив: "+arr2);
        System.out.println("Время: "+arr2.getTime());



        System.out.println("\nСортировка методом Arrays.sort()\nИсходный массив: " +arr3);
        int [] arr = arr3.getArray();
        long start = System.nanoTime();
        Arrays.sort(arr);
        long estimated = System.nanoTime() - start;
        System.out.println("Отсортированный массив: "+arr3);
        System.out.println("Время: "+estimated);
    }

}
