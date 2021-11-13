package web;

import entities.User;
import persistance.Database;
import persistance.UserLogic;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserLogic userLogic = new UserLogic(new Database());
        HttpSession session = request.getSession();

        if(userLogic.validateSession(session)) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        String sessionID = session.getId();

        try {
            UserLogic userLogic = new UserLogic(new Database());

            User user = userLogic.getUserFromDb(email, password);

            if(userLogic.userExists(user)) {

                session.setAttribute("email", email);
                session.setAttribute("sessionID", sessionID);
                userLogic.updateSessionID(email, session);

                response.sendRedirect(request.getContextPath() + "/");
            } else {
                PrintWriter pw = response.getWriter();
                pw.print("Email eller kodeord forkert");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
    }
}