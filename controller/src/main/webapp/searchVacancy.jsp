<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 14.06.2022
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<link href="css/top.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<html>
<head>
    <title>Поиск вакансии</title>
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

    <form name="searchVacancy" method="post" action="vacancy">
        Введите название компании: <input name="vacancyName" type="text" required
                                          aria-placeholder="Введите название вакансии">
        <input name="action" type="hidden" value="searchVacancy">
        <button>Найти</button>
    </form>
    <table>
        <tr>
            <th>Вакансия</th>
            <th>Статус</th>
            <th>Локация</th>
            <th>Режим работы</th>
            <th>Опыт</th>
            <th>Зарплата</th>
            <th>Уровень</th>
            <th>Уровень английского</th>
            <th>Компания</th>
            <th>Действие</th>
        </tr>
        <c:forEach var="vacancy" items="${vacanciesByName}">
            <tr>
                <td>${vacancy.name}</td>
                <td>${vacancy.status}</td>
                <td>${vacancy.location}</td>
                <td>${vacancy.workingTime}</td>
                <td>${vacancy.experience}</td>
                <td>${vacancy.salary}</td>
                <td>${vacancy.professionLevel}</td>
                <td>${vacancy.englishLevel}</td>
                <td>${vacancy.company.name}</td>
                <td>
                    <form name="info" action="vacancyInfo.jsp">
                        <input name="id" type="hidden" value="${vacancy.id}">
                        <input name="vacancyName" type="hidden" value="${vacancy.name}">
                        <input name="vacancyStatus" type="hidden" value="${vacancy.status}">
                        <input name="vacancyLocation" type="hidden" value="${vacancy.location}">
                        <input name="vacancyTime" type="hidden" value="${vacancy.workingTime}">
                        <input name="vacancyExperience" type="hidden" value="${vacancy.experience}">
                        <input name="vacancySalary" type="hidden" value="${vacancy.salary}">
                        <input name="vacancyProfessionalLevel" type="hidden" value="${vacancy.professionLevel}">
                        <input name="vacancyEnglishLevel" type="hidden" value="${vacancy.englishLevel}">
                        <input name="vacancyCompany" type="hidden" value="${vacancy.company.name}">
                        <input name="vacancyTechnology" type="hidden" value="${vacancy.technology}">
                        <button>Инфо</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
