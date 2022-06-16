package Service.implement;


import Converter.VacancyConverter;
import Converter.VacancyConverterI;
import DAO.EntityCompanyDAO;
import DAO.EntityTechnologyDAO;
import DAO.implement.EntityCompanyDAOImpl;
import DAO.implement.EntityTechnologyDAOImpl;
import DAO.implement.EntityVacancyDAOImpl;
import DTO.VacancyDTO;
import Entity.Technology;
import Entity.Vacancy;
import Service.VacancyService;

import java.util.List;

public class VacancyServiceImpl implements VacancyService {

    private EntityVacancyDAOImpl vacancyDAO = new EntityVacancyDAOImpl();
    private VacancyConverterI vacancyConverter = new VacancyConverter();
    private EntityTechnologyDAO technologyDAO = new EntityTechnologyDAOImpl();
    private EntityCompanyDAO companyDAO = new EntityCompanyDAOImpl();

    @Override
    public void saveVacancy(String name, String time, String experience, String location, String englishLevel, String professionLevel,
                            String salary, String status) {
        VacancyDTO vacancyDTO = VacancyDTO.builder()
                .name(name)
                .workingTime(time)
                .experience(experience)
                .location(location)
                .englishLevel(englishLevel)
                .professionLevel(professionLevel)
                .salary(salary)
                .status(status)
                .build();
        Vacancy vacancy = vacancyConverter.toEntity(vacancyDTO);
        vacancyDAO.save(vacancy);
        vacancyDAO.closeDAO();
    }

    @Override
    public List<VacancyDTO> findAllVacancy() {
        List<Vacancy> vacancies = vacancyDAO.findAll();
        List<VacancyDTO> vacancyDTO = vacancyConverter.toListDTO(vacancies);
        vacancyDAO.closeDAO();
        return vacancyDTO;
    }

    @Override
    public void deleteVacancy(int id) {
        vacancyDAO.delete(id);
        vacancyDAO.closeDAO();
    }

    @Override
    public void updateVacancy(int id, String name, String time, String experience, String location,
                              String englishLevel, String professionLevel, String salary, String status) {
        Vacancy vacancy = vacancyDAO.findById(id);
        vacancy.setName(name);
        vacancy.setWorkingTime(time);
        vacancy.setExperience(experience);
        vacancy.setLocation(location);
        vacancy.setEnglishLevel(englishLevel);
        vacancy.setProfessionLevel(professionLevel);
        vacancy.setSalary(salary);
        vacancy.setStatus(status);
        vacancyDAO.update(vacancy);
        vacancyDAO.closeDAO();
    }


    @Override
    public void addTechnologyToVacancy(int idVacancy, int idTechnology) {
        Vacancy vacancy = vacancyDAO.findById(idVacancy);
        Technology technology = technologyDAO.findById(idTechnology);
        vacancy.getTechnologies().add(technology);
        vacancyDAO.update(vacancy);
        vacancyDAO.closeDAO();
        technologyDAO.closeDAO();
    }

    @Override
    public List<VacancyDTO> findVacancyByName(String name) {
        List<Vacancy> vacancies = vacancyDAO.findVacancyByName(name);
        vacancyDAO.closeDAO();
        return vacancyConverter.toListDTO(vacancies);
    }


}
