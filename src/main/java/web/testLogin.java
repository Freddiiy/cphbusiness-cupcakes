package web;

import entities.User;
import persistance.Database;
import persistance.UserLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "testLogin", urlPatterns = {"/testLogin"})
public class testLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        UserLogic userLogic = new UserLogic(new Database());
        String sessionID = session.getId();

        if (userLogic.validateSession(session)) {
            request.getRequestDispatcher("/WEB-INF/testLogin.jsp").forward(request, response);
        } else {
            session.invalidate();
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}