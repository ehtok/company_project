<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 08.06.2022
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<link href="css/top.css" rel="stylesheet">
<link href="css/textarea.css" rel="stylesheet">
<html>
<head>
    <title>Обновление,Создание курса</title>
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
    <c:choose>
        <c:when test="${not empty param.idCompany}">
            <h2>Добавить курс ${param.companyName} компании</h2>
            <form name="addCourseToCompany" method="post" action="company" autocomplete="off">
                <input name="idCompany" type="hidden" value="${param.idCompany}">
                Название курса: <label>
                <input name="courseName" type="text" required aria-placeholder="Название курса">
            </label><br/>
                Дата старта: <label>
                <input name="startDate" type="date">
            </label><br/>
                Дата окончания: <label>
                <input name="finishDate" type="date">
            </label><br/>
                Место проведения: <label>
                <input name="location" type="text" required aria-placeholder="Место проведения">
            </label><br/>
                Описание курса: <label>
                <textarea name="courseDescription" required></textarea>
            </label><br/>
                <input name="action" type="hidden" value="addCourse">
                <button>Создать</button>
            </form>
        </c:when>
        <c:when test="${empty param.id}">
            <h2>Создание Курса</h2>
            <form name="addCourse" method="post" action="course" autocomplete="off">
                Название курса: <label>
                <input name="courseName" type="text" required aria-placeholder="Название курса">
            </label><br/>
                Дата старта: <label>
                <input name="startDate" type="date">
            </label><br/>
                Дата окончания: <label>
                <input name="finishDate" type="date">
            </label><br/>
                Место проведения: <label>
                <input name="location" type="text" required aria-placeholder="Место проведения">
            </label><br/>
                Описание курса: <label>
                <textarea name="courseDescription" required></textarea>
            </label><br/>
                <input name="action" type="hidden" value="add">
                <button>Создать</button>
            </form>
        </c:when>

        <c:when test="${not empty param.id}">
            <form name="editCourse" method="post" action="course" autocomplete="off">
                <input name="id" type="hidden" value="${param.id}">
                Название курса: <label>
                <input name="courseName" type="text" value="${param.courseName}">
            </label><br/>
                Дата старта: <label>
                <input name="startDate" type="date" value="${param.startDate}">
            </label><br/>
                Дата окончания: <label>
                <input name="finishDate" type="date" value="${param.finishDate}">
            </label><br/>
                Место проведения: <label>
                <input name="location" type="text" value="${param.location}">
            </label><br/>
                Описание курса: <label>
                <textarea name="courseDescription">${param.courseDescription}</textarea>
            </label><br/>
                <input name="action" type="hidden" value="update">
                <button>Обновить</button>
            </form>
        </c:when>
    </c:choose>
</center>

</body>
</html>
