package ui;

import java.util.ArrayList;
import java.util.List;

import business.concretes.CategoryManager;
import business.concretes.CourseManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import dataAccess.concretes.hibernate.HbCategoryDao;
import dataAccess.concretes.hibernate.HbCourseDao;
import dataAccess.concretes.jdbc.JdbcCategoryDao;
import entities.Category;
import entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {

		List<Logger> loggers = new ArrayList<Logger>();
		loggers.add(new DatabaseLogger());
		loggers.add(new FileLogger());
		
		System.out.println("----------------------------------------------------------------------");

		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), loggers);

		categoryManager.add(new Category(1, "Software"));
//		categoryManager.add(new Category(2, "Software"));
		categoryManager.add(new Category(2, "Science"));
		
		System.out.println("----------------------------------------------------------------------");

		CourseManager courseManager = new CourseManager(new HbCourseDao(), loggers);

		courseManager.add(new Course(1, 1, "Java", 2));
		courseManager.add(new Course(1, 1, "javaScript", 200));

	}

}
