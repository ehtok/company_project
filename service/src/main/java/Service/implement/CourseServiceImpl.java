package Service.implement;

import Converter.CourseConverter;
import Converter.CourseConverterI;
import DAO.EntityCompanyDAO;
import DAO.EntityCourseDAO;
import DAO.implement.EntityCompanyDAOImpl;
import DAO.implement.EntityCourseDAOImpl;
import DTO.CourseDTO;
import Entity.Course;
import Service.CourseService;

import java.time.LocalDate;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    private EntityCourseDAO courseDAO = new EntityCourseDAOImpl();
    private EntityCompanyDAO companyDAO = new EntityCompanyDAOImpl();
    private CourseConverterI converter = new CourseConverter();

    @Override
    public void saveCourse(String name, LocalDate start, LocalDate finish, String description, String location) {
        CourseDTO courseDTO = CourseDTO.builder()
                .name(name)
                .startDate(start)
                .finishDate(finish)
                .description(description)
                .location(location)
                .build();
        Course course = converter.toEntity(courseDTO);
        courseDAO.save(course);
        courseDAO.closeDAO();
    }

    @Override
    public List<CourseDTO> findAllCourse() {
        List<Course> courses = courseDAO.findAll();
        List<CourseDTO> courseList = converter.toListDTO(courses);
        courseDAO.closeDAO();
        return courseList;
    }

    @Override
    public void updateCourse
            (int id, String name, LocalDate start, LocalDate finish, String description, String location) {
        Course course = courseDAO.findById(id);
        course.setName(name);
        course.setDateStart(start);
        course.setDateFinish(finish);
        course.setDescription(description);
        course.setLocation(location);
        courseDAO.update(course);
        courseDAO.closeDAO();
    }


    @Override
    public void deleteCourse(int id) {
        courseDAO.delete(id);
        courseDAO.closeDAO();
    }
}
