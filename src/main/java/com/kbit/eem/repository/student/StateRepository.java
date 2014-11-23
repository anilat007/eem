package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.State;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("stateRepository")
public interface StateRepository extends ConfigurationJpaRepository<State, Long> {

}
