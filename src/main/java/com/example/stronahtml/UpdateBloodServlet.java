package com.example.stronahtml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateBlood", value = "/update-blood-redirect")
public class UpdateBloodServlet extends HttpServlet {

    /**
     * Metoda pobierająca aktualne dane z bazy o statusie krwi i przekazująca je na stronę edycji statusu krwi.
     *
     * @param request  zapytanie użytkownika
     * @param response odpowiedź serwera
     * @throws IOException w wypadku nieoczekiwanych błędów związanych z odczytem/zapisem danych
     * @throws ServletException w wypadku błędy związanego z wykonaniem servleta
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Connection connection = ConnectionBuilder.buildConnection();
            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            String stationId = request.getParameter("stationId");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stacja where id = " + stationId);
            resultSet.next();
            List<String> statuses = new ArrayList<>();
            ResultSet resultSet1 = statement1.executeQuery("select * from statusKrwi where stacja_id = " + stationId);
            resultSet1.next();
            int i = 1;
            while (i < 9) {
                statuses.add(resultSet1.getString(i));
                i++;
            }
            Station station = new Station(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6), statuses);
            request.setAttribute("station", station);
            request.getRequestDispatcher("update-blood.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
