package com.example.stronahtml;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogOut", value = "/logout")
public class LogOut extends HttpServlet {

    /**
     * Metoda wylogowywujaca aktualnego użytkownika.
     *
     * @param request  zapytanie użytkownika
     * @param response odpowiedź serwera
     * @throws IOException w wypadku nieoczekiwanych błędów związanych z odczytem/zapisem danych
     */

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User.setFirstName(null);
        User.setLastName(null);
        User.setEmail(null);
        User.setPassword(null);
        response.sendRedirect(request.getContextPath() + "/index.jsp");

    }
}
