<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 13.06.2022
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<link href="css/top.css" rel="stylesheet">
<html>
<head>
    <title>Инфо о вакансии ${param.vacancyName}</title>
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
<h2>${param.vacancyName}</h2>
<div>
    <td>Статус вакансии: ${param.vacancyStatus}</td>
    <br/>
    <td>Локация: ${param.vacancyLocation}</td>
    <br/>
    <td>Рабочее время: ${param.vacancyTime}</td>
    <br/>
    <td>Опыт: ${param.vacancyExperience}</td>
    <br/>
    <td>Зарплата: ${param.vacancySalary}</td>
    <br/>
    <td>Уровень: ${param.vacancyProfessionalLevel}</td>
    <br/>
    <td>Уровень языка: ${param.vacancyEnglishLevel}</td>
    <br/>
    <td>Компания: ${param.vacancyCompany}</td>
    <br/>
    <td>Стек технологии: ${param.vacancyTechnology}</td>
    <br/>
</div>
<div>
<form action="vacancy">
    <button>Назад</button>
</form>
</div>
</body>
</html>
