package Service.implement;

import Converter.*;
import DAO.EntityCompanyDAO;
import DAO.EntityCourseDAO;
import DAO.EntityVacancyDAO;
import DAO.implement.EntityCompanyDAOImpl;
import DAO.implement.EntityCourseDAOImpl;
import DAO.implement.EntityVacancyDAOImpl;
import DTO.CompanyDTO;
import DTO.CourseDTO;
import DTO.VacancyDTO;
import Entity.Company;
import Entity.Course;
import Entity.Vacancy;
import Service.CompanyService;

import java.time.LocalDate;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private EntityCompanyDAO companyDAO = new EntityCompanyDAOImpl();
    private EntityVacancyDAO vacancyDAO = new EntityVacancyDAOImpl();
    private VacancyConverterI vacancyConverter = new VacancyConverter();
    private CompanyConverterI companyConverter = new CompanyConverter();
    private EntityCourseDAO courseDAO = new EntityCourseDAOImpl();
    private CourseConverterI courseConverter = new CourseConverter();


    @Override
    public void saveCompany(String name, String size, String type, String description) {
        CompanyDTO companyDTO = CompanyDTO.builder()
                .name(name)
                .companySize(size)
                .companyType(type)
                .description(description)
                .build();
        Company company = companyConverter.toEntity(companyDTO);
        companyDAO.save(company);
        companyDAO.closeDAO();
    }

    @Override
    public List<CompanyDTO> findAllCompany() {
        List<Company> companies = companyDAO.findAll();
        List<CompanyDTO> companyDTO = companyConverter.toListDTO(companies);
        companyDAO.closeDAO();
        return companyDTO;
    }

    @Override
    public void deleteCompany(int id) {
        companyDAO.delete(id);
        companyDAO.closeDAO();
    }

    @Override
    public void updateCompany(int id, String name, String size, String type, String description) {
        CompanyDTO companyDTO = CompanyDTO.builder()
                .id(id)
                .name(name)
                .companySize(size)
                .companyType(type)
                .description(description)
                .build();
        Company company = companyConverter.toEntity(companyDTO);
        companyDAO.update(company);
        companyDAO.closeDAO();
    }

    @Override
    public void addVacancyToCompany(int id, String name, String time, String experience,
                                    String location, String englishLevel,
                                    String professionLevel, String salary, String status) {
        Company company = companyDAO.findById(id);
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
        vacancy.setCompany(company);
        vacancyDAO.update(vacancy);
        vacancyDAO.closeDAO();
        companyDAO.closeDAO();
    }

    @Override
    public void addCourseToCompany(int id, String name, LocalDate start, LocalDate finish, String description, String location) {
        Company company = companyDAO.findById(id);
        CourseDTO courseDTO = CourseDTO.builder()
                .name(name)
                .startDate(start)
                .finishDate(finish)
                .description(description)
                .location(location)
                .build();
        Course course = courseConverter.toEntity(courseDTO);
        courseDAO.save(course);
        course.setCompany(company);
        courseDAO.update(course);
        companyDAO.closeDAO();
        courseDAO.closeDAO();
    }

    @Override
    public CompanyDTO findCompanyByName(String name) {
        Company company = companyDAO.findCompanyByName(name);
        CompanyDTO companyDTO = companyConverter.toDTO(company);
        companyDAO.closeDAO();
        return companyDTO;
    }
}
