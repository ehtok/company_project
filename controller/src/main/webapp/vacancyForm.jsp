<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 06.06.2022
  Time: 08:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<link href="css/top.css" rel="stylesheet">
<html>
<head>
    <title>Обновление, Создание вакансии</title>
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
            <h2>Добавить вакансию ${param.companyName} компании</h2>
            <form name="addVacancyToCompany" method="post" action="company" autocomplete="off">
                <input name="idCompany" type="hidden" value="${param.idCompany}">
                Название вакансии: <label>
                <input name="vacancyName" type="text" required aria-placeholder="Название вакансии">
            </label><br/>
                Статус вакансии: <select name="vacancyStatus">
                <option selected>Выберете тип</option>
                <option value="открыта">открыта</option>
                <option value="закрыта">закрыта</option>
            </select><br/>
                Локация: <label>
                <input name="vacancyLocation" type="text" required aria-placeholder="Локация">
            </label><br/>
                Режим работы: <select name="vacancyTime">
                <option selected>Выберете тип</option>
                <option value="Полный день">Полный день</option>
                <option value="Неполный день">Неполный день</option>
                <option value="Возможна удалённая работа">Возможна удалённая работа</option>
            </select><br/>
                Опыт: <label>
                <input name="vacancyExperience" type="text" required aria-placeholder="Опыт">
            </label><br/>
                Зарплата: <label>
                <input name="vacancySalary" type="text" required aria-placeholder="Зарплата">
            </label><br/>
                Уровень: <label>
                <input name="vacancyProfessionalLevel" type="text" required aria-placeholder="Уровень">
            </label><br/>
                Уровень английского: <label>
                <input name="vacancyEnglishLevel" type="text" required aria-placeholder="Уровень английского">
            </label><br/>
                <input name="action" type="hidden" value="addVacancy">
                <button>Создать</button>
            </form>
        </c:when>
        <c:when test="${empty param.id}">
            <h2>Создать Вакансию</h2>
            <form name="addVacancy" method="post" action="vacancy" autocomplete="off">
                Название вакансии: <label>
                <input name="vacancyName" type="text" required aria-placeholder="Название вакансии">
            </label><br/>
                Статус вакансии: <select name="vacancyStatus">
                <option selected>Выберете тип</option>
                <option value="открыта">открыта</option>
                <option value="закрыта">закрыта</option>
            </select><br/>
                Локация: <label>
                <input name="vacancyLocation" type="text" required aria-placeholder="Локация">
            </label><br/>
                Режим работы: <select name="vacancyTime">
                <option selected>Выберете тип</option>
                <option value="Полный день">Полный день</option>
                <option value="Неполный день">Неполный день</option>
                <option value="Возможна удалённая работа">Возможна удалённая работа</option>
            </select><br/>
                Опыт: <label>
                <input name="vacancyExperience" type="text" required aria-placeholder="Опыт">
            </label><br/>
                Зарплата: <label>
                <input name="vacancySalary" type="text" required aria-placeholder="Зарплата">
            </label><br/>
                Уровень: <label>
                <input name="vacancyProfessionalLevel" type="text" required aria-placeholder="Уровень">
            </label><br/>
                Уровень английского: <label>
                <input name="vacancyEnglishLevel" type="text" required aria-placeholder="Уровень английского">
            </label><br/>
                <input name="action" type="hidden" value="add">
                <button>Создать</button>
            </form>
        </c:when>
        <c:when test="${not empty param.id}">
            <h2>Изменить Вакансию</h2>
            <form name="updateVacancy" method="post" action="vacancy" autocomplete="off">
                Название вакансии: <label>
                <input name="id" type="hidden" value="${param.id}">
                <input name="vacancyName" type="text" value="${param.vacancyName}">
            </label><br/>
                Статус вакансии: <select name="vacancyStatus">
                <option selected>${param.vacancyStatus}</option>
                <option value="открыта">открыта</option>
                <option value="закрыта">закрыта</option>
            </select><br/>
                Локация: <label>
                <input name="vacancyLocation" type="text" value="${param.vacancyLocation}">
            </label><br/>
                Режим работы: <select name="vacancyTime">
                <option selected>${param.vacancyTime}</option>
                <option value="Полный день">Полный день</option>
                <option value="Неполный день">Неполный день</option>
                <option value="Возможна удалённая работа">Возможна удалённая работа</option>
            </select><br/>
                Опыт: <label>
                <input name="vacancyExperience" type="text" value="${param.vacancyExperience}">
            </label><br/>
                Зарплата: <label>
                <input name="vacancySalary" type="text" value="${param.vacancySalary}">
            </label><br/>
                Уровень: <label>
                <input name="vacancyProfessionalLevel" type="text" value="${param.vacancyProfessionalLevel}">
            </label><br/>
                Уровень английского: <label>
                <input name="vacancyEnglishLevel" type="text" value="${param.vacancyEnglishLevel}">
            </label><br/>
                <input name="action" type="hidden" value="update">
                <button>Обновить</button>
            </form>
        </c:when>
    </c:choose>
</center>
</body>
</html>
