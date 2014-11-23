package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Year;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("yearRepository")
public interface YearRepository extends ConfigurationJpaRepository<Year, Long> {

}