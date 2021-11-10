package DBAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DBcredentials {
    public static Connection getConnection() {

        File login = new File("dbcred.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(login);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            createDBlogin();
        }

        String url = "";
        String user = "";
        String password = "";
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split("=");
            switch (data[0]) {
                case "url": url = data[1]; break;
                case "user": user = data[1]; break;
                case "password": password = data[1]; break;
            }
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public String getUrl() {
        File login = new File("dbcred.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(login);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            createDBlogin();

            String url = "";
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split("=");
                switch (data[0]) {
                    case "url": url = data[1]; break;
                }
            }
        }
    }

    public static void createDBlogin() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert database url: ");
        String url = scan.next();
        System.out.println("Insert database username: ");
        String user = scan.next();
        System.out.println("Insert database password: ");
        String password = scan.next();

        try {
            FileWriter fw = new FileWriter("dbcred.txt");
            fw.write("url=" + url + "\n"
                    + "user=" + user + "\n"
                    + "password=" + password);
            fw.close();
        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }
}