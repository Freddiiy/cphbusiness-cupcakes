package web;

import io.github.cdimascio.dotenv.Dotenv;
import persistance.DBcredentials;
import persistance.Database;

import java.io.*;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "Index", value = "")
public class Index extends HttpServlet {
    public static Dotenv dotenv = (Dotenv) Dotenv.configure().directory("./").filename("env");

    public final static String USER = dotenv.get("USER");
    public final static String PASSWORD = dotenv.get("PASSWORD");
    public final static String URL = dotenv.get("URL");

    public static Database database;

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