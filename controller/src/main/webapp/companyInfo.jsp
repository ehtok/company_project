<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 16.06.2022
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<link href="css/top.css" rel="stylesheet">
<html>
<head>
    <title>Инфо о компании ${param.companyName}</title>
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
<h2>${param.companyName}</h2>
<div>
    <td>Размер компании: ${param.companySize}</td>
    <br/>
    <td>Тип компании: ${param.companyType}</td>
    <br/>
    <td>Вакансии: ${param.companyVacancy}</td>
    <br/>
    <td>Курсы: ${param.companyCourse}</td>
    <br/>
    <td>О компании: ${param.companyDescription}</td>
    <br/>
</div>
<div>
    <form action="company">
        <button>Назад</button>
    </form>
</div>
</body>
</html>
