package model;

public class User {
    private int id;
    private String email;
    private String password;
    private double balance;
    private String role;
    private String sessionID;

    public User(String email, String password, String role, String sessionID) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.sessionID = sessionID;
    }

    public User(String email, String password, double balance, String role, String sessionID) {
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.role = role;
        this.sessionID = sessionID;
    }

    public User(int id, String email, String password, double balance, String role, String sessionID) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.role = role;
        this.sessionID = sessionID;
    }

    public User(int id, String email, double balance, String role, String sessionID) {
        this.id = id;
        this.email = email;
        this.balance = balance;
        this.role = role;
        this.sessionID = sessionID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
