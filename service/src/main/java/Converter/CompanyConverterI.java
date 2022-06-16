package Converter;

import DTO.CompanyDTO;
import Entity.Company;

import java.util.List;

public interface CompanyConverterI {
    CompanyDTO toDTO(Company entity);

    List<CompanyDTO> toListDTO(List<Company> companies);

    Company toEntity(CompanyDTO companyDTO);
}
