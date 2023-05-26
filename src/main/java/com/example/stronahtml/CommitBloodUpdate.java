package com.example.stronahtml;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "CommitBloodUpdate", value = "/commit-blood-update")
public class CommitBloodUpdate extends HttpServlet {

    /**
     * Metoda zatwierdzająca update stanu krwi dla danej stacji i wykonująca go.
     *
     * @param request  zapytanie użytkownika
     * @param response odpowiedź serwera
     * @throws IOException w wypadku nieoczekiwanych błędów związanych z odczytem/zapisem danych
     */

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String zP = request.getParameter("0 Rh+");
            String AP = request.getParameter("A Rh+");
            String BP = request.getParameter("B Rh+");
            String ABP = request.getParameter("AB Rh+");
            String zM = request.getParameter("0 Rh-");
            String AM = request.getParameter("A Rh-");
            String BM = request.getParameter("B Rh-");
            String ABM = request.getParameter("AB Rh-");
            String id = request.getParameter("id");
            Connection con = ConnectionBuilder.buildConnection();
            PreparedStatement update = con.prepareStatement("update statusKrwi set 0rhp = ?, Arhp = ?, Brhp = ?, ABrhp = ?, 0rhm = ?, Arhm = ?,Brhm = ?, ABrhm = ? where stacja_id = ?");
            update.setString(1, zP);
            update.setString(2, AP);
            update.setString(3, BP);
            update.setString(4, ABP);
            update.setString(5, zM);
            update.setString(6, AM);
            update.setString(7, BM);
            update.setString(8, ABM);
            update.setInt(9, Integer.parseInt(id));
            update.executeUpdate();
            request.getRequestDispatcher("/station-status-li-redirect").forward(request, response);
        }
        catch (Exception e){
            out.println(e);
        }
    }
}
