package DAO.implement;

import DAO.EntityTechnologyDAO;
import Entity.Technology;

public class EntityTechnologyDAOImpl extends EntityDAOImpl<Technology> implements EntityTechnologyDAO {

    public EntityTechnologyDAOImpl() {
        super(Technology.class);
    }
}
