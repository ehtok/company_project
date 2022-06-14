package Service;

import DTO.CompanyDTO;

import java.time.LocalDate;
import java.util.List;

public interface CompanyService {

    void saveCompany(String name, String size, String type, String description);

    List<CompanyDTO> findAllCompany();

    void deleteCompany(int id);

    void updateCompany(int id, String name, String size, String type, String description);

    void addVacancyToCompany(int id, String name, String time, String experience, String location, String englishLevel, String professionLevel,
                             String salary, String status);

    void addCourseToCompany(int id, String name, LocalDate start, LocalDate finish, String description, String location);

    CompanyDTO findCompanyByName(String name);
}
