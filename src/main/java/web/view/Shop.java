package web.view;

import controller.CupcakeController;
import model.Cupcake;
import model.User;
import persistance.Database;
import controller.UserController;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "Shop", urlPatterns = {"/shop"})
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/WEB-INF/shop_tmp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String bottom = request.getParameter("bottom");
        String topping = request.getParameter("topping");
        int amount = Integer.parseInt(request.getParameter("amount"));

        HttpSession session = request.getSession();
        String sessionID = session.getId();
        Cupcake cupcake = new Cupcake(bottom, topping, amount);
        CupcakeController cupcakeController = new CupcakeController(new Database());

        cupcakeController.insertOrderToDB(cupcake, sessionID);
    }
}

