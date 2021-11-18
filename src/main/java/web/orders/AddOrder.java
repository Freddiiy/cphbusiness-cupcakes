package web.orders;

import controller.OrderController;
import model.Cart;
import model.CartItems;
import persistance.Database;
import controller.UserController;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "AddOrder", urlPatterns = {"/addOrder"})
public class AddOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/confirmedOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        //Tak til Benjamin på YouTube for at redde dagen med mit lortekode
        HttpSession session = request.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("orderList");
        System.out.println(cart.size());

        UserController userController = new UserController(new Database());
        OrderController orderController = new OrderController(new Database());

        for (Cart cartitems : cart) {
            orderController.addToOrder(new CartItems(cartitems.getCartItems().getBottom(), cartitems.getCartItems().getTopping(), cartitems.getCartItems().getAmount()), session.getId());
        }
    }
}
