package Service;

import DTO.VacancyDTO;

import java.util.List;

public interface VacancyService {
    void saveVacancy(String name, String time, String experience, String location, String englishLevel, String professionLevel,
                     String salary, String status);

    List<VacancyDTO> findAllVacancy();

    void deleteVacancy(int id);

    void updateVacancy(int id, String name, String time, String experience, String location, String englishLevel, String professionLevel,
                       String salary, String status);


    void addTechnologyToVacancy(int idVacancy, int idTechnology);

    List<VacancyDTO> findVacancyByName(String name);


}
