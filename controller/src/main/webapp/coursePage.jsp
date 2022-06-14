<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 08.06.2022
  Time: 19:13
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
    <title>Курсы</title>
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
    <h2>Курсы</h2>
    <table>
        <tr>
            <th>Название курса</th>
            <th>Дата старта</th>
            <th>Дата окончания</th>
            <th>Место проведения</th>
            <th>Описание</th>
            <th>Компания</th>
            <th>Действие</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.name}</td>
                <td>${course.startDate}</td>
                <td>${course.finishDate}</td>
                <td>${course.location}</td>
                <td>${course.description}</td>
                <td>${course.company.name}</td>
                <td>
                    <form name="editCourse" method="post" action="courseForm.jsp">
                        <input name="id" type="hidden" value="${course.id}">
                        <input name="courseName" type="hidden" value="${course.name}">
                        <input name="startDate" type="hidden" value="${course.startDate}">
                        <input name="finishDate" type="hidden" value="${course.finishDate}">
                        <input name="location" type="hidden" value="${course.location}">
                        <input name="courseDescription" type="hidden" value="${course.description}">
                        <button>Изменить</button>
                    </form>
                    <form name="deleteCourse" method="post" action="course">
                        <input name="id" type="hidden" value="${course.id}">
                        <input name="action" type="hidden" value="delete">
                        <button>Удалить</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form action="courseForm.jsp">
        <button>Создать курс</button>
    </form>
</center>

</body>
</html>
