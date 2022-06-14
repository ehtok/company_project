package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    private Integer id;

    private String name;

    private String companySize;

    private String companyType;

    private String description;

    private String vacancy;

    private String course;
}
