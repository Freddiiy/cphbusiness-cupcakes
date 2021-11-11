package web;

import entities.User;
import io.github.cdimascio.dotenv.Dotenv;
import persistance.Database;
import persistance.UserLogic;

import java.io.*;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.Data;


@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            UserLogic userLogic = new UserLogic(new Database());
            User user = userLogic.getUserFromDb(email, password);

            if(userLogic.userExists(user)) {

                HttpSession session = request.getSession();

                session.setAttribute("email", user.getEmail());
                session.setAttribute("role", user.getRole());
                session.setAttribute("loggedIn", userLogic.isLoggedIn(session, user));

                response.sendRedirect(request.getContextPath() + "/testLogin");
            } else {
                PrintWriter pw = response.getWriter();
                pw.print("Email eller kodeord forkert");
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
    }
}