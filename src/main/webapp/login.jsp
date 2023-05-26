<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--STRONA LOGOWANIA - UŻYTKOWNIK NIEZALOGOWANY
Jest to strona wyświetlająca formularz umożliwiający zalogowanie się. --%>

<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
<link rel="icon", type="image/x-icon" href="images/blood.png">
<body>
<head>
    <title>Zaloguj się</title>
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
<h1>Zaloguj się!</h1>
<p style="color: crimson">${infoFail}</p>
<svg class="wave" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#DC143CFF" fill-opacity="1" d="M0,32L24,58.7C48,85,96,139,144,154.7C192,171,240,149,288,117.3C336,85,384,43,432,64C480,85,528,171,576,186.7C624,203,672,149,720,138.7C768,128,816,160,864,154.7C912,149,960,107,1008,106.7C1056,107,1104,149,1152,165.3C1200,181,1248,171,1296,149.3C1344,128,1392,96,1416,80L1440,64L1440,320L1416,320C1392,320,1344,320,1296,320C1248,320,1200,320,1152,320C1104,320,1056,320,1008,320C960,320,912,320,864,320C816,320,768,320,720,320C672,320,624,320,576,320C528,320,480,320,432,320C384,320,336,320,288,320C240,320,192,320,144,320C96,320,48,320,24,320L0,320Z"></path></svg>
<main>
    <div id="wrapper">
        <form method="post" action="login">
            <input type="email" id="email" name="email" placeholder="Adres e-mail"><br><br>
            <input type="password" id="password" name="password" placeholder="Hasło"><br><br>
            <input type="submit" value="Zaloguj się" class="button">
        </form>
    </div>
</main>
</body></html>
</body>
</html>
