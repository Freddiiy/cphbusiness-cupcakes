package web.view;

import controller.CupcakeController;
import model.CustomCupcake;
import persistance.Database;
import controller.UserController;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "CustomShop", urlPatterns = {"/shop/custom"})
public class CustomShop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/customShop.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String bottom = request.getParameter("bottom");
        String topping = request.getParameter("topping");
        int amount = Integer.parseInt(request.getParameter("amount"));

        HttpSession session = request.getSession();
        String sessionID = session.getId();
        UserController userController = new UserController(new Database());
        model.CustomCupcake customCupcake = new model.CustomCupcake(bottom, topping, amount);
        CupcakeController cupcakeController = new CupcakeController(new Database());


        cupcakeController.insertOrderToDB(customCupcake, sessionID);

        try {
            PrintWriter pw = response.getWriter();
            pw.print(userController.getOrdersFromDb(sessionID).size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

