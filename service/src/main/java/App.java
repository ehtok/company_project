import DAO.EntityVacancyDAO;
import DAO.implement.EntityVacancyDAOImpl;
import Entity.Technology;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        EntityVacancyDAO vacancyDAO = new EntityVacancyDAOImpl();
        Set<Technology> allTechnologyInVacancy = vacancyDAO.findAllTechnologyInVacancy(1);
        for (Technology t : allTechnologyInVacancy
        ) {
            System.out.println(t);
        }
    }
}
