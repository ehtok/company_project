package Service.implement;

import DAO.EntityTechnologyDAO;
import DAO.implement.EntityTechnologyDAOImpl;
import Entity.Technology;
import Service.TechnologyService;

import java.util.List;

public class TechnologyServiceImpl implements TechnologyService {
    private EntityTechnologyDAO technologyDAO = new EntityTechnologyDAOImpl();

    @Override
    public void saveTechnology(String name) {
        Technology technology = Technology.builder()
                .name(name)
                .build();

        technologyDAO.save(technology);
        technologyDAO.closeDAO();
    }

    @Override
    public List<Technology> findAllTechnology() {
        List<Technology> technologyList = technologyDAO.findAll();
        technologyDAO.closeDAO();
        return technologyList;
    }

    @Override
    public void updateTechnology(int id, String name) {
        Technology technology = Technology.builder()
                .id(id)
                .name(name)
                .build();
        technologyDAO.update(technology);
        technologyDAO.closeDAO();
    }

    @Override
    public void deleteTechnology(int id) {
        technologyDAO.delete(id);
        technologyDAO.closeDAO();
    }
}
