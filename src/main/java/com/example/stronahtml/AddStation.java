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

@WebServlet(name = "AddStation", value = "/add-station")
public class AddStation extends HttpServlet {

    /**
     * Metoda dodająca nową stację do bazy danych na podstawie danych wprowadzonych na stronie
     *
     * @param request  zapytanie użytkownika
     * @param response odpowiedź serwera
     * @throws IOException w wypadku nieoczekiwanych błędów związanych z odczytem/zapisem danych
     */

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rckik = request.getParameter("rckik");
            String adress = request.getParameter("adress");
            String city = request.getParameter("city");
            String phone = request.getParameter("phone");
            String url = request.getParameter("webpage");
            if (rckik != "" & adress != "" & city != "" & phone != "" & url != "") {
                Connection con = ConnectionBuilder.buildConnection();
                PreparedStatement check = con.prepareStatement("SELECT * FROM stacja where rckik = ? and adres = ? and miasto = ? and telefon = ? and url = ?");
                check.setString(1, rckik);
                check.setString(2, adress);
                check.setString(3, city);
                check.setInt(4, Integer.parseInt(phone));
                check.setString(5, url);
                ResultSet rs = check.executeQuery();
                if (rs.isBeforeFirst()) {
                    request.setAttribute("infoFail", "Stacja o podanych danych już istnieje!");
                    request.getRequestDispatcher("add-station.jsp").forward(request, response);
                } else {
                    PreparedStatement pst = con.prepareStatement("insert into stacja(`rckik`, `adres`, `miasto`, `telefon`, `url`) values(?, ?, ?, ?, ?)");
                    pst.setString(1, rckik);
                    pst.setString(2, adress);
                    pst.setString(3, city);
                    pst.setInt(4, Integer.parseInt(phone));
                    pst.setString(5, url);
                    int i = pst.executeUpdate();
                    if (i != 0) {
                        request.setAttribute("infoSuccess", "Stacja dodana pomyślnie!");
                        request.getRequestDispatcher("add-station.jsp").forward(request, response);
                    }
                }
            } else {
                request.setAttribute("infoFail", "Proszę uzupełnić wszystkie pola!");
                request.getRequestDispatcher("add-station.jsp").forward(request, response);
            }
        } catch (Exception e) {
            out.println(e);
        }
    }
}
