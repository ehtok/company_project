import DAO.EntityVacancyDAO;
import DAO.implement.EntityVacancyDAOImpl;
import Entity.Vacancy;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityVacancyDAO dao = new EntityVacancyDAOImpl();
        List<Vacancy> java_developer = dao.findVacancyByName("Developer");
        for (Vacancy vacancy : java_developer
        ) {
            System.out.println(vacancy);
        }
    }
}
