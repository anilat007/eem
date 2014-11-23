package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Occupation;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("occupationRepository")
public interface OccupationRepository extends ConfigurationJpaRepository<Occupation, Long> {

}