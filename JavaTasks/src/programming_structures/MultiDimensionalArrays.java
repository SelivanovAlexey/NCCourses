package programming_structures;

public class MultiDimensionalArrays {
    public static void main(String[] args) {
        System.out.println("Task A");
        sumAndMulDiag();
        System.out.println("\nTask B");
        eachMaxMin();
        System.out.println("\nTask C");
        maxAbsRowIndex();
        System.out.println("\nTask D");
        rowDescSort();
    }


    // a. Создать двумерный массив размером 8 на 8. Заполнить его случайными числами в диапазоне [1;99]
    // Вычислить и вывести на экран сумму и произведение элементов главной и побочной диагонали
    public static void sumAndMulDiag() {
        int size = 8;
        int arr[][] = new int[size][size];
        int sumMain = 0, sumSide = 0;
        long mulMain = 1, mulSide = 1;
        System.out.println("Source matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = (int) (Math.random() * 99 + 1);
                System.out.print(arr[i][j] + "\t");
                if (i == j) {
                    sumMain += arr[i][j];
                    mulMain *= arr[i][j];
                }
                if (i == arr.length - j) {
                    sumSide += arr[i][j];
                    mulSide *= arr[i][j];
                }
            }
            System.out.print("\n");
        }
        System.out.println("Sum of main diagonal: " + sumMain + ", multiply of main diagonal: " + mulMain);
        System.out.println("Sum of side diagonal: " + sumSide + ", multiply of side diagonal: " + mulSide);
    }


    // b. Создать двумерный массив из 8 строк и 5 столбцов.
    // Заполнить его случайными числами в отрезке [-99;99]. Вывести массив на экран.
    // Вывести на экран значение и индексы максимального (по всем строкам и столбцам) элемента в массиве.
    public static void eachMaxMin() {
        int arr[][] = new int[8][5];
        int max = -99, min = 99;
        for (int i = 0; i < 8; i++) {                                   // Заполнение, вывод и
            for (int j = 0; j < 5; j++) {                               // поиск максимального и минимального значений
                arr[i][j] = (int) (Math.random() * 199 - 99);           // в каждой строке
                System.out.print(arr[i][j] + "\t");
                if (arr[i][j] > max) max = arr[i][j];
                if (arr[i][j] < min) min = arr[i][j];
            }
            System.out.print(" | Max: " + max + ", min: " + min);
            max = -99;
            min = 99;
            System.out.print("\n");
        }
        System.out.println("____________________\n");

        for (int i = 0; i < 5; i++) {                                     // Поиск максимального в каждом столбце
            for (int j = 0; j < 8; j++) {
                if (arr[j][i] > max) max = arr[j][i];
            }
            System.out.print(max + "\t");
            max = -99;
        }
        System.out.println(" | Max");

        for (int i = 0; i < 5; i++) {                                      // Поиск минимального в каждом столбце
            for (int j = 0; j < 8; j++) {
                if (arr[j][i] < min) min = arr[j][i];
            }
            System.out.print(min + "\t");
            min = 99;
        }
        System.out.println(" | Min");
    }


    // c. Создать двумерный массив из 8 строк и 5 столбцов из случайных целых чисел в отрезке [-10;10].
    // Вывести массив на экран.
    // Определить и вывести  на экран индекс строки с наибольшим по модулю произведением элементов.
    public static void maxAbsRowIndex() {
        int arr[][] = new int[8][5];
        int mul = 1, maxMul = 1, indexOfMaxMul = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = (int) (Math.random() * 21 - 10);
                System.out.print(arr[i][j] + "\t");
                mul *= Math.abs(arr[i][j]);
            }
            System.out.print(" " + mul);
            System.out.println();
            if (mul >= maxMul) {
                maxMul = mul;
                System.out.print("");
                indexOfMaxMul = i;
            }
            mul = 1;
        }
        System.out.println("Index of row with maximum absolute multiply: " + indexOfMaxMul);
    }


    // d. Создать двумерный массив из 10 строк и 7 столбцов из целых чисел в отрезке [0;100].
    // Вывести массив на экран.
    // Отсортировать каждую строку в порядке убывания. Вывести преобразованный массив на экран.
    public static void rowDescSort() {
        int arr[][] = new int[10][7];
        System.out.println("Source matrix:");                           // Заполнение
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = (int) (Math.random() * 101);
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < 8; i++) {                                   // Сортировка
            for (int m = 0; m < 5; m++) {
                for (int n = 0; n < 4; n++) {
                    if (arr[i][n] < arr[i][n + 1]) {
                        int tmp = arr[i][n];
                        arr[i][n] = arr[i][n + 1];
                        arr[i][n + 1] = tmp;
                    }
                }
            }
        }

        System.out.println("\nSorted matrix:");                          // Вывод
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

}