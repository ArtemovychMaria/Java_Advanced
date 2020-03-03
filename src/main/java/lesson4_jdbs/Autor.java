package lesson4_jdbs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Autor {

    private int id;
    private String autorName;
    private String autorSurname;
    private String autorEmail;
    private String autorAdress;
    private String autorBirthday;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    public String getAutorSurname() {
        return autorSurname;
    }

    public void setAutorSurname(String autorSurname) {
        this.autorSurname = autorSurname;
    }

    public String getAutorEmail() {
        return autorEmail;
    }

    public void setAutorEmail(String autorEmail) {
        this.autorEmail = autorEmail;
    }

    public String getAutorAdress() {
        return autorAdress;
    }

    public void setAutorAdress(String autorAdress) {
        this.autorAdress = autorAdress;
    }

    public String getAutorBirthday() {
        return autorBirthday;
    }

    public void setAutorBirthday(String autorBirthday) {
        this.autorBirthday = autorBirthday;
    }

    public static Autor of(ResultSet resultSet) throws SQLException {
        Autor autor = new Autor();
        autor.setId(resultSet.getInt("id"));
        autor.setAutorName(resultSet.getString("autor_name"));
        autor.setAutorSurname(resultSet.getString("autor_surname"));
        autor.setAutorEmail(resultSet.getString("autor_email"));
        autor.setAutorAdress(resultSet.getString("autor_adress"));
        autor.setAutorBirthday(resultSet.getString("autor_birthday"));
        return autor;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", autorName='" + autorName + '\'' +
                ", autorSurname='" + autorSurname + '\'' +
                ", autorEmail='" + autorEmail + '\'' +
                ", autorAdress='" + autorAdress + '\'' +
                ", autorBirthday='" + autorBirthday + '\'' +
                '}';
    }
}
