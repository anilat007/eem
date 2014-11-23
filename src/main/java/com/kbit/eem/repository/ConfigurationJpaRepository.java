package com.kbit.eem.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	/*
	 * Find Active items
	 */
	List<T> findByActiveTrue();
	
	/*
	 * Find an item by name
	 */
	T findByName(String name);
}
