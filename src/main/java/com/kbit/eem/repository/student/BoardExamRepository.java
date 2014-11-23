package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.BoardExam;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("boardExamRepository")
public interface BoardExamRepository extends ConfigurationJpaRepository<BoardExam, Long> {

}