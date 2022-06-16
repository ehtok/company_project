package Servlet;

import DTO.CourseDTO;
import Service.CourseService;
import Service.implement.CourseServiceImpl;

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

@WebServlet(name = "CourseServlet", value = "/course")
public class CourseServlet extends HttpServlet {


    private CourseService courseService = new CourseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseDTO> courseList = courseService.findAllCourse();
        req.setAttribute(ATT_COURSES, courseList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(COURSE_PAGE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);
        switch (action) {
            case ADD -> saveCourse(req, resp);
            case UPDATE -> updateCourse(req, resp);
            case DELETE -> deleteCourse(req, resp);
        }
    }


    private void saveCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(NAME_COURSE);
        String description = req.getParameter(COURSE_DESCRIPTION);
        LocalDate startDate = LocalDate.parse(req.getParameter(START_DATE));
        LocalDate finishDate = LocalDate.parse(req.getParameter(FINISH_DATE));
        String location = req.getParameter(LOCATION);
        courseService.saveCourse(name, startDate, finishDate, description, location);
        resp.sendRedirect(URL_COURSE);
    }

    private void updateCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID));
        String name = req.getParameter(NAME_COURSE);
        String description = req.getParameter(COURSE_DESCRIPTION);
        LocalDate startDate = LocalDate.parse(req.getParameter(START_DATE));
        LocalDate finishDate = LocalDate.parse(req.getParameter(FINISH_DATE));
        String location = req.getParameter(LOCATION);
        courseService.updateCourse(id, name, startDate, finishDate, description, location);
        resp.sendRedirect(URL_COURSE);
    }


    private void deleteCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID));
        courseService.deleteCourse(id);
        resp.sendRedirect(URL_COURSE);
    }


}
