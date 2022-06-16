package Servlet;

import DTO.VacancyDTO;
import Service.VacancyService;
import Service.implement.VacancyServiceImpl;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static Сonstant.Constants.*;

@WebServlet(name = "VacancyServlet", value = "/vacancy")
public class VacancyServlet extends HttpServlet {

    private VacancyService vacancyService = new VacancyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<VacancyDTO> vacancyList = vacancyService.findAllVacancy();
        req.setAttribute(VACANCIES_ATT, vacancyList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VACANCY_PAGE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter(ACTION);

        switch (action) {
            case ADD -> addVacancy(req, resp);
            case UPDATE -> updateVacancy(req, resp);
            case DELETE -> deleteVacancy(req, resp);
            case ADD_TECHNOLOGY -> addTechnologyToVacancy(req, resp);
            case SEARCH_VACANCY -> searchVacancyByName(req, resp);

        }

    }

    private void addVacancy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(VACANCY_NAME);
        String time = req.getParameter(VACANCY_TIME);
        String experience = req.getParameter(VACANCY_EXPERIENCE);
        String englishLevel = req.getParameter(VACANCY_ENGLISH_LEVEL);
        String professionalLevel = req.getParameter(VACANCY_PROFESSIONAL_LEVEL);
        String location = req.getParameter(VACANCY_LOCATION);
        String salary = req.getParameter(VACANCY_SALARY);
        String status = req.getParameter(VACANCY_STATUS);

        vacancyService.saveVacancy(name, time, experience, location, englishLevel, professionalLevel, salary, status);
        resp.sendRedirect(URL_VACANCY);
    }

    private void updateVacancy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID));
        String name = req.getParameter(VACANCY_NAME);
        String time = req.getParameter(VACANCY_TIME);
        String experience = req.getParameter(VACANCY_EXPERIENCE);
        String englishLevel = req.getParameter(VACANCY_ENGLISH_LEVEL);
        String professionalLevel = req.getParameter(VACANCY_PROFESSIONAL_LEVEL);
        String location = req.getParameter(VACANCY_LOCATION);
        String salary = req.getParameter(VACANCY_SALARY);
        String status = req.getParameter(VACANCY_STATUS);
        vacancyService.updateVacancy
                (id, name, time, experience, location, englishLevel, professionalLevel, salary, status);
        resp.sendRedirect(URL_VACANCY);
    }

    private void deleteVacancy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID));
        vacancyService.deleteVacancy(id);
        resp.sendRedirect(URL_VACANCY);
    }

    private void addTechnologyToVacancy(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer idVacancy = Integer.valueOf(req.getParameter(ID_VACANCY));
        Integer idTechnology = Integer.valueOf(req.getParameter(ID_TECHNOLOGY));
        String page;
        try {
            vacancyService.addTechnologyToVacancy(idVacancy, idTechnology);
            page = URL_VACANCY;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            page = TECHNOLOGY_ERROR_1_JSP;
        }
        resp.sendRedirect(page);
    }

    private void searchVacancyByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter(VACANCY_NAME);
        try {
            List<VacancyDTO> vacancyList = vacancyService.findVacancyByName(name);
            req.setAttribute(ATT_VACANCIES_BY_NAME, vacancyList);
            req.getRequestDispatcher(SEARCH_VACANCY_JSP).forward(req, resp);
        } catch (NoResultException e) {
            e.printStackTrace();
            resp.sendRedirect(VACANCY_PAGE_JSP);
        }
    }


}
