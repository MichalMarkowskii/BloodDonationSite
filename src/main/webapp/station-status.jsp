<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--STRONA STATUSU STACJI - UŻYTKOWNIK NIEZALOGOWANY
Jest to strona wyświetlająca aktualny status krwi wszystkich lub tylko wyszukanych stacji. --%>

<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Status stacji</title>
    <link rel="icon", type="image/x-icon" href="images/blood.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css"/>
    <style> a {text-decoration: none; color: black}</style>
</head>
<div class="whitebox">
    <div class="whiteplaceholderbox"></div>
    <a href="index.jsp">Strona główna</a>&emsp;&emsp;&emsp;
    <a href="login.jsp">Zaloguj się</a>&emsp;&emsp;&emsp;
    <a href="register.jsp">Zarejestruj się</a>&emsp;&emsp;&emsp;
    <a href="station-status-redirect">Zobacz status</a>
</div>
<div class="placeholderbox"></div>
<body>
<h1>Sprawdź zapotrzebowanie placówek w Polsce</h1>
<main>
    <div id="wrapper">
        <form method="get" action="search">
            <input type="text" name="searchQuery" placeholder="Wyszukaj...">
            <button type="submit" class="button">Wyszukaj</button>
        </form><br><br><br>
        <% int tabcount = -250; %>
        <c:forEach items="${stations}" var="station">
            <% int i = 0;
            String bloodTypes[] = new String[]{"0 Rh+", "A Rh+", "B Rh+", "AB Rh+", "0 Rh-", "A Rh-", "B Rh-", "AB Rh-"}; %>
            <div class="bloodDrops" style="width: 1300px; position: relative"><br>
                <form action="station-details">
                    <input type="hidden" name="stationId" value="${station.id}">
                    <input type="submit" class="details-b" value="${station.rckik}">
                </form><br><br>
                <c:forEach items="${station.statuses}" var="status">
                <div class="singleDrop" style="display: inline-block; width: 140px">
                    <c:if test="${status == 'wysoki'}">
                        <img src="images/high.png", class="drop">
                    </c:if>
                    <c:if test="${status == 'średni'}">
                        <img src="images/medium.png", class="drop">
                    </c:if>
                    <c:if test="${status == 'niski'}">
                        <img src="images/low.png", class="drop">
                    </c:if>
                    <c:if test="${status == 'bardzo niski'}">
                        <img src="images/veryLow.png", class="drop">
                    </c:if>
                    <p>Stan ${status}</p>
                    <p><%= bloodTypes[i] %></p>
                    <% i++; %>
                </div>&emsp;
                </c:forEach>
            </div><br><br><br>
            <%  tabcount += 267; %>
        </c:forEach>
    </div>
</main>
</body>
<% if (tabcount == -250) {tabcount = 0;} %>
<svg class="wave-statusPage" style="position: absolute; left: 0px; bottom: <%= -tabcount %>px; width: 100%;" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#DC143CFF" fill-opacity="1" d="M0,32L24,58.7C48,85,96,139,144,154.7C192,171,240,149,288,117.3C336,85,384,43,432,64C480,85,528,171,576,186.7C624,203,672,149,720,138.7C768,128,816,160,864,154.7C912,149,960,107,1008,106.7C1056,107,1104,149,1152,165.3C1200,181,1248,171,1296,149.3C1344,128,1392,96,1416,80L1440,64L1440,320L1416,320C1392,320,1344,320,1296,320C1248,320,1200,320,1152,320C1104,320,1056,320,1008,320C960,320,912,320,864,320C816,320,768,320,720,320C672,320,624,320,576,320C528,320,480,320,432,320C384,320,336,320,288,320C240,320,192,320,144,320C96,320,48,320,24,320L0,320Z"></path></svg>
</html>