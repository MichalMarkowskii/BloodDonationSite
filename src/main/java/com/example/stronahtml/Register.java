package com.example.stronahtml;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {

    /**
     * Metoda dodająca nowego użytkownika do bazy danych na podstawie danych wprowadzonych na stronie.
     *
     * @param request  zapytanie użytkownika
     * @param response odpowiedź serwera
     * @throws IOException w wypadku nieoczekiwanych błędów związanych z odczytem/zapisem danych
     */

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String adminCode = request.getParameter("adminCode");
            if (firstName != "" & lastName != "" & email != "" & password != "" & adminCode != "") {
                if (adminCode.equals("admin123")) {
                    Connection con = ConnectionBuilder.buildConnection();
                    PreparedStatement check = con.prepareStatement("SELECT * FROM user where email = '" + email + "'");
                    ResultSet rs = check.executeQuery();
                    if (rs.isBeforeFirst()) {
                        request.setAttribute("infoFail", "Użytkownik o podanym adresie e-mail już istnieje!");
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    } else {
                        PreparedStatement pst = con.prepareStatement("insert into user values(?, ?, ?, ?)");
                        pst.setString(1, email);
                        pst.setString(2, firstName);
                        pst.setString(3, lastName);
                        pst.setString(4, password);
                        int i = pst.executeUpdate();
                        if (i != 0) {
                            request.setAttribute("infoSuccess", "Rejestracja zakończona pomyślnie!");
                            request.getRequestDispatcher("register.jsp").forward(request, response);
                        }
                    }
                } else {
                    request.setAttribute("infoFail", "Niewłaściwy kod administratora!");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("infoFail", "Proszę uzupełnić wszystkie pola!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }
        catch (Exception e){
            out.println(e);
        }
    }

}
