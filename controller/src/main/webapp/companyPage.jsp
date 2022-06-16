<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 05.06.2022
  Time: 12:24
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
    <title>Компании</title>
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
        <h2>Компании</h2>
        <table>
            <tr>
                <th>Название компании</th>
                <th>Описание</th>
                <th>Размер компании</th>
                <th>Тип компании</th>
                <th>Действие</th>
                <th></th>
            </tr>
            <c:forEach var="company" items="${companies}">
                <tr>
                    <td>${company.name}</td>
                    <td>${company.description}</td>
                    <td>${company.companySize}</td>
                    <td>${company.companyType}</td>
                    <td>
                        <form name="editCompany" method="post" action="companyForm.jsp">
                            <input name="id" type="hidden" value="${company.id}">
                            <input name="companyName" type="hidden" value="${company.name}">
                            <input name="companySize" type="hidden" value="${company.companySize}">
                            <input name="companyType" type="hidden" value="${company.companyType}">
                            <input name="companyDescription" type="hidden" value="${company.description}">
                            <button>Изменить</button>
                        </form>

                        <form name="deleteCompany" method="post" action="company">
                            <input name="id" type="hidden" value="${company.id}">
                            <input name="action" type="hidden" value="delete">
                            <button>Удалить</button>
                        </form>
                        <form name="companyInfo" action="companyInfo.jsp">
                            <input name="companyName" type="hidden" value="${company.name}">
                            <input name="companySize" type="hidden" value="${company.companySize}">
                            <input name="companyType" type="hidden" value="${company.companyType}">
                            <input name="companyDescription" type="hidden" value="${company.description}">
                            <input name="companyVacancy" type="hidden" value="${company.vacancy}">
                            <input name="companyCourse" type="hidden" value="${company.course}">
                            <button>Инфо</button>
                        </form>
                    </td>
                    <td>
                        <form name="addVacancyToCompany" action="vacancyForm.jsp">
                            <input name="idCompany" type="hidden" value="${company.id}">
                            <input name="companyName" type="hidden" value="${company.name}">
                            <button>Добавить вакансию</button>
                        </form>

                        <form name="addCourseToCompany" action="courseForm.jsp">
                            <input name="idCompany" type="hidden" value="${company.id}">
                            <input name="companyName" type="hidden" value="${company.name}">
                            <button>Добавить курс</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</div>
<div>
    <center>
        <form action="companyForm.jsp">
            <button>Создать компанию</button>
        </form>
        <form action="searchCompany.jsp">
            <button>Найти компанию</button>
        </form>
    </center>
</div>

</body>
</html>
