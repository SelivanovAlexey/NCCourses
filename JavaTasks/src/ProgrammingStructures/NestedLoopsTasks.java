package ProgrammingStructures;

public class NestedLoopsTasks {
    public static void main(String[] args) {
        rectangleOfHashes();
        System.out.println('\n');
        triangleOfHashes1();
        System.out.println('\n');
        triangleOfHashes2();
        System.out.println('\n');
        zOfHashes();
        System.out.println('\n');
        hourglassOfHashes();
        System.out.println('\n');
    }

    public static void rectangleOfHashes() {
        int size = 5;
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                System.out.print('#');
            }
            System.out.print('\n');
        }
    }

    public static void triangleOfHashes1() {
        int size = 8;
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print('#');
            }
            System.out.print('\n');
        }
    }

    public static void triangleOfHashes2() {
        int size = 8;
        for (int row = size; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print('#');
            }
            System.out.print('\n');
        }
    }

    public static void zOfHashes(){
        int size = 7;
        for (int row = 1; row <= 7; row++) {
            System.out.print('#');
        }
        System.out.print('\n');
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= size; col++) {
                if (size - col == row) System.out.print('#');
                else System.out.print(' ');
            }
            System.out.print('\n');
        }
        for (int row = 1; row <= 7; row++) {
            System.out.print('#');
        }
    }




    public static void hourglassOfHashes() {
        int size = 7;
        for (int row = 1; row <= 7; row++) {
            System.out.print('#');
        }
        System.out.print('\n');
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= size; col++) {
                if (col == row + 1 || size - col == row) System.out.print('#');
                else System.out.print(' ');
            }
            System.out.print('\n');
        }
        for (int row = 1; row <= 7; row++) {
            System.out.print('#');
        }
    }


}
