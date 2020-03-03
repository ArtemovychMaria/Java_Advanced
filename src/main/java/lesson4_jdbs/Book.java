package lesson4_jdbs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
    private int id;
    private String bookName;
    private String decsription;
    private int price;
    private long isbn;
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDecsription() {
        return decsription;
    }

    public void setDecsription(String decsription) {
        this.decsription = decsription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public static Book of(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setBookName(resultSet.getString("book_name"));
        book.setDecsription(resultSet.getString("description"));
        book.setPrice(resultSet.getInt("price"));
        book.setIsbn(resultSet.getInt("isbn"));
        book.setCategoryId(resultSet.getInt("category_id"));
        return book;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", decsription='" + decsription + '\'' +
                ", price=" + price +
                ", isbn=" + isbn +
                ", categoryId=" + categoryId +
                '}';
    }
}
