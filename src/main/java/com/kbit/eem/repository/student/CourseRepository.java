package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Course;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("courseRepository")
public interface CourseRepository extends ConfigurationJpaRepository<Course, Long> {

}
