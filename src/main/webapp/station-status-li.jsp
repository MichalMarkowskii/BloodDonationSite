<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--STRONA SZCZEGÓŁÓW I STATUSU STACJI - ADMINISTRATOR
Jest to strona wyświetlająca aktualne dane oraz status krwi wszystkich lub tylko wyszukanych stacji.
Dodatkowo z widoku stronu możliwe jest przejście do edycji stacji lub do formularza dodawania nowej stacji. --%>

<!DOCTYPE html>
<html lang="pl">
<head>
  <title>Status stacji</title>
  <link rel="icon", type="image/x-icon" href="images/blood.png">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
  <style> a {text-decoration: none; color: black}</style>
</head>
<div class="whitebox">
  <div class="whiteplaceholderbox"></div>
  <a href="index-li.jsp">Strona główna</a>&emsp;&emsp;&emsp;
  <a href="station-status-li-redirect">Zobacz status</a>&emsp;&emsp;&emsp;
  <a href="logout" style="color: crimson">Wyloguj się</a>
</div>
<div class="placeholderbox"></div>
<body>
<h1>Sprawdź zapotrzebowanie placówek w Polsce</h1>
<main>
  <div id="wrapper">
    <form action="add-station.jsp">
      <input type="submit" value="Dodaj nową stację" class="button"><br><br><br>
    </form>
    <form method="get" action="search-li">
      <input type="text" name="searchQuery" placeholder="Wyszukaj...">
      <button type="submit" class="button">Wyszukaj</button>
    </form><br><br><br>
    <div class="tab">
      <% int tabcount = -250; %>
      <c:forEach items="${stations}" var="station">
        <table rules="all" class="tab tab-1" style="width: 1000px;">
          <thead>
            <tr>
              <th>RCKiK</th>
              <th>Adres</th>
              <th>Miasto</th>
              <th>Telefon</th>
              <th>Adres URL</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td ><c:out value="${station.rckik}"/></td>
              <td><c:out value="${station.adress}"/></td>
              <td><c:out value="${station.city}"/></td>
              <td><c:out value="${station.phone}"/></td>
              <td><a style="text-decoration-line: underline" href="<c:out value="${station.url}"/>"><c:out value="${station.url}"/></a></td>
            </tr>
          </tbody>
        </table>
        <table rules="all" class="tab" style="width: 1000px">
          <thead>
            <th colspan="8">Stan krwi</th><br>
          </thead>
          <tbody>
            <tr>
              <th>0 Rh+</th>
              <th>A Rh+</th>
              <th>B Rh+</th>
              <th>AB Rh+</th>
              <th>0 Rh-</th>
              <th>A Rh-</th>
              <th>B Rh-</th>
              <th>AB Rh-</th>
            </tr>
            <tr>
              <c:forEach items="${station.statuses}" var="status">
                <td><c:out value="${status}"/></td>
              </c:forEach>
            </tr>
          </tbody>
        </table><br>
        <form style="display: inline-block" action="update-station-redirect">
          <input type="hidden" name="stationId" value="${station.id}">
          <input type="submit" class="button" value="Edytuj dane">
        </form>
        <form style="display: inline-block" action="update-blood-redirect">
          <input type="hidden" name="stationId" value="${station.id}">
          <input type="submit" class="button" value="Edytuj status krwi">
        </form>
        <br><br><br><br>
        <% tabcount += 307; %>
      </c:forEach>
    </div>
  </div>
</main>
</body>
<% if (tabcount == 200) {tabcount = 0;} %>
<svg class="wave-statusPage" style="position: absolute; left: 0px; bottom: <%= -tabcount %>px; width: 100%;" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#DC143CFF" fill-opacity="1" d="M0,32L24,58.7C48,85,96,139,144,154.7C192,171,240,149,288,117.3C336,85,384,43,432,64C480,85,528,171,576,186.7C624,203,672,149,720,138.7C768,128,816,160,864,154.7C912,149,960,107,1008,106.7C1056,107,1104,149,1152,165.3C1200,181,1248,171,1296,149.3C1344,128,1392,96,1416,80L1440,64L1440,320L1416,320C1392,320,1344,320,1296,320C1248,320,1200,320,1152,320C1104,320,1056,320,1008,320C960,320,912,320,864,320C816,320,768,320,720,320C672,320,624,320,576,320C528,320,480,320,432,320C384,320,336,320,288,320C240,320,192,320,144,320C96,320,48,320,24,320L0,320Z"></path></svg>
</html>