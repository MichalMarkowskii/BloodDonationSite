package com.example.stronahtml;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "DeleteStation", value = "/delete-station")
public class DeleteStation extends HttpServlet {

    /**
     * Metoda usuwająca dane i status stacji o podanym ID.
     *
     * @param request  zapytanie użytkownika
     * @param response odpowiedź serwera
     * @throws IOException w wypadku nieoczekiwanych błędów związanych z odczytem/zapisem danych
     */

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String id = request.getParameter("id");
            Connection con = ConnectionBuilder.buildConnection();
            PreparedStatement deleteStatuses = con.prepareStatement("delete from statusKrwi where stacja_id = ?");
            PreparedStatement deleteStation = con.prepareStatement("delete from stacja where id = ?");
            deleteStatuses.setInt(1, Integer.parseInt(id));
            deleteStation.setInt(1, Integer.parseInt(id));
            deleteStatuses.executeUpdate();
            deleteStation.executeUpdate();
            request.getRequestDispatcher("/station-status-li-redirect").forward(request, response);
        }
        catch (Exception e){
            out.println(e);
        }
    }
}