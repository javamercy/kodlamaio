package business.concretes;

import java.util.List;

import business.abstracts.CourseService;
import core.logging.Logger;
import dataAccess.abstracts.CourseDao;
import entities.Course;

public class CourseManager implements CourseService {

	private CourseDao courseDao;
	private Logger logger;

	public CourseManager(CourseDao courseDao, Logger logger) {

		this.courseDao = courseDao;
		this.logger = logger;
	}

	@Override
	public void add(Course course) throws Exception {

		if (checkIfCourseNameExists(course)) {

			throw new Exception("Course already exists: " + course.getName());
		}

		if (checkIfPriceLessThanZero(course)) {

			throw new Exception("Price cannot be less than 0!");
		}

		this.courseDao.add(course);
		this.logger.log();

	}

	@Override
	public void delete(Course course) {

		this.courseDao.delete(course);

	}

	@Override
	public List<Course> getAll() {

		return this.courseDao.getAll();
	}

	@Override
	public Course getById(int id) {

		return this.courseDao.getById(id);
	}

	private boolean checkIfCourseNameExists(Course course) {

		boolean exist = false;
		var courses = this.courseDao.getAll();

		for (var courseToCheck : courses) {

			if (courseToCheck.getName() == course.getName()) {

				exist = true;
			}
		}

		return exist;
	}

	private boolean checkIfPriceLessThanZero(Course course) {

		return course.getPrice() < 0;
	}

}
