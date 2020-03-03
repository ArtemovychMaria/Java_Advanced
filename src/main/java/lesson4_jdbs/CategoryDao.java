package lesson4_jdbs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public static final String SELECT_FROM_CATEGORIES="SELECT *FROM categories";
    public static final String INSERT_INTO_CATEGORIES="INSERT INTO categories(category_name)values(?)";
    public static final String DELETE_FROM_CATEGORIES="DELETE FROM categories where category_name=?";

    private Connection connection;

    public CategoryDao() {
        this.connection = ConnectionUtil.getConnection();;
    }

    public List<Category> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_CATEGORIES);

        List<Category> categories= new ArrayList<>();

        while (resultSet.next()){
            categories.add(Category.of(resultSet));
        }
        return categories;
    }

    public int insert(String categoryName) throws SQLException {

        PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_INTO_CATEGORIES, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setObject(1,categoryName);

        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        generatedKeys.next();

        return generatedKeys.getInt(1);
    }


    public void delete(String categoryName) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_CATEGORIES);

        preparedStatement.setObject(1,categoryName);

        preparedStatement.executeUpdate();

    }
}
