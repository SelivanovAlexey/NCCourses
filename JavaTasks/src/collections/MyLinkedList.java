package collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size;                                 // Размер списка
    private Node<E> first;                            // Указатель на первый элемент
    private Node<E> last;                             // Указатель на последний элемент

    public MyLinkedList() {                             // Создается пустой спиосок
        size = 0;
    }


    Node<E> node(int index) {                           // Возвращает объект узла с заданным индексом
        if (index < size) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else throw new IndexOutOfBoundsException();
    }


    @Override
    public void add(E element) {                        // Добавление элемента в конец списка
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public void add(int index, E element) {             // Добавление элемента по индексу
        Node<E> newNode = new Node<>(node(index).prev, element, node(index));
        node(index).prev = newNode;
        node(index - 1).next = newNode;
        size++;
    }

    @Override
    public void clear() {                               // Очистка списка
        Node<E> x = first;
        while (x != null) {
            Node<E> next = x.next;
            x.prev = null;
            x.item = null;
            x.next = null;
            x = next;
        }
    }

    @Override
    public E get(int index) {                           // Доступ к элементу по индексу
        return node(index).item;
    }

    @Override
    public int indexOf(E element) {                     // Получение индекса элемента
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (element.equals(x.item)) return index;
            index++;
        }
        throw new NoSuchElementException();
    }

    @Override
    public E remove() {                                 // Удаление последнего элемента из списка
        E element = last.item;
        Node<E> prev = last.prev;
        last.item = null;
        last.prev = null;
        last = prev;
        if (prev == null) first = null;
        else prev.next = null;
        size--;
        return element;
    }

    @Override
    public E remove(int index) {                        // Удаление элемента из списка по индексу
                                                        // Возвращает значение удаленного элемента
        Node<E> oldNode = node(index);
        E element = oldNode.item;
        Node<E> next = oldNode.next;
        Node<E> prev = oldNode.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            oldNode.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            oldNode.next = null;
        }

        oldNode.item = null;
        size--;
        return element;
    }

    @Override
    public E set(int index, E element) {                // Установка нового значения по индексу
        Node<E> x = node(index);
        E value = x.item;
        x.item = element;
        return value;
    }

    @Override
    public int size() {
        return size;
    }                   // Возвращает размер списка


    @Override
    public E[] toArray() {                               // Возращает дженерик-массив
        E[] newArray ;
        E tmp = this.get(0);
        if (tmp == null) return (E[]) Array.newInstance(Object.class, 0);
        int index = 0;
        newArray = (E[]) Array.newInstance(tmp.getClass(), size);

        for (Node<E> x = first; x != null; x = x.next) {
            newArray[index] = x.item;
            index++;
        }

        return newArray;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (E element : this)
            hashCode = 31 * hashCode + (element == null ? 0 : element.hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyLinkedList)) return false;

        Iterator<E> it1 = iterator();
        Iterator<E> it2 = ((MyLinkedList) obj).iterator();
        while (it1.hasNext() && it2.hasNext()) {
            E el1 = it1.next();
            Object el2 = it2.next();
            if (el1 == null || el2 == null) return false;
            if (!(el1.equals(el2))) return false;
        }
        return !(it1.hasNext() || it2.hasNext());
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListItr<>();
    }


    public class MyLinkedListItr<E> implements Iterator<E> {           // реализация итератора

        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;


        public MyLinkedListItr() {
            if (size == 0) next = null;
            else {
                next = (Node<E>) node(nextIndex);
                nextIndex++;
            }
        }

        @Override
        public boolean hasNext() {
            return nextIndex <= size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
