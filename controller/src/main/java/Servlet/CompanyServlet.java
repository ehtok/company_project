package Servlet;

import DTO.CompanyDTO;
import Service.CompanyService;
import Service.implement.CompanyServiceImpl;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static Сonstant.Constants.*;

@WebServlet(name = "CompanyServlet", value = "/company")
public class CompanyServlet extends HttpServlet {



    private CompanyService companyService = new CompanyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CompanyDTO> companyList = companyService.findAllCompany();
        req.setAttribute(COMPANIES_ATT, companyList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(COMPANY_PAGE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);
        switch (action) {
            case ADD:
                saveCompany(req, resp);
                break;
            case UPDATE:
                updateCompany(req, resp);
                break;
            case DELETE:
                deleteCompany(req, resp);
                break;
            case ADD_VACANCY:
                addVacancyToCompany(req, resp);
                break;
            case ADD_COURSE:
                addCourseToCompany(req, resp);
                break;
            case SEARCH_COMPANY:
                searchCompany(req, resp);
                break;
        }
    }

    private void saveCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(NAME_COMPANY);
        String size = req.getParameter(SIZE_COMPANY);
        String type = req.getParameter(TYPE_COMPANY);
        String description = req.getParameter(DESCRIPTION_COMPANY);
        companyService.saveCompany(name, size, type, description);
        resp.sendRedirect(COMPANY_URL);
    }

    private void updateCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID));
        String name = req.getParameter(NAME_COMPANY);
        String size = req.getParameter(SIZE_COMPANY);
        String type = req.getParameter(TYPE_COMPANY);
        String description = req.getParameter(DESCRIPTION_COMPANY);
        companyService.updateCompany(id, name, size, type, description);
        resp.sendRedirect(COMPANY_URL);
    }

    private void deleteCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID));
        companyService.deleteCompany(id);
        resp.sendRedirect(COMPANY_URL);
    }

    private void addVacancyToCompany(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID_COMPANY));
        String name = req.getParameter(VACANCY_NAME);
        String time = req.getParameter(VACANCY_TIME);
        String experience = req.getParameter(VACANCY_EXPERIENCE);
        String englishLevel = req.getParameter(VACANCY_ENGLISH_LEVEL);
        String professionalLevel = req.getParameter(VACANCY_PROFESSIONAL_LEVEL);
        String location = req.getParameter(VACANCY_LOCATION);
        String salary = req.getParameter(VACANCY_SALARY);
        String status = req.getParameter(VACANCY_STATUS);
        companyService.addVacancyToCompany(id, name, time, experience,
                location, englishLevel, professionalLevel, salary, status);
        resp.sendRedirect(URL_VACANCY);
    }

    private void addCourseToCompany(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID_COMPANY));
        String name = req.getParameter(NAME_COURSE);
        String description = req.getParameter(COURSE_DESCRIPTION);
        LocalDate startDate = LocalDate.parse(req.getParameter(START_DATE));
        LocalDate finishDate = LocalDate.parse(req.getParameter(FINISH_DATE));
        String location = req.getParameter(LOCATION);
        companyService.addCourseToCompany(id, name, startDate, finishDate, description, location);
        resp.sendRedirect(URL_COURSE);
    }

    private void searchCompany(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter(NAME_COMPANY);
        try {
            CompanyDTO company = companyService.findCompanyByName(name);
            req.setAttribute(ATT_COMPANY, company);
            req.getRequestDispatcher(SEARCH_COMPANY_JSP).forward(req, resp);
        } catch (NoResultException e) {
            e.printStackTrace();
            resp.sendRedirect(COMPANY_ERROR_JSP);
        }


    }
}
