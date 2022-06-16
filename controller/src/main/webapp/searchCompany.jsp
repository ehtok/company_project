<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 13.06.2022
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<link href="css/top.css" rel="stylesheet">
<html>
<head>
    <title>Поиск компании</title>
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
        <form name="searchCompany" method="post" action="company">
            Введите название компании: <input name="companyName" type="text" required
                                              aria-placeholder="Введите название">
            <input name="action" type="hidden" value="searchCompany">
            <button>Найти</button>
        </form>
    </center>
</div>
<div>
    <c:set var="company" value="${requestScope.company}"/>
    <c:if test="${ empty company.id}">
        <td></td>
    </c:if>
    <c:if test="${not empty company.id}">
        <td>Название компании: <c:out value="${company.name}"/></td>
        <br/>
        <td>Размер компании: <c:out value="${company.companySize}"/></td>
        <br/>
        <td>Тип компании: <c:out value="${company.companyType}"/></td>
        <br/>
        <td>Описание компании: <c:out value="${company.description}"/></td>
        <br/>
        <td>Вакансии компании: <c:out value="${company.vacancy}"/></td>
        <br/>
        <td>Курсы компании: <c:out value="${company.course}"/></td>
    </c:if>
</div>

</body>
</html>
