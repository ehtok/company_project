package Service;

import Entity.Technology;

import java.util.List;

public interface TechnologyService {
    void saveTechnology(String name);

    List<Technology> findAllTechnology();

    void updateTechnology(int id, String name);

    void deleteTechnology(int id);
}
