package DAO;

import Entity.Company;

public interface EntityCompanyDAO extends EntityDAO<Company> {
    public Company findCompanyByName(String name);
}
