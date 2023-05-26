package com.example.stronahtml;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Login", value = "/login")
public class LogIn extends HttpServlet {

    /**
     * Metoda pozwalająca na zalogowanie uprzednio zarejestrowanym użtykownikom (administratorom).
     *
     * @param request  zapytanie użytkownika
     * @param response odpowiedź serwera
     * @throws IOException w wypadku nieoczekiwanych błędów związanych z odczytem/zapisem danych
     */

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Connection con = ConnectionBuilder.buildConnection();
            PreparedStatement check = con.prepareStatement("SELECT * FROM user where email = '"+email+"'and hasło = '"+password+"'");
            ResultSet rs = check.executeQuery();
            if(!rs.isBeforeFirst()){
                request.setAttribute("infoFail", "Wprowadzono niewłaściwy e-mail lub hasło!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                rs.next();
                User.setFirstName(rs.getString(1));
                User.setLastName(rs.getString(2));
                User.setEmail(email);
                User.setPassword(password);
                request.getRequestDispatcher("index-li.jsp").forward(request, response);
            }
        }
        catch (Exception e){
            out.println(e);
        }
    }
}