package collections.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformance {
    public static void main(String[] args) {

        System.out.println("Производительность ArrayList и LinkedList (1000000)");

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add((int) (Math.random() * 1000000));
        }
        List<Integer> linkedList = new LinkedList<>(arrayList);



        long start = System.nanoTime();
        arrayList.add(9);
        long estimated = System.nanoTime() - start;
        System.out.println("Добавление в ArrayList: "+ estimated);

        start = System.nanoTime();
        linkedList.add(9);
        estimated = System.nanoTime() - start;
        System.out.println("Добавление в LinkedList: "+ estimated);



        start = System.nanoTime();
        arrayList.get(321567);
        estimated = System.nanoTime() - start;
        System.out.println("Доступ в ArrayList: "+ estimated);

        start = System.nanoTime();
        linkedList.get(321567);
        estimated = System.nanoTime() - start;
        System.out.println("Доступ в LinkedList: "+ estimated);



        start = System.nanoTime();
        arrayList.add(3215,48);
        estimated = System.nanoTime() - start;
        System.out.println("Вставка в ArrayList: "+ estimated);

        start = System.nanoTime();
        linkedList.add(3215,48);
        estimated = System.nanoTime() - start;
        System.out.println("Вставка в LinkedList: "+ estimated);



        start = System.nanoTime();
        arrayList.remove(21312);
        estimated = System.nanoTime() - start;
        System.out.println("Удаление из ArrayList: "+ estimated);

        start = System.nanoTime();
        linkedList.remove(21312);
        estimated = System.nanoTime() - start;
        System.out.println("Удаление из LinkedList: "+ estimated);



    }

}
