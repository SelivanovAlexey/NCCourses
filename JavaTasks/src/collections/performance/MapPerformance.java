package collections.performance;

import java.util.*;

public class MapPerformance {
    public static void main(String[] args) {


        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();


        long start = System.nanoTime();
        for (int i = 0; i < 150000; i++) {
            hashMap.put((int) (Math.random() * 150000), (int) (Math.random() * 150000));
        }
        long estimated = System.nanoTime() - start;
        System.out.println("Добавление в HashMap: " + estimated);

        start = System.nanoTime();
        for (int i = 0; i < 150000; i++) {
            linkedHashMap.put((int) (Math.random() * 150000), (int) (Math.random() * 150000));
        }
        estimated = System.nanoTime() - start;
        System.out.println("Добавление в LinkedHashMap: " + estimated);

        start = System.nanoTime();
        for (int i = 0; i < 150000; i++) {
            treeMap.put((int) (Math.random() * 150000), (int) (Math.random() * 150000));
        }
        estimated = System.nanoTime() - start;
        System.out.println("Добавление в TreeMap: " + estimated);


        start = System.nanoTime();
        hashMap.remove(1);
        estimated = System.nanoTime() - start;
        System.out.println("Удаление из HashMap: " + estimated);

        start = System.nanoTime();
        linkedHashMap.remove(1);
        estimated = System.nanoTime() - start;
        System.out.println("Удаление из LinkedHashMap: " + estimated);

        start = System.nanoTime();
        treeMap.remove(1 );
        estimated = System.nanoTime() - start;
        System.out.println("Удаление из TreeMap: " + estimated);


        start = System.nanoTime();
        hashMap.containsKey(4353);
        estimated = System.nanoTime() - start;
        System.out.println("Проверка на содержание ключа в HashMap: " + estimated);

        start = System.nanoTime();
        linkedHashMap.containsKey(4353);
        estimated = System.nanoTime() - start;
        System.out.println("Проверка на содержание ключа в LinkedHashMap: " + estimated);

        start = System.nanoTime();
        treeMap.containsKey(4353);
        estimated = System.nanoTime() - start;
        System.out.println("Проверка на содержание ключа в TreeMap: " + estimated);
    }
}
