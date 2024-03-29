package web.admin;


import controller.AdminController;
import persistance.Database;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "AdminAddBalance", urlPatterns = {"/adminAddBalance"})
public class AdminAddBalance extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        AdminController adminController = new AdminController(new Database());

        if (adminController.isAdmin(session.getId())) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int addToBalance = Integer.parseInt(request.getParameter("addToBalance"));

            adminController.updateUserBalance(addToBalance, userId, session.getId());
            response.sendRedirect("/admin");
        } else {
            response.sendRedirect("/");
        }
    }
}