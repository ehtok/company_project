package Service;

import DTO.CourseDTO;

import java.time.LocalDate;
import java.util.List;

public interface CourseService {
    void saveCourse(String name, LocalDate start, LocalDate finish, String description, String location);

    List<CourseDTO> findAllCourse();

    void updateCourse(int id, String name, LocalDate start, LocalDate finish, String description, String location);

    void deleteCourse(int id);
}
