package libraryUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {

    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
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
                ", author=" + author +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    public String getAuthorsNameString() {
        return this.author.getName();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Book)) return false;

        Book book = (Book) obj;
        return this.name.equals(book.name) && this.author.equals(book.author)
                && this.price == book.price && this.qty == book.qty;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        long f = Double.doubleToLongBits(price);
        result = 31 * result + (int) (f ^ f >>> 32);
        result = 31 * result + qty;
        return result;
    }


}