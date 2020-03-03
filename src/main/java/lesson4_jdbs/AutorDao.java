package lesson4_jdbs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {

    public static final String SELECT_FROM_AUTORS="SELECT *FROM autors";
    public static final String INSert_INTO_AUTORS=
            "INSERT INTO autors(autor_name,autor_surname,autor_email,autor_adress)values(?,?,?,?)";;

    private Connection connection;

    public AutorDao() {
        this.connection = ConnectionUtil.getConnection();;
    }

    public List<Autor> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_AUTORS);

        List<Autor> autors= new ArrayList<>();

        while (resultSet.next()){
            autors.add(Autor.of(resultSet));
        }
        return autors;
    }

    public int insert(String autorName,String autorSurname,String autorEmail,String autorAdress) throws SQLException {

        PreparedStatement preparedStatement =
                connection.prepareStatement(INSert_INTO_AUTORS, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setObject(1,autorName);
        preparedStatement.setObject(2,autorSurname);
        preparedStatement.setObject(3,autorEmail);
        preparedStatement.setObject(4,autorAdress);

        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        generatedKeys.next();

        return generatedKeys.getInt(1);
    }
}
