package web.view;


import controller.UserController;
import persistance.Database;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "UserOrders", urlPatterns = {"/orders"})
public class UserOrders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserController userController = new UserController(new Database());
        HttpSession session = request.getSession();

        if(!userController.validateSession(session)) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.getRequestDispatcher("/WEB-INF/userOrders.jsp").forward(request, response);
        }
    }
}