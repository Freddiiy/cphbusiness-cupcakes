package web.view;

import controller.UserController;
import persistance.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;



@WebServlet(name = "ShoppingCart", urlPatterns = {"/shoppingcart"})
public class ShoppingCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserController userController = new UserController(new Database());
        HttpSession session = request.getSession();

        if(!userController.validateSession(session)) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            String sessionID = request.getSession().getId();
            List orderList = userController.getOrdersFromDb(sessionID);

            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("/WEB-INF/userOrders.jsp").forward(request, response);
            }
        }
    }
