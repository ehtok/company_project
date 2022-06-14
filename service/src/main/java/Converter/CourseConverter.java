package Converter;

import DTO.CourseDTO;
import Entity.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseConverter implements CourseConverterI {

    @Override
    public CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = CourseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .startDate(course.getDateStart())
                .finishDate(course.getDateFinish())
                .description(course.getDescription())
                .location(course.getLocation())
                .build();
        return courseDTO;
    }

    @Override
    public List<CourseDTO> toListDTO(List<Course> courses) {
        return courses.stream().map(course -> CourseDTO.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .startDate(course.getDateStart())
                        .finishDate(course.getDateFinish())
                        .description(course.getDescription())
                        .location(course.getLocation())
                        .company(course.getCompany())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Course toEntity(CourseDTO courseDTO) {
        Course course = Course.builder()
                .id(courseDTO.getId())
                .name(courseDTO.getName())
                .dateStart(courseDTO.getStartDate())
                .dateFinish(courseDTO.getFinishDate())
                .description(courseDTO.getDescription())
                .location(courseDTO.getLocation())
                .build();
        return course;
    }
}
