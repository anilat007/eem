package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.BloodGroup;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("bloodGroupRepository")
public interface BloodGroupRepository extends ConfigurationJpaRepository<BloodGroup, Long> {
}