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

@WebServlet(name = "SearchAdmin", value = "/search-li")
public class SearchAdmin extends HttpServlet {

    /**
     * Metoda pobierająca dane z bazy o szczegółach stacji i statusie krwi na podstawie konkretnego zapytania
     * wprowadzonego przez użytkownika, oraz przekierowująca do widoku administratora.
     *
     * @param request  zapytanie użytkownika
     * @param response odpowiedź serwera
     * @throws IOException w wypadku nieoczekiwanych błędów związanych z odczytem/zapisem danych
     * @throws ServletException w wypadku błędy związanego z wykonaniem servleta
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String searchQuery = request.getParameter("searchQuery");
            Connection connection = ConnectionBuilder.buildConnection();
            Statement statement = connection.createStatement();
            Statement statement2 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stacja where rckik like '%"+ searchQuery +"%' or adres like '%"+ searchQuery +"%' or miasto like '%"+ searchQuery +"%' or telefon like '%"+ searchQuery +"%' or url like '%"+ searchQuery +"%' order by rckik");
            List<Station> stations = new ArrayList<>();
            while (resultSet.next()) {
                List<String> statuses = new ArrayList<>();
                ResultSet resultSet1 = statement2.executeQuery("select * from statusKrwi where stacja_id = "+resultSet.getInt(1));
                resultSet1.next();
                int i = 1;
                while (i < 9) {
                    statuses.add(resultSet1.getString(i));
                    i++;
                }
                stations.add(new Station(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6), statuses));
            }
            request.setAttribute("stations", stations);
            request.getRequestDispatcher("station-status-li.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

