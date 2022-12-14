package business.concretes;

import java.util.List;

import business.abstracts.CategoryService;
import core.logging.Logger;
import dataAccess.abstracts.CategoryDao;
import entities.Category;

public class CategoryManager implements CategoryService {

	private CategoryDao categoryDao;
	private List<Logger> loggers;

	public CategoryManager(CategoryDao categoryDao, List<Logger> loggers) {

		this.categoryDao = categoryDao;
		this.loggers = loggers;
	}

	@Override
	public void add(Category category) throws Exception {

		if (checkIfCategoryNameExists(category)) {

			throw new Exception("Category already exists: " + category.getName());
		}

		this.categoryDao.add(category);

		this.loggers.forEach(lgg -> lgg.log());

	}

	@Override
	public void delete(Category category) {

		this.categoryDao.delete(category);

	}

	@Override
	public List<Category> getAll() {

		return this.categoryDao.getAll();
	}

	@Override
	public Category getById(int id) {

		return this.categoryDao.getById(id);
	}

	private boolean checkIfCategoryNameExists(Category category) {

		boolean exist = false;
		var categories = this.categoryDao.getAll();

		for (var categoryToCheck : categories) {

			if (categoryToCheck.getName() == category.getName()) {
				exist = true;
			}

		}

		return exist;

	}
}
