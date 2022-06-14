package Converter;

import DTO.CompanyDTO;
import Entity.Company;
import Entity.Course;
import Entity.Vacancy;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyConverter implements CompanyConverterI {

    @Override
    public CompanyDTO toDTO(Company entity) {
        CompanyDTO companyDTO = CompanyDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .companySize(entity.getCompanySize())
                .companyType(entity.getCompanyType())
                .description(entity.getDescription())
                .vacancy(entity.getVacancies().stream().map(Vacancy::getName).collect(Collectors.joining(" ,")))
                .course(entity.getCourses().stream().map(Course::getName).collect(Collectors.joining(" ,")))
                .build();
        return companyDTO;
    }

    @Override
    public List<CompanyDTO> toListDTO(List<Company> companies) {
        return companies.stream().map(
                        company -> CompanyDTO.builder()
                                .id(company.getId())
                                .name(company.getName())
                                .companySize(company.getCompanySize())
                                .companyType(company.getCompanyType())
                                .description(company.getDescription())
                                .vacancy(company.getVacancies().stream().map(Vacancy::getName).collect(Collectors.joining(" , ")))
                                .course(company.getCourses().stream().map(Course::getName).collect(Collectors.joining(" , ")))
                                .build())
                .collect(Collectors.toList());

    }

    @Override
    public Company toEntity(CompanyDTO companyDTO) {
        Company company = Company.builder()
                .id(companyDTO.getId())
                .name(companyDTO.getName())
                .companySize(companyDTO.getCompanySize())
                .companyType(companyDTO.getCompanyType())
                .description(companyDTO.getDescription())
                .build();
        return company;
    }
}
