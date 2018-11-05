package ProgrammingStructures;

public class Factorial {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("Cycling factorial: "+cyclingFactorial(30));
        long estimated = System.nanoTime() - start;
        System.out.println("Time: "+estimated);

        start = System.nanoTime();
        System.out.println("\nRecursive factorial: "+recursiveFactorial(30));
        estimated = System.nanoTime() - start;
        System.out.println("Time: "+estimated);
    }

    public static int cyclingFactorial(int val) {
        int result = 1;
        while (val != 0) {
            result *= val;
            val--;
        }
        return result;
    }

    public static int recursiveFactorial(int val) {
        return (val == 1 || val == 0) ? 1 : val*recursiveFactorial(val-1);
    }
}
