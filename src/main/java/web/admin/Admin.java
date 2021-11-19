package web.admin;


import controller.OrderController;
import persistance.Database;
import controller.UserController;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "Admin", urlPatterns = {"/admin"})
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserController userController = new UserController(new Database());
        OrderController orderController = new OrderController(new Database());
        HttpSession session = request.getSession();

        if(userController.validateSession(session) && userController.isAdmin(session.getId())) {
            String sessionID = request.getSession().getId();
            List orderList = orderController.adminGetOrders(sessionID);

            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}