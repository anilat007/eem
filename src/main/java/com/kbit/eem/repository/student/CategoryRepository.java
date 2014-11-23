package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Category;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("categoryRepository")
public interface CategoryRepository extends ConfigurationJpaRepository<Category, Long> {

}
