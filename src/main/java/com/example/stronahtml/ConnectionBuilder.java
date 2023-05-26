package com.example.stronahtml;

import java.sql.*;

public class ConnectionBuilder {

    /**
     * Metoda pozwalająca na utworzenie połączenia z bazą danych.
     *
     * @return połączenie z bazą danych lub null w przypadku niepowodzenia
     */

    public static Connection buildConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder urlSB = new StringBuilder("jdbc:mysql://"); //
        urlSB.append("localhost:3306/"); // numer portu
        urlSB.append("krwiodawstwo?"); // nazwa bazy
        urlSB.append("useUnicode=true&characterEncoding=utf-8"); // kodowanie
        urlSB.append("&user=root"); // nazwa uzytkownika (root)
        urlSB.append("&password="); // haslo uzytkownika
        urlSB.append("&serverTimezone=CET"); // strefa czasowa (CET)
        String connectionUrl = urlSB.toString();
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}