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


@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        Validation validation = new Validation();
        if (validation.validateEmail(email) && validation.matchPasswords(password1, password2)) {
            User user = new User(email, password1, "Costumer");

            try {
                UserLogic userLogic = new UserLogic(new Database());
                userLogic.insertUserToDb(user);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}