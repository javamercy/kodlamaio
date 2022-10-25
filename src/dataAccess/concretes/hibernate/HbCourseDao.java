package dataAccess.concretes.hibernate;

import java.util.List;

import dataAccess.abstracts.CourseDao;
import database.CourseData;
import entities.Course;

public class HbCourseDao implements CourseDao {

	CourseData courseData = new CourseData();

	@Override
	public List<Course> getAll() {

		return this.courseData.courses;
	}

	@Override
	public Course getById(int id) {

		var courses = this.courseData.courses;

		for (var course : courses) {

			if (course.getId() == id) {

				return course;
			}
		}

		return null;

	}

	@Override
	public void add(Course entity) {

		this.courseData.courses.add(entity);
		System.out.println("Course was added by hibernate: " + entity.getName());

	}

	@Override
	public void delete(Course entity) {

		this.courseData.courses.remove(entity);
	}

}
