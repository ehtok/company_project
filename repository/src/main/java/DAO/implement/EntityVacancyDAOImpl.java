package DAO.implement;

import DAO.EntityVacancyDAO;
import Entity.Vacancy;
import Utils.EntityFactoryManager;

import javax.persistence.EntityManager;
import java.util.List;


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
        return vacancies;
    }
}
