package ui;

import business.concretes.CategoryManager;
import business.concretes.CourseManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import dataAccess.concretes.hibernate.HbCategoryDao;
import dataAccess.concretes.hibernate.HbCourseDao;
import dataAccess.concretes.jdbc.JdbcCategoryDao;
import entities.Category;
import entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {

		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), new FileLogger());

		categoryManager.add(new Category(1, "Software"));
//		categoryManager.add(new Category(2, "Software"));
		categoryManager.add(new Category(2, "Science"));

		CourseManager courseManager = new CourseManager(new HbCourseDao(), new DatabaseLogger());

		courseManager.add(new Course(1, 1, "Java", 2));
		courseManager.add(new Course(1, 1, "javaScript", 200));

	}

}
