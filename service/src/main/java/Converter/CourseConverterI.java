package Converter;

import DTO.CourseDTO;
import Entity.Course;

import java.util.List;

public interface CourseConverterI {
    CourseDTO toDTO(Course course);

    List<CourseDTO> toListDTO(List<Course> courses);

    Course toEntity(CourseDTO courseDTO);
}
