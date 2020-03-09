package lesson5_servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/entrance")
public class EntranceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email=req.getParameter("login");
        String password=req.getParameter("password");

        if (req.getParameter("Registration") != null){
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }

        if (req.getParameter("logIn") != null){

            UserDao userDao=new UserDao();

            User user = null;
            try {
                user = userDao.getUserByEmail(email);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("User is not found");
            }

            if (user == null){
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                return;
            }

            if (user.getPassword().equals(password)){
                req.setAttribute("userIdentyficator", user.getFirstName());
                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            }

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
