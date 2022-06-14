<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 05.06.2022
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<link href="css/top.css" rel="stylesheet">
<link href="css/textarea.css" rel="stylesheet">
<html>
<head>
    <title>Обновление,Создание компании</title>
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
    <c:if test="${empty param.id}">
        <h2>Создать Компанию</h2>
        <form name="addCompany" method="post" action="company" autocomplete="off">
            Название компании: <label>
            <input name="companyName" type="text" required aria-placeholder="Название компании">
        </label><br/>
            Размер компании: <label>
            <input name="companySize" type="text" required aria-placeholder="Размер компании">
        </label><br/>
            Тип компании: <select name="companyType">
            <option selected>Выберете тип</option>
            <option value="Product">Product</option>
            <option value="Start-up">Start Up</option>
        </select><br/>
            Описание компании: <label>
            <textarea name="companyDescription" required></textarea>
        </label><br/>
            <input name="action" type="hidden" value="add">
            <button>Создать</button>
        </form>
    </c:if>

    <c:if test="${not empty param.id}">
        <h2>Изменить Компанию</h2>
        <form name="updateCompany" method="post" action="company">
            Название компании: <label>
            <input name="id" type="hidden" value="${param.id}">
            <input name="companyName" type="text" value="${param.companyName}">
        </label><br/>
            Размер компании: <label>
            <input name="companySize" type="text" value="${param.companySize}">
        </label><br/>
            Тип компании:<label>
            <select name="companyType">
                <option selected>${param.companyType}</option>
                <option value="Product">Product</option>
                <option value="Start-up">Start Up</option>
            </select>
        </label><br/>
            Описание компании: <label>
            <textarea name="companyDescription" required>${param.companyDescription}</textarea>
        </label><br/>
            <input name="action" type="hidden" value="update">
            <button>Обновить</button>
        </form>
    </c:if>
</center>
<form action="company">
    <button>Назад</button>
</form>

</body>
</html>
