<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--STRONA EDYCJI STATUSU STACJI - ADMINISTRATOR
Jest to strona wyświetlająca formularz umożliwiający edycje aktualnego statusu poszczególnych grup krwi
dla danej stacji. --%>

<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
<link rel="icon", type="image/x-icon" href="images/blood.png">
<head>
    <title>Zaktualizuj stan krwi</title>
    <style> a {text-decoration: none; color: black}</style>
</head>
<body>
<div class="placeholderbox"></div>
<div class="whitebox">
    <div class="whiteplaceholderbox"></div>
    <a href="index-li.jsp">Strona główna</a>&emsp;&emsp;&emsp;
    <a href="station-status-li-redirect">Zobacz status</a>&emsp;&emsp;&emsp;
    <a href="logout" style="color: crimson">Wyloguj się</a>
</div>
<svg class="wave" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#DC143CFF" fill-opacity="1" d="M0,32L24,58.7C48,85,96,139,144,154.7C192,171,240,149,288,117.3C336,85,384,43,432,64C480,85,528,171,576,186.7C624,203,672,149,720,138.7C768,128,816,160,864,154.7C912,149,960,107,1008,106.7C1056,107,1104,149,1152,165.3C1200,181,1248,171,1296,149.3C1344,128,1392,96,1416,80L1440,64L1440,320L1416,320C1392,320,1344,320,1296,320C1248,320,1200,320,1152,320C1104,320,1056,320,1008,320C960,320,912,320,864,320C816,320,768,320,720,320C672,320,624,320,576,320C528,320,480,320,432,320C384,320,336,320,288,320C240,320,192,320,144,320C96,320,48,320,24,320L0,320Z"></path></svg>
<div class="update">
    <h1>Zaktualizuj stan krwi</h1>
    <p>Edytowane centrum: <b>${station.rckik}</b></p>
    <form action="commit-blood-update">
        <% int i = 0; String bloodTypes[] = new String[]{"0 Rh+", "A Rh+", "B Rh+", "AB Rh+", "0 Rh-", "A Rh-", "B Rh-", "AB Rh-"}; %>
        <c:forEach items="${station.statuses}" var="status">
            <label for="<%= bloodTypes[i] %>"><%= bloodTypes[i] %> :</label>
            <select name="<%= bloodTypes[i] %>">
                <option <c:if test="${status == 'bardzo niski'}">selected</c:if> value="bardzo niski">bardzo niski</option>
                <option <c:if test="${status == 'niski'}">selected</c:if> value="niski">niski</option>
                <option <c:if test="${status == 'średni'}">selected</c:if> value="średni">średni</option>
                <option <c:if test="${status == 'wysoki'}">selected</c:if> value="wysoki">wysoki</option>
            </select><br><br>
            <% i++; %>
        </c:forEach><br>
        <input type="submit" value="Zatwierdź zmiany" class="button"><br><br>
        <input type="hidden" name="id" value="${station.id}">
    </form>
</div>
</body>
</html>
