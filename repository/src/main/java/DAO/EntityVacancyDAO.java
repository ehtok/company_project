package DAO;

import Entity.Vacancy;

import java.util.List;

public interface EntityVacancyDAO extends EntityDAO<Vacancy> {

    List<Vacancy> findVacancyByName(String name);
}
