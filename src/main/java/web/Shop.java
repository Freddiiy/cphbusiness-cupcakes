package web;

import entities.User;
import io.github.cdimascio.dotenv.Dotenv;
import persistance.Database;
import persistance.UserLogic;
import validation.Validation;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "Shop", urlPatterns = {"/shop"})
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            UserLogic userLogic = new UserLogic(new Database());
            HttpSession session = request.getSession();

            if(userLogic.validateSession(session)) {
                //request.getRequestDispatcher("/testLogin").forward(request, response);
                response.sendRedirect(request.getContextPath() + "/");
                return;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

/*    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        HttpSession session = request.getSession();
        String sessionID = session.getId();

        Validation validation = new Validation();
        if (validation.validateEmail(email) && validation.matchPasswords(password1, password2)) {
            User user = new User(email, password1, "Costumer", sessionID);

            try {
                UserLogic userLogic = new UserLogic(new Database());

                if (!userLogic.emailExists(email)) {
                    userLogic.insertUserToDb(user);

                    session.setAttribute("email", email);
                    session.setAttribute("sessionID", sessionID);

                    response.sendRedirect(request.getContextPath() + "/");
                }
                else {
                    PrintWriter pw = response.getWriter();
                    pw.print("Email fines allerede");
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }
*/
}