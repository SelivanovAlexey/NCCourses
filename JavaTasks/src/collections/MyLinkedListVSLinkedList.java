package collections;


import java.util.LinkedList;
import java.util.List;

public class MyLinkedListVSLinkedList {
    public static void main(String[] args) {

        ILinkedList<Integer> myList = new MyLinkedList<>();

        List<Integer> pcList = new LinkedList<>();
        System.out.println("Количество элементов = 1000000");
        for (int i = 0; i < 1000000; i++) {
            myList.add((int) (Math.random() * 1000000));
            pcList.add((int) (Math.random() * 1000000));
        }


        Integer num;
        long start = System.nanoTime();
        num = myList.get(50000);
        long estimated = System.nanoTime() - start;
        System.out.println("Время доступа к элементу в MyLinkedList: " + estimated);

        Integer num2;
        start = System.nanoTime();
        num2 = pcList.get(50000);
        estimated = System.nanoTime() - start;
        System.out.println("Время доступа к элементу в LinkedList: " + estimated);


        start = System.nanoTime();
        myList.indexOf(num);
        estimated = System.nanoTime() - start;
        System.out.println("Время линейного поиска элемента в MyLinkedList: " + estimated);

        start = System.nanoTime();
        pcList.indexOf(num2);
        estimated = System.nanoTime() - start;
        System.out.println("Время линейного поиска элемента в LinkedList: " + estimated);


        start = System.nanoTime();
        myList.add(314159);
        estimated = System.nanoTime() - start;
        System.out.println("Время добавления элемента в MyLinkedList: " + estimated);

        start = System.nanoTime();
        pcList.add(314159);
        estimated = System.nanoTime() - start;
        System.out.println("Время добавления элемента в LinkedList: " + estimated);


        start = System.nanoTime();
        myList.remove();
        estimated = System.nanoTime() - start;
        System.out.println("Время удаления элемента в MyLinkedList: " + estimated);

        start = System.nanoTime();
        ((LinkedList<Integer>) pcList).removeLast();
        estimated = System.nanoTime() - start;
        System.out.println("Время удаления элемента в LinkedList: " + estimated);

    }

    /* Время выполнения основных операций в большинстве случаев приблизительно одинаковое*/
}
