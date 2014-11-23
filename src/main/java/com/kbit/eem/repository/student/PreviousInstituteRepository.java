package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.PreviousInstitute;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("previousInstituteRepository")
public interface PreviousInstituteRepository extends ConfigurationJpaRepository<PreviousInstitute, Long> {

}