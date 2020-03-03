package lesson4_jdbs;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        BookDao bookDao = new BookDao();
        List<Book> all = bookDao.getAll();
        System.out.println(all);

        bookDao.insert("Борисав сміється","захоплююча книга",120,97861712,1);
        bookDao.update(240,"Одного разу");

        AutorDao autorDao =new AutorDao();
        List<Autor> autorList = autorDao.getAll();
        System.out.println(autorList);

        autorDao.insert("Сесілія","Ахерн","ahern@gmail.com","вул.Сихівська,10");

        CategoryDao categoryDao =new CategoryDao();
        List<Category> categoryList = categoryDao.getAll();
        System.out.println(categoryList);

        categoryDao.insert("Поема");
        categoryDao.insert("Детектив");
        categoryDao.delete("Поема");

        BookAutorDao bookAutorDao =new BookAutorDao();
        List<BookAutor> bookAutorList = bookAutorDao.getAll();
        System.out.println(bookAutorList);
    }


}
