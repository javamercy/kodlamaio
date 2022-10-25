package core.business;

import java.util.List;

public interface EntityRepository<T> {

	List<T> getAll();

	T getById(int id);

	void add(T entity);

	void delete(T entity);

}
