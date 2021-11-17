package web.view;

import controller.CartController;
import controller.CupcakeController;
import model.CartItems;
import model.CustomCupcake;
import persistance.Database;
import controller.UserController;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "AddToCart", urlPatterns = {"/addToCart"})
public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String bottom = request.getParameter("bottom");
        String topping = request.getParameter("topping");
        int amount = Integer.parseInt(request.getParameter("amount"));

        HttpSession session = request.getSession();
        String sessionID = session.getId();

        CustomCupcake customCupcake = new CustomCupcake(bottom, topping, amount);
        CupcakeController cupcakeController = new CupcakeController(new Database());

        CartItems cartItems = new CartItems(customCupcake.getBottom(), customCupcake.getTopping(), customCupcake.getAmount());


    }
}