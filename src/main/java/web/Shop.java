package web;

import persistance.Database;
import persistance.UserLogic;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "Shop", urlPatterns = {"/shop"})
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserLogic userLogic = new UserLogic(new Database());
        HttpSession session = request.getSession();

        if(userLogic.validateSession(session)) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/shop.jsp").forward(request, response);
    }
}