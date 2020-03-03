package lesson4_jdbs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookAutor {

    private int bookId;
    private int autorId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public static BookAutor of(ResultSet resultSet) throws SQLException {
        BookAutor bookAutor = new BookAutor();
        bookAutor.setBookId(resultSet.getInt("book_id"));
        bookAutor.setAutorId(resultSet.getInt("autor_id"));
        return bookAutor;
    }

    @Override
    public String toString() {
        return "BookAutor{" +
                "bookId=" + bookId +
                ", autorId=" + autorId +
                '}';
    }
}
