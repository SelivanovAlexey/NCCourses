package collections.performance;

import java.util.*;

public class SetPerformance {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("Производительность HashSet, LinkedHashSet и TreeSet (15000)");

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();


        long start = System.nanoTime();
        for (int i = 0; i < 15000; i++) {
            hashSet.add(""+r.nextInt(15000));
        }
        long estimated = System.nanoTime() - start;
        System.out.println("Добавление в HashSet: " + estimated);

        start = System.nanoTime();
        for (int i = 0; i < 15000; i++) {
            linkedHashSet.add(""+r.nextInt(15000));
        }
        estimated = System.nanoTime() - start;
        System.out.println("Добавление в LinkedHashSet: " + estimated);

        start = System.nanoTime();
        for (int i = 0; i < 15000; i++) {
            treeSet.add(""+r.nextInt(15000));
        }
        estimated = System.nanoTime() - start;
        System.out.println("Добавление в TreeSet: " + estimated);


        start = System.nanoTime();
        hashSet.remove("13211");
        estimated = System.nanoTime() - start;
        System.out.println("Удаление из HashSet: " + estimated);

        start = System.nanoTime();
        linkedHashSet.remove("13211");
        estimated = System.nanoTime() - start;
        System.out.println("Удаление из LinkedHashSet: " + estimated);

        start = System.nanoTime();
        treeSet.remove("13211" );
        estimated = System.nanoTime() - start;
        System.out.println("Удаление из TreeSet: " + estimated);


        start = System.nanoTime();
        hashSet.contains("4353");
        estimated = System.nanoTime() - start;
        System.out.println("Проверка на содержание в HashSet: " + estimated);

        start = System.nanoTime();
        linkedHashSet.contains("4353");
        estimated = System.nanoTime() - start;
        System.out.println("Проверка на содержание в LinkedHashSet: " + estimated);

        start = System.nanoTime();
        treeSet.contains("4353");
        estimated = System.nanoTime() - start;
        System.out.println("Проверка на содержание в TreeSet: " + estimated);
    }


}
