package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Caste;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("casteRepository")
public interface CasteRepository extends ConfigurationJpaRepository<Caste, Long> {

}