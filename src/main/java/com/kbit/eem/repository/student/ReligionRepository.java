package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Religion;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("religionRepository")
public interface ReligionRepository extends ConfigurationJpaRepository<Religion, Long> {

}