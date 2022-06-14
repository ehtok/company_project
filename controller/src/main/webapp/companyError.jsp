<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 13.06.2022
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/top.css" rel="stylesheet">
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
<footer>
    <ul class="menu-main">
        <li><a href="index.jsp" class="current">Главная</a></li>
        <li><a href="company">Компании</a></li>
        <li><a href="vacancy">Вакансии</a></li>
        <li><a href="course">Курсы</a></li>
        <li><a href="technology">Технологии</a></li>
    </ul>
</footer>

<center>
    <h2>Упс!</h2>
    <h2>Компания не найдена! Введите корректное название!</h2>
</center>
<form action="searchCompany.jsp">
    <button>Назад</button>
</form>
</body>
</html>
