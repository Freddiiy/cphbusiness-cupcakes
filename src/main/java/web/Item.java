package web;

import persistance.CupcakeInfo;
import persistance.Database;
import controller.UserController;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "Item", urlPatterns = {"/shop/item"})
public class Item extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserController userController = new UserController(new Database());
        HttpSession session = request.getSession();

        //No ID query specified (temp)
        if (request.getParameter("id") == "") {
            PrintWriter writer=response.getWriter();
            writer.append("No cupcake specified");
        } else {
            String[] cupcakeData = new CupcakeInfo(new Database()).getItemFromID(request.getParameter("id"));
            request.setAttribute("name", cupcakeData[0]);
            request.setAttribute("desc", cupcakeData[1]);
            request.setAttribute("imageURL", cupcakeData[2]);

            request.getRequestDispatcher("/WEB-INF/item.jsp").forward(request, response);
        }
    }
}