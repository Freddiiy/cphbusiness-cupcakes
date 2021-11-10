package web;

import io.github.cdimascio.dotenv.Dotenv;
import persistance.Database;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "PageController", urlPatterns = {"/home"})
public class PageController extends HttpServlet {
    Dotenv dotenv = Dotenv.configure().load();

    public final String USER = dotenv.get("USER");
    public final String PASSWORD = dotenv.get("PASSWORD");
    public final String URL = dotenv.get("URL");

    public static Database database;

    @Override
    public void init() {
        System.out.println(USER + " " + PASSWORD + " " + URL);
        if (database == null) {
            try {
                database = new Database(USER, PASSWORD, URL);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
    }
}