package lesson4_jdbs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookAutorDao {

    public static final String SELECT_FROM_BOOKS_AUTORS="SELECT *FROM books_autors";

    private Connection connection;

    public BookAutorDao() {
        this.connection = ConnectionUtil.getConnection();;
    }

    public List<BookAutor> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_BOOKS_AUTORS);

        List<BookAutor> booksAutors= new ArrayList<>();

        while (resultSet.next()){
            booksAutors.add(BookAutor.of(resultSet));
        }
        return booksAutors;
    }
}
