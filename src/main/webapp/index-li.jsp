<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--STRONA GŁÓWNA - ADMINISTRATOR
Jest to domyślna strona wyświetlająca podstawowe informacje
zachęcające do oddawania krwi.
------------------------------------------------------------
Wszystkie strony dostępne dla administratora umożliwiają przejście
do strony głównej, do strony wyświetlającej stan stacji
zawartych w bazie danych, oraz wylogowanie się. --%>

<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Serwis krwiodawstwa</title>
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
<h1>Witaj w serwisie krwiodawstwa!</h1>
<svg class="wave" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#DC143CFF" fill-opacity="1" d="M0,32L24,58.7C48,85,96,139,144,154.7C192,171,240,149,288,117.3C336,85,384,43,432,64C480,85,528,171,576,186.7C624,203,672,149,720,138.7C768,128,816,160,864,154.7C912,149,960,107,1008,106.7C1056,107,1104,149,1152,165.3C1200,181,1248,171,1296,149.3C1344,128,1392,96,1416,80L1440,64L1440,320L1416,320C1392,320,1344,320,1296,320C1248,320,1200,320,1152,320C1104,320,1056,320,1008,320C960,320,912,320,864,320C816,320,768,320,720,320C672,320,624,320,576,320C528,320,480,320,432,320C384,320,336,320,288,320C240,320,192,320,144,320C96,320,48,320,24,320L0,320Z"></path></svg>
<br/>
<main>
    <div id="wrapper">
        <div class="standardText">
            <p>Oddawanie krwi jest jednym z największych darów, jakie można dać innym ludziom. Każdej minuty potrzebna jest krew, aby pomóc pacjentom w szpitalach, którzy wymagają transfuzji. Krwiodawstwo jest również kluczowe w przypadku poważnych wypadków lub katastrof, kiedy ilość krwi w szpitalach szybko się kurczy. Oddanie jednej jednostki krwi może uratować życie lub poprawić stan zdrowia nawet trzech osób. Warto więc oddawać krew, ponieważ to prosty i bezpieczny sposób na pomaganie innym oraz na uczestniczenie w ratowaniu ludzkich żyć.</p>
        </div>
        <br>
        <div class="joinUs">
            <a href="station-status-li-redirect">Zobacz gdzie jesteś potrzebny i podaruj życie!</a>
        </div>
        <img src="images/blood_in_page.svg" class="sideDrop-1">
        <img src="images/blood_in_page.svg" class="sideDrop-2">
    </div>
</main>
</body>
</html>