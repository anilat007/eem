package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.AdmissionType;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("admissionTypeRepository")
public interface AdmissionTypeRepository extends ConfigurationJpaRepository<AdmissionType, Long> {

}