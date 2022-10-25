package business.abstracts;

import java.util.List;

import entities.Category;

public interface CategoryService {

	void add(Category category) throws Exception;

	void delete(Category category);

	List<Category> getAll();

	Category getById(int id);
}
