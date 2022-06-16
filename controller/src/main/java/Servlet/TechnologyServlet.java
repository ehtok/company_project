package Servlet;

import Entity.Technology;
import Service.TechnologyService;
import Service.implement.TechnologyServiceImpl;

import javax.persistence.RollbackException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static Сonstant.Constants.*;

@WebServlet(name = "TechnologyServlet", value = "/technology")
public class TechnologyServlet extends HttpServlet {



    private TechnologyService technologyService = new TechnologyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Technology> technologyList = technologyService.findAllTechnology();
        req.setAttribute(TECHNOLOGIES_ATT, technologyList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(TECHNOLOGY_PAGE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);
        switch (action) {
            case ADD -> addTechnology(req, resp);
            case UPDATE -> updateTechnology(req, resp);
            case DELETE -> deleteTechnology(req, resp);
        }
    }


    private void addTechnology(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(TECHNOLOGY_NAME);
        technologyService.saveTechnology(name);
        resp.sendRedirect(URL_TECHNOLOGY);
    }

    private void updateTechnology(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID));
        String name = req.getParameter(TECHNOLOGY_NAME);
        technologyService.updateTechnology(id, name);
        resp.sendRedirect(URL_TECHNOLOGY);
    }

    private void deleteTechnology(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter(ID));
        String page;
        try {
            technologyService.deleteTechnology(id);
            page = URL_TECHNOLOGY;
        } catch (RollbackException e) {
            e.printStackTrace();
            page = TECHNOLOGY_ERROR_JSP;
        }
        resp.sendRedirect(page);

    }
}
