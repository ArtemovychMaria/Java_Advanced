package lesson5_servlets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static final String SELECT_FROM_USERS="SELECT *FROM users";
    public static final String SELECT_FROM_USERS_BY_EMAIL="SELECT *FROM users where user_email=";
    public static final String INSERT_INTO_USERS=
            "INSERT INTO users(first_name,last_name,user_email,password)values(?,?,?,?)";;

    private Connection connection;


//    public UserDao() {
//        this.connection = ConnectionUtil.getConnection();;
//    }

//    public List<User> getAll() throws SQLException {
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(SELECT_FROM_USERS);
//
//        List<User> users= new ArrayList<>();
//
//        while (resultSet.next()){
//            users.add(User.of(resultSet));
//        }
//        return users;
//    }

    public void insert(String firstName,String lastName,String userEmail,String password) throws SQLException {

        connection=ConnectionUtil.getConnection();

        PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_INTO_USERS, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setObject(1,firstName);
        preparedStatement.setObject(2,lastName);
        preparedStatement.setObject(3,userEmail);
        preparedStatement.setObject(4,password);

        preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();
    }

    public User getUserByEmail(String email) throws SQLException {

        Statement statement=null;
        ResultSet resultSet= null;

        connection=ConnectionUtil.getConnection();
            statement=connection.createStatement();
        String myQuery=String.format("%s\'%s\'",SELECT_FROM_USERS_BY_EMAIL,email);
        resultSet = statement.executeQuery(myQuery);

        resultSet.next();

        User user=User.of(resultSet);

        connection.close();
        statement.close();
        resultSet.close();

        return user;
    }
}
