package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.QualifiedExam;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("qualifiedExamRepository")
public interface QualifiedExamRepository extends ConfigurationJpaRepository<QualifiedExam, Long> {

}