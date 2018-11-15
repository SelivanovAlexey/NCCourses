package oop1;

import java.util.Arrays;

public class Book {

    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    public String getAuthorNames() {
        String authorNames = "";
        for (Author aut : authors) {
            authorNames += aut.getName() + " ";
        }
        return authorNames;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Book)) return false;

        Book book = (Book) obj;
        return this.name.equals(book.name) && Arrays.equals(this.authors,authors)
                && this.price == book.price && this.qty == book.qty;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        for (Author el : authors) {
            result = 31 * result + el.hashCode();
        }
        long f = Double.doubleToLongBits(price);
        result = 31 * result + (int) (f ^ f >>> 32);
        result = 31 * result + qty;
        return result;
    }
}
