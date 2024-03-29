package web.view;

import persistance.CupcakeInfo;
import persistance.Database;
import controller.UserController;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "Shop", urlPatterns = {"/shop"})
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserController userController = new UserController(new Database());
        HttpSession session = request.getSession();
        if (userController.validateSession(session)) {
            List cupcakeData = new CupcakeInfo(new Database()).getAllItems();
            request.setAttribute("cupcakeData", cupcakeData);
            request.getRequestDispatcher("/WEB-INF/shop.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }

    }
}