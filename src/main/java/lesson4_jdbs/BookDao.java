package lesson4_jdbs;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public static final String SELECT_FROM_BOOKS="SELECT *FROM books";
    public static final String INSERT_INTO_BOOKS=
            "INSERT INTO books(book_name,description,price,isbn,category_id)values(?,?,?,?,?)";
    public static final String UPDATE_BOOKS="UPDATE books set price=? where book_name=?";

private Connection connection;

    public BookDao() {
        this.connection = ConnectionUtil.getConnection();;
    }

    public List<Book> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_BOOKS);

        List<Book> books= new ArrayList<>();

        while (resultSet.next()){
            books.add(Book.of(resultSet));
        }
        return books;
    }

    public int insert(String bookName,String description,int price,long isbn,int categoryId) throws SQLException {

        PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_INTO_BOOKS, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setObject(1,bookName);
        preparedStatement.setObject(2,description);
        preparedStatement.setObject(3,price);
        preparedStatement.setObject(4,isbn);
        preparedStatement.setObject(5,categoryId);

        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        generatedKeys.next();

        return generatedKeys.getInt(1);
    }

    public int update(int price,String bookName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKS);

        preparedStatement.setObject(1,price);
        preparedStatement.setObject(2,bookName);

        preparedStatement.executeUpdate();

        return 0;
    }
}
