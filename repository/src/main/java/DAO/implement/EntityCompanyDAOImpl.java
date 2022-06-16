package DAO.implement;

import DAO.EntityCompanyDAO;
import Entity.Company;
import Utils.EntityFactoryManager;

import javax.persistence.EntityManager;

import static Constant.Constants.*;


public class EntityCompanyDAOImpl extends EntityDAOImpl<Company> implements EntityCompanyDAO {


    private EntityManager em;

    public EntityCompanyDAOImpl() {
        super(Company.class);
    }

    public Company findCompanyByName(String name) {
        em = EntityFactoryManager.getEntityManager();
        Company company = (Company) em.createQuery(FROM_COMPANY_WHERE_NAME_LIKE_NAME)
                .setParameter(PARAMETER_NAME, name)
                .getSingleResult();
        return company;
    }
}
