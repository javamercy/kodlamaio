package business.abstracts;

import java.util.List;

import entities.Course;

public interface CourseService {

	void add(Course course) throws Exception;

	void delete(Course course);

	List<Course> getAll();

	Course getById(int id);
}
