package Converter;

import DTO.VacancyDTO;
import Entity.Vacancy;

import java.util.List;

public interface VacancyConverterI {
    VacancyDTO toDTO(Vacancy vacancy);

    List<VacancyDTO> toListDTO(List<Vacancy> vacancies);

    Vacancy toEntity(VacancyDTO vacancyDTO);
}
