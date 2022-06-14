<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 07.06.2022
  Time: 17:52
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
    <title>Технологии</title>
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
    <h2>Технологии</h2>
    <table>
        <tr>
            <th>Название технологии</th>
            <th>Дейтсвие</th>
            <th></th>
        </tr>
        <c:forEach var="technology" items="${technologies}">
            <tr>
                <td>${technology.name}</td>
                <td>
                    <form name="editTechnology" method="post" action="technologyForm.jsp">
                        <input name="id" type="hidden" value="${technology.id}">
                        <input name="technologyName" type="hidden" value="${technology.name}">
                        <button>Изменить</button>
                    </form>
                    <form name="deleteTechnology " method="post" action="technology">
                        <input name="id" type="hidden" value="${technology.id}">
                        <input name="action" type="hidden" value="delete">
                        <button>Удалить</button>
                    </form>
                </td>
                <c:choose>
                    <c:when test="${empty param.idVacancy}">
                        <td></td>
                    </c:when>
                    <c:when test="${not empty param.idVacancy}">
                        <td>
                            <form name="addTechnology" method="post" action="vacancy">
                                <input name="idVacancy" type="hidden" value="${param.idVacancy}">
                                <input name="idTechnology" type="hidden" value="${technology.id}">
                                <input name="action" type="hidden" value="addTechnology">
                                <button>Добавить технологию</button>
                            </form>
                        </td>
                    </c:when>
                </c:choose>
            </tr>
        </c:forEach>
    </table>
    <form action="technologyForm.jsp">
        <button>Создать технологию</button>
    </form>
</center>


</body>
</html>
