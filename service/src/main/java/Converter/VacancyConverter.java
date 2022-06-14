package Converter;

import DTO.VacancyDTO;
import Entity.Technology;
import Entity.Vacancy;

import java.util.List;
import java.util.stream.Collectors;

public class VacancyConverter implements VacancyConverterI {

    @Override
    public VacancyDTO toDTO(Vacancy vacancy) {
        VacancyDTO vacancyDTO = VacancyDTO.builder()
                .id(vacancy.getId())
                .name(vacancy.getName())
                .workingTime(vacancy.getWorkingTime())
                .experience(vacancy.getExperience())
                .englishLevel(vacancy.getEnglishLevel())
                .professionLevel(vacancy.getProfessionLevel())
                .salary(vacancy.getSalary())
                .status(vacancy.getStatus())
                .location(vacancy.getLocation())
                .build();
        return vacancyDTO;
    }

    @Override
    public List<VacancyDTO> toListDTO(List<Vacancy> vacancies) {
        return vacancies.stream().map(
                        vacancy -> VacancyDTO.builder()
                                .id(vacancy.getId())
                                .name(vacancy.getName())
                                .workingTime(vacancy.getWorkingTime())
                                .experience(vacancy.getExperience())
                                .englishLevel(vacancy.getEnglishLevel())
                                .professionLevel(vacancy.getProfessionLevel())
                                .salary(vacancy.getSalary())
                                .status(vacancy.getStatus())
                                .location(vacancy.getLocation())
                                .technology(vacancy.getTechnologies().stream().map(Technology::getName).collect(Collectors.joining(" , ")))
                                .company(vacancy.getCompany())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public Vacancy toEntity(VacancyDTO vacancyDTO) {
        Vacancy vacancy = Vacancy.builder()
                .id(vacancyDTO.getId())
                .name(vacancyDTO.getName())
                .workingTime(vacancyDTO.getWorkingTime())
                .experience(vacancyDTO.getExperience())
                .englishLevel(vacancyDTO.getEnglishLevel())
                .professionLevel(vacancyDTO.getProfessionLevel())
                .salary(vacancyDTO.getSalary())
                .status(vacancyDTO.getStatus())
                .location(vacancyDTO.getLocation())
                .build();
        return vacancy;
    }
}
