package collections;

import java.util.Iterator;

public class MainClass {
    public static void main(String[] args) {

        ILinkedList<String> list = new MyLinkedList();

        list.add("3");
        list.add("32");
        list.add("12");
        list.add("154");
        list.add("934");


        System.out.println("Source list");
        System.out.println(list);
        System.out.println();


        System.out.println("Inserting");
        System.out.println(list);

        list.add(3, "22");

        System.out.println(list);
        System.out.println();



        System.out.println("Getting element");
        System.out.println(list);

        System.out.println(list.get(4));

        System.out.println();



        System.out.println("Getting index of element");
        System.out.println(list);

        System.out.println(list.indexOf("32"));

        System.out.println();



        System.out.println("Setting new value");
        System.out.println(list);

        System.out.println("Old value = " + list.set(1, "10"));

        System.out.println(list);
        System.out.println();



        System.out.println("Removing element");
        System.out.println(list);

        System.out.println("Old value = " + list.remove(4));

        System.out.println(list);
        System.out.println();


        System.out.println("Removing element from end");
        System.out.println(list);

        System.out.println("Old value = " + list.remove());

        System.out.println(list);
        System.out.println();


        System.out.println("Clearing the list");

        list.clear();

        System.out.println(list);


    }


}
