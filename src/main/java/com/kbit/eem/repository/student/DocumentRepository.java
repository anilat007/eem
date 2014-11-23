package com.kbit.eem.repository.student;

import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.Document;
import com.kbit.eem.repository.ConfigurationJpaRepository;

@Repository("documentRepository")
public interface DocumentRepository extends ConfigurationJpaRepository<Document, Long> {

}