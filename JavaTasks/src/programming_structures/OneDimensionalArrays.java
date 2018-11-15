package programming_structures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OneDimensionalArrays {

    public static void main(String[] args) {
        System.out.println("Task A");
        sortOdd();
        System.out.println("\nTask B");
        randomArray();
        System.out.println("\nTask C");
        replaceOdd();
        System.out.println("\nTask D");
        minMax();
        System.out.println("\nTask E");
        average();
        System.out.println("\nTask F");
        howMany();
    }


    // a. Создать массив нечётных чисел от 1 до 99 и вывести их в порядке возрастания и убывания
    public static void sortOdd() {
        int array[] = new int[50];

        for (int i = 1, j = 0; i < 100; i += 2, j++) {
            array[j] = i;
        }

        System.out.println(Arrays.toString(array));

        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        System.out.println(Arrays.toString(array));
    }


    // b. Создать массив из 20 случайных чисел лежащих в отрезке [0;10]. Вывести массив на экран.
    public static void randomArray() {
        int arr[] = new int[20];
        int evenCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 11);
        }
        for (int el : arr) {
            evenCounter += (el % 2 == 0) ? 1 : 0;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Even elements: " + evenCounter);
        System.out.println("Odd elements: " + (20 - evenCounter));
    }


    // c. Создайте массив из 10 случайных целых чисел на  отрезке [1;100].
    // Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
    // Выведите новый результат на экран.
    public static void replaceOdd() {
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println("Source array: " + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = 0;
        }
        System.out.println("Obtained array: " + Arrays.toString(arr));
    }


    // d. Создайте массив из 15 случайных целых чисел из отрезка [-50;50].
    // Найдите максимальный и минимальный элемент массива.
    // Выведите их значения на экран и также индекс последнего вхождения элемента в массив.
    public static void minMax() {
        int arr[] = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101 - 50);
        }
        int max = arr[0], min = arr[0];
        int maxIndex = 0, minIndex = 0;
        System.out.println("Source array: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                maxIndex = i;
            } else if (arr[i] <= min) {
                min = arr[i];
                minIndex = i;
            }
        }
        System.out.println("Max element: " + max + " ,index: " + maxIndex);
        System.out.println("Min element: " + min + " ,index: " + minIndex);
    }


    // e. Создайте два  массива из 10 случайных целых чисел в отрезке [0;10].
    // Выведите массивы.
    // Вычислите среднее арифметическое элементов каждого массива и сообщите,
    // для какого из массивов это значение оказалось больше (либо сообщите, что они равны).
    public static void average() {
        int arr[] = new int[10];
        int arr2[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 11);
            arr2[i] = (int) (Math.random() * 11);
        }
        System.out.println("First array: " + Arrays.toString(arr));
        System.out.println("Second array: " + Arrays.toString(arr2));
        double sum = 0, sum2 = 0;
        for (double x : arr) {
            sum += x;
        }
        for (double x : arr2) {
            sum2 += x;
        }
        System.out.println("Average of first array: " + sum / arr.length);
        System.out.println("Average of second array: " + sum2 / arr2.length);
        if (sum / arr.length > sum2 / arr2.length) System.out.println("Average is more for first array");
        else if (sum / arr.length < sum2 / arr2.length) System.out.println("Average is more for second array");
        else System.out.println("Average is equals");
    }


    // f. Создайте массив из 20 случайных целых чисел в отрезке [-1;1]
    // Определите какой элемент встречается в массиве чаще всего и выведите его на экран.
    // Также если несколько элементов встречаются одинаковое количество раз, необходимо их вывести на экран.
    public static void howMany() {
        int arr[] = new int [20];
        Map<Integer, Integer> frequency = new HashMap<>(3);
        for (int i = 0; i < arr.length; i++) {                          // Заполнение массива случайными числами
            arr[i] = new Random().nextInt(3)-1;
        }
        for(int i:arr) {
            if (frequency.containsKey(i)) frequency.put(i,frequency.get(i)+1);      // Заполнение хэш-таблицы, хранящей
            else frequency.put(i,1);                                                // количество повторений элемента
        }
        System.out.println("Source array: " + Arrays.toString(arr));
        System.out.println("Most frequent value: ");

        Integer max = frequency.get(0);

        for(Map.Entry<Integer,Integer> entry :frequency.entrySet()) {                // поиск максимального значения
            if (entry.getValue() > max) max = entry.getValue();
        }

        for(Integer key:frequency.keySet()){
            if (max.equals(frequency.get(key))) System.out.println(key);              // печать тех ключей,
                                                                                        // чьи значения максимальны
        }




    }


}
