package com.example.stronahtml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "CommitUpdate", value = "/commit-update")
public class CommitUpdate extends HttpServlet {

    /**
     * Metoda zatwierdzająca update danych danej stacji i wykonująca go.
     *
     * @param request  zapytanie użytkownika
     * @param response odpowiedź serwera
     * @throws IOException w wypadku nieoczekiwanych błędów związanych z odczytem/zapisem danych
     */

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String rckik = request.getParameter("rckik");
            String adress = request.getParameter("adress");
            String city = request.getParameter("city");
            String phone = request.getParameter("phone");
            String url = request.getParameter("webpage");
            String id = request.getParameter("id");
            Connection con = ConnectionBuilder.buildConnection();
            PreparedStatement update = con.prepareStatement("update stacja set rckik = ?, adres = ?, miasto = ?, telefon = ?, url = ? where id = ?");
            update.setString(1, rckik);
            update.setString(2, adress);
            update.setString(3, city);
            update.setInt(4, Integer.parseInt(phone));
            update.setString(5, url);
            update.setInt(6, Integer.parseInt(id));
            update.executeUpdate();
            request.getRequestDispatcher("/station-status-li-redirect").forward(request, response);
        }
        catch (Exception e){
            out.println(e);
        }
    }
}
