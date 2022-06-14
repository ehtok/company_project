package DAO.implement;

import DAO.EntityCourseDAO;
import Entity.Course;

public class EntityCourseDAOImpl extends EntityDAOImpl<Course> implements EntityCourseDAO {

    public EntityCourseDAOImpl() {
        super(Course.class);
    }
}
