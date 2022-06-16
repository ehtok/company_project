<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 05.06.2022
  Time: 23:56
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
    <title>Вакансии</title>
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
<div>
    <center>
        <h2>Вакансии</h2>
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
                <th></th>
            </tr>

            <c:forEach var="vacancy" items="${vacancies}">
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
                        <form name="editVacancy" method="post" action="vacancyForm.jsp">
                            <input name="id" type="hidden" value="${vacancy.id}">
                            <input name="vacancyName" type="hidden" value="${vacancy.name}">
                            <input name="vacancyStatus" type="hidden" value="${vacancy.status}">
                            <input name="vacancyLocation" type="hidden" value="${vacancy.location}">
                            <input name="vacancyTime" type="hidden" value="${vacancy.workingTime}">
                            <input name="vacancyExperience" type="hidden" value="${vacancy.experience}">
                            <input name="vacancySalary" type="hidden" value="${vacancy.salary}">
                            <input name="vacancyProfessionalLevel" type="hidden" value="${vacancy.professionLevel}">
                            <input name="vacancyEnglishLevel" type="hidden" value="${vacancy.englishLevel}">
                            <button>Изменить</button>
                        </form>
                        <form name="deleteVacancy" method="post" action="vacancy">
                            <input name="id" type="hidden" value="${vacancy.id}">
                            <input name="action" type="hidden" value="delete">
                            <button>Удалить</button>
                        </form>
                        <form name="info" action="vacancyInfo.jsp">
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
                    <td>
                        <form name="addTechnologyToVacancy" action="technology">
                            <input name="idVacancy" type="hidden" value="${vacancy.id}">
                            <button>Добавить технологии</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</div>
<div>
    <center>
        <form action="vacancyForm.jsp">
            <button>Создать вакансию</button>
        </form>
        <form action="searchVacancy.jsp">
            <button>Поиск вакансии</button>
        </form>
    </center>
</div>

</body>
</html>
