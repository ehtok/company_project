package DAO;

import Entity.Technology;
import Entity.Vacancy;

import java.util.List;
import java.util.Set;

public interface EntityVacancyDAO extends EntityDAO<Vacancy> {

    List<Vacancy> findVacancyByName(String name);

    Set<Technology> findAllTechnologyInVacancy(Integer id);
}
