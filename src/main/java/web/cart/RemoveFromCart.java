package web.cart;

import controller.CartController;
import controller.CartItemsController;
import controller.CupcakeController;
import model.CartItems;
import model.Cupcake;
import persistance.Database;
import controller.UserController;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "RemoveFromCart", urlPatterns = {"/removeFromCart"})
public class RemoveFromCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String sessionId = session.getId();

        int cartId = Integer.parseInt(request.getParameter("cartId"));

        CartController cartController = new CartController(new Database());
        cartController.removeItem(cartId, sessionId);
        response.sendRedirect("/cart?addedToCart=1");
    }
}