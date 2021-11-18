package web.cart;

import controller.CartController;
import controller.CartItemsController;
import controller.CupcakeController;
import model.CartItems;
import model.Cupcake;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bottom = request.getParameter("bottom");
        String topping = request.getParameter("topping");
        int amount = Integer.parseInt(request.getParameter("amount"));

        HttpSession session = request.getSession();
        String sessionID = session.getId();

        Cupcake cupcake = new Cupcake(bottom, topping, amount);

        CartItems cartItems = new CartItems(cupcake.getBottom(), cupcake.getTopping(), cupcake.getAmount());
        CartController cartController = new CartController(new Database());
        cartController.addToCart(cartItems, sessionID);

        response.sendRedirect("/shop");

    }
}