package web;

import io.github.cdimascio.dotenv.Dotenv;
import persistance.Database;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "Index", value = "")
public class Index extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/home").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}