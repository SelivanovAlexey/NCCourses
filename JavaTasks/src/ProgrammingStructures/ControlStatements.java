package ProgrammingStructures;

public class ControlStatements {
    public static void main(String[] args) {
        System.out.println("Task A (enum checking)");
        enumCheck();
        System.out.println("\nTask B (array checking)");
        arrayCheck();
    }

    public enum Week {
        Monday, Tuesday, Wednesday, Thursday, Friday
    }

    public static void enumCheck() {


        String day = "Monday";
        long start = System.nanoTime();
        switch (day) {
            case "Monday":
                System.out.println("Yes");
                break;
            case "Tuesday":
                System.out.println("Yes");
                break;
            case "Wednesday":
                System.out.println("Yes");
                break;
            case "Thursday":
                System.out.println("Yes");
                break;
            case "Friday":
                System.out.println("Yes");
                break;
        }
        long estimated = System.nanoTime() - start;
        System.out.println("Time of switch-case: " + estimated);


        start = System.nanoTime();
        if (day == "Monday") {
            System.out.println("Yess");
        } else if (day == "Tuesday") {
            System.out.println("Yess");
        } else if (day == "Wednesday") {
            System.out.println("Yess");
        } else if (day == "Tuesday") {
            System.out.println("Yess");
        } else if (day == "Friday") {
            System.out.println("Yess");
        }
        estimated = System.nanoTime() - start;
        System.out.println("Time of else-if: " + estimated);
    }


    public static void arrayCheck() {
        int arr[] = new int[50];
        int arrCount[] = new int[11];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 11);
        }

        long start = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arrCount[0]++;
                    break;
                case 1:
                    arrCount[1]++;
                    break;
                case 2:
                    arrCount[2]++;
                    break;
                case 3:
                    arrCount[3]++;
                    break;
                case 4:
                    arrCount[4]++;
                    break;
                case 5:
                    arrCount[5]++;
                    break;
                case 6:
                    arrCount[6]++;
                    break;
                case 7:
                    arrCount[7]++;
                    break;
                case 8:
                    arrCount[8]++;
                    break;
                case 9:
                    arrCount[9]++;
                    break;
                case 10:
                    arrCount[10]++;
                    break;
            }
        }
        long estimated = System.nanoTime() - start;
        System.out.println("Time of switch-case: " + estimated);

        for (int i : arrCount) {
            i = 0;
        }


        start = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arrCount[0]++;
            } else if (arr[i] == 1) {
                arrCount[1]++;
            } else if (arr[i] == 2) {
                arrCount[2]++;
            } else if (arr[i] == 3) {
                arrCount[3]++;
            } else if (arr[i] == 4) {
                arrCount[4]++;
            } else if (arr[i] == 5) {
                arrCount[5]++;
            } else if (arr[i] == 6) {
                arrCount[6]++;
            } else if (arr[i] == 7) {
                arrCount[7]++;
            } else if (arr[i] == 8) {
                arrCount[8]++;
            } else if (arr[i] == 9) {
                arrCount[9]++;
            } else if (arr[i] == 10) {
                arrCount[10]++;
            }
        }
        estimated = System.nanoTime() - start;
        System.out.println("Time of else-if: " + estimated);

        for (int i = 0;i<arrCount.length;i++){
            System.out.println("Element "+ i + " repeats " + arrCount[i] + " times");
        }
    }
}
