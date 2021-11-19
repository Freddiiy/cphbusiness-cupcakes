package web.admin;


import controller.OrderController;
import persistance.Database;
import controller.UserController;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "AdminRemoveOrder", urlPatterns = {"/adminRemoveOrder"})
public class AdminRemoveOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        UserController userController = new UserController(new Database());

        if (userController.isAdmin(session.getId())) {
            OrderController orderController = new OrderController(new Database());
            int orderId = Integer.parseInt(request.getParameter("orderId"));

            orderController.adminRemoveOrder(orderId, session.getId());
            response.sendRedirect("/admin");
        } else {
            response.sendRedirect("/");
        }
    }
}