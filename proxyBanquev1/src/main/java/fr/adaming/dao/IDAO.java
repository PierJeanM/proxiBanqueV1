package fr.adaming.dao;

import java.util.List;

/**
 * Interface DAO générique
 * @author INTI-0232
 *
 * @param <T>
 */
public interface IDAO<T> {
	void add(T t);
	void update(T t);
	void delete(T t);
	T getById(int id);
	List<T> getAll();
}
