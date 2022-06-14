package DAO.implement;

import DAO.EntityDAO;
import Utils.EntityFactoryManager;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static Constant.Constants.*;

public class EntityDAOImpl<T> implements EntityDAO<T> {


    private EntityManager em;

    private Class<T> eClass;

    public EntityDAOImpl(Class<T> eClass) {
        this.eClass = eClass;
    }

    @Override
    public void save(T entity) {
        em = EntityFactoryManager.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(entity);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(T entity) {
        em = EntityFactoryManager.getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(entity);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(int id) {
        em = EntityFactoryManager.getEntityManager();
        em.getTransaction().begin();

        try {
            T entity = em.find(eClass, id);
            em.remove(entity);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public T findById(int id) {
        T entity = null;
        em = EntityFactoryManager.getEntityManager();
        em.getTransaction().begin();
        try {
            entity = em.find(eClass, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return entity;
    }

    @Override
    public List<T> findAll() {
        em = EntityFactoryManager.getEntityManager();
        List<T> list = new ArrayList<>();
        try {
            list = em
                    .createQuery(FROM + eClass.getName())
                    .getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return list;
    }

    @Override
    public void closeDAO() {
        em.close();
    }
}

