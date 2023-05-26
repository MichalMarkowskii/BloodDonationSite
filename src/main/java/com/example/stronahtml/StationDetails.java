package com.example.stronahtml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "StationDetails", value = "/station-details")
public class StationDetails extends HttpServlet {

    /**
     * Metoda pobierająca dane z bazy o szczegółach danej stacji i wyświetlająca je.
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
            String stationId = request.getParameter("stationId");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stacja where id = " + stationId);
            resultSet.next();
            Station station = new Station(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6), new ArrayList<>());
            request.setAttribute("station", station);
            request.getRequestDispatcher("station-details.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}