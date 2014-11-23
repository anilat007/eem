package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Language;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("languageRepository")
public interface LanguageRepository extends ConfigurationJpaRepository<Language, Long> {

}
