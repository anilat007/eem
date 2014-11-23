package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Nationality;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("nationalityRepository")
public interface NationalityRepository extends ConfigurationJpaRepository<Nationality, Long> {

}