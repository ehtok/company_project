package DAO.implement;

import DAO.EntityVacancyDAO;
import Entity.Technology;
import Entity.Vacancy;
import Utils.EntityFactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

import static Constant.Constants.*;

public class EntityVacancyDAOImpl extends EntityDAOImpl<Vacancy> implements EntityVacancyDAO {


    private EntityManager em;

    public EntityVacancyDAOImpl() {
        super(Vacancy.class);
    }


    @Override
    public List<Vacancy> findVacancyByName(String name) {
        em = EntityFactoryManager.getEntityManager();
        List<Vacancy> vacancies = em.createQuery(FROM_VACANCY_WHERE_NAME_LIKE_NAME)
                .setParameter(PARAMETER_NAME, LIKE_PERCENT + name + LIKE_PERCENT)
                .getResultList();
        em.close();
        return vacancies;
    }

    @Override
    public Set<Technology> findAllTechnologyInVacancy(Integer id) {
        em = EntityFactoryManager.getEntityManager();
        Query query = em.createQuery("SELECT vacancy.technologies from Vacancy vacancy WHERE vacancy.id= :id");
        query.setParameter("id", id);
        Set<Technology> technology = (Set<Technology>) query.getResultList();
        em.close();
        return technology;
    }
}
