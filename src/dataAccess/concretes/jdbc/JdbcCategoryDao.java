package dataAccess.concretes.jdbc;

import java.util.List;

import dataAccess.abstracts.CategoryDao;
import database.CategoryData;
import entities.Category;

public class JdbcCategoryDao implements CategoryDao {

	CategoryData categoryData = new CategoryData();

	@Override
	public List<Category> getAll() {

		return this.categoryData.categories;
	}

	@Override
	public Category getById(int id) {

		var categories = this.categoryData.categories;

		for (var category : categories) {

			if (category.getId() == id) {

				return category;
			}
		}

		return null;

	}

	@Override
	public void add(Category entity) {

		this.categoryData.categories.add(entity);
		System.out.println("Category was added by jdbc: " + entity.getName());

	}

	@Override
	public void delete(Category entity) {

		this.categoryData.categories.remove(entity);
	}
}
