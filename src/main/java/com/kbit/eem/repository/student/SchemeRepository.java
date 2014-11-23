package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Scheme;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("schemeRepository")
public interface SchemeRepository extends ConfigurationJpaRepository<Scheme, Long> {

}