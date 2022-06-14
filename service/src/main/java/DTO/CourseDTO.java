package DTO;

import Entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Integer id;

    private String name;

    private LocalDate startDate;

    private LocalDate finishDate;

    private String description;

    private String location;

    private Company company;

}
