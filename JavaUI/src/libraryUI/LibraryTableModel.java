package libraryUI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.table.AbstractTableModel;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryTableModel extends AbstractTableModel {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private List<Book> books;

    public LibraryTableModel() {
        books = readingFromJSON();
        fireTableDataChanged();
    }

    public void addBook(Book book) {
        if (books.size() != 0) {
            for (int i = 0; i < books.size(); i++) {
                Book b = books.get(i);
                if (b.getName().equals(book.getName()) && b.getAuthor().equals(book.getAuthor())
                        && b.getPrice() == book.getPrice()) {
                    b.setQty(b.getQty() + book.getQty());
                } else if (i == books.size() - 1) {
                    books.add(book);
                    break;
                }
            }
        } else books.add(book);
        writingToJSON();
        fireTableDataChanged();
    }

    public void deleteBook(int row, int amount) {
        Book book = books.get(row);
        if (book.getQty() == amount) books.remove(row);
        else if (book.getQty() > amount && amount > 0) {
            book.setQty(book.getQty() - amount);
        }
        writingToJSON();
        fireTableDataChanged();
    }

    public void editBook(int row, Book newBook) {
        books.remove(row);
        books.add(row, newBook);
        writingToJSON();
        fireTableDataChanged();
    }

    public Author getAuthorInfo(int row) {
        return books.get(row).getAuthor();
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book cur = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cur.getName();
            case 1:
                return cur.getAuthor().getName();
            case 2:
                return cur.getPrice();
            case 3:
                return cur.getQty();
        }
        return null;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Book name";
            case 1:
                return "Author";
            case 2:
                return "Price";
            case 3:
                return "Count";
        }
        return "";
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Integer.class;
        }
        return Object.class;
    }

    public List<Book> readingFromJSON() {
        List<Book> booksFromJson = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader("bookStore.json"))) {
            String json = readUsingBufferedReader(fileReader);
            if (!(json.equals(""))) {
                booksFromJson = GSON.fromJson(json, new TypeToken<List<Book>>() {
                }.getType());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return booksFromJson;
    }

    public void writingToJSON() {
        try (FileWriter writer = new FileWriter("bookStore.json", false)) {
            GSON.toJson(books, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readUsingBufferedReader(BufferedReader reader) throws IOException {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        return stringBuilder.toString();
    }


}
