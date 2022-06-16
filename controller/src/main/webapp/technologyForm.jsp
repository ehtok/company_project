<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 08.06.2022
  Time: 16:09
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
    <title>Обновление, Создание технологии</title>
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
        <c:if test="${empty param.id}">
            <h2>Создать Технологию</h2>
            <form name="addTechnology" method="post" action="technology" autocomplete="off">
                Название технологии: <label>
                <input name="technologyName" type="text" required aria-placeholder="Название компании">
            </label><br/>
                <input name="action" type="hidden" value="add">
                <button>Создать</button>
            </form>
        </c:if>
        <c:if test="${not empty param.id}">
            <h2>Обновить Технологию</h2>
            <form name="updateTechnology" method="post" action="technology">
                Название компании: <label>
                <input name="id" type="hidden" value="${param.id}">
                <input name="technologyName" type="text" value="${param.technologyName}">
            </label><br/>
                <input name="action" type="hidden" value="update">
                <button>Обновить</button>
            </form>
        </c:if>
    </center>
</div>
</body>
</html>
