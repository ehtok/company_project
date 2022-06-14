package DAO;

import java.util.List;

public interface EntityDAO<T> {
    void save(T entity);

    void update(T entity);

    void delete(int id);

    T findById(int id);

    List<T> findAll();

    void closeDAO();

}
