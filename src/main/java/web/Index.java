package web;

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
    public final static String USER = DBcredentials.getUser();
    public final static String PASSWORD = DBcredentials.getPassword();
    public final static String URL = DBcredentials.getUrl();

    public static Database database;

    public void initDB() {
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