package com.kbit.eem.service.student;

import java.util.List;

import com.kbit.eem.DBModel.AdmissionType;
import com.kbit.eem.DBModel.BoardExam;
import com.kbit.eem.DBModel.Caste;
import com.kbit.eem.DBModel.Category;
import com.kbit.eem.DBModel.Course;
import com.kbit.eem.DBModel.Document;
import com.kbit.eem.DBModel.Language;
import com.kbit.eem.DBModel.Nationality;
import com.kbit.eem.DBModel.Occupation;
import com.kbit.eem.DBModel.PreviousInstitute;
import com.kbit.eem.DBModel.QualifiedExam;
import com.kbit.eem.DBModel.Religion;
import com.kbit.eem.DBModel.Scheme;
import com.kbit.eem.DBModel.Year;

public interface StudentConfigurationService {
	AdmissionType saveAdmissionType(AdmissionType admissionType);
	AdmissionType findAdmissionType(Long id);
	List<AdmissionType> findAllAdmissionType();
	List<AdmissionType> findAllActieAdmissionType();
	AdmissionType findAdmissionTypeByName(String name);
	void deleteAdmissionType(AdmissionType admissionType);
	void deleteAdmissionTypeInBatch(List<AdmissionType> admissionTypeList);
	void deleteAdmissionType(long id);

	BoardExam saveBoardExam(BoardExam boardExam);
	BoardExam findBoardExam(Long id);
	List<BoardExam> findAllBoardExam();
	List<BoardExam> findAllActieBoardExam();
	BoardExam findBoardExamByName(String name);
	void deleteBoardExam(BoardExam boardExam);
	void deleteBoardExamInBatch(List<BoardExam> boardExamList);
	void deleteBoardExam(long id);

	Caste saveCaste(Caste caste);
	Caste findCaste(Long id);
	List<Caste> findAllCaste();
	List<Caste> findAllActieCaste();
	Caste findCasteByName(String name);
	void deleteCaste(Caste caste);
	void deleteCasteInBatch(List<Caste> casteList);
	void deleteCaste(long id);

	Category saveCategory(Category category);
	Category findCategory(Long id);
	List<Category> findAllCategory();
	List<Category> findAllActieCategory();
	Category findCategoryByName(String name);
	void deleteCategory(Category category);
	void deleteCategoryInBatch(List<Category> categoryList);
	void deleteCategory(long id);

	Course saveCourse(Course course);
	Course findCourse(Long id);
	List<Course> findAllCourse();
	List<Course> findAllActieCourse();
	Course findCourseByName(String name);
	void deleteCourse(Course course);
	void deleteCourseInBatch(List<Course> courseList);
	void deleteCourse(long id);

	Document saveDocument(Document document);
	Document findDocument(Long id);
	List<Document> findAllDocument();
	List<Document> findAllActieDocument();
	Document findDocumentByName(String name);
	void deleteDocument(Document document);
	void deleteDocumentInBatch(List<Document> documentList);
	void deleteDocument(long id);

	Language saveLanguage(Language language);
	Language findLanguage(Long id);
	List<Language> findAllLanguage();
	List<Language> findAllActieLanguage();
	Language findLanguageByName(String name);
	void deleteLanguage(Language language);
	void deleteLanguageInBatch(List<Language> languageList);
	void deleteLanguage(long id);

	Nationality saveNationality(Nationality nationality);
	Nationality findNationality(Long id);
	List<Nationality> findAllNationality();
	List<Nationality> findAllActieNationality();
	Nationality findNationalityByName(String name);
	void deleteNationality(Nationality nationality);
	void deleteNationalityInBatch(List<Nationality> nationalityList);
	void deleteNationality(long id);

	Occupation saveOccupation(Occupation occupation);
	Occupation findOccupation(Long id);
	List<Occupation> findAllOccupation();
	List<Occupation> findAllActieOccupation();
	Occupation findOccupationByName(String name);
	void deleteOccupation(Occupation occupation);
	void deleteOccupationInBatch(List<Occupation> occupationList);
	void deleteOccupation(long id);

	PreviousInstitute savePreviousInstitute(PreviousInstitute previousInstitute);
	PreviousInstitute findPreviousInstitute(Long id);
	List<PreviousInstitute> findAllPreviousInstitute();
	List<PreviousInstitute> findAllActiePreviousInstitute();
	PreviousInstitute findPreviousInstituteByName(String name);
	void deletePreviousInstitute(PreviousInstitute previousInstitute);
	void deletePreviousInstituteInBatch(List<PreviousInstitute> previousInstituteList);
	void deletePreviousInstitute(long id);

	QualifiedExam saveQualifiedExam(QualifiedExam qualifiedExam);
	QualifiedExam findQualifiedExam(Long id);
	List<QualifiedExam> findAllQualifiedExam();
	List<QualifiedExam> findAllActieQualifiedExam();
	QualifiedExam findQualifiedExamByName(String name);
	void deleteQualifiedExam(QualifiedExam qualifiedExam);
	void deleteQualifiedExamInBatch(List<QualifiedExam> qualifiedExamList);
	void deleteQualifiedExam(long id);

	Religion saveReligion(Religion religion);
	Religion findReligion(Long id);
	List<Religion> findAllReligion();
	List<Religion> findAllActieReligion();
	Religion findReligionByName(String name);
	void deleteReligion(Religion religion);
	void deleteReligionInBatch(List<Religion> religionList);
	void deleteReligion(long id);

	Scheme saveScheme(Scheme scheme);
	Scheme findScheme(Long id);
	List<Scheme> findAllScheme();
	List<Scheme> findAllActieScheme();
	Scheme findSchemeByName(String name);
	void deleteScheme(Scheme scheme);
	void deleteSchemeInBatch(List<Scheme> schemeList);
	void deleteScheme(long id);

	Year saveYear(Year year);
	Year findYear(Long id);
	List<Year> findAllYear();
	List<Year> findAllActieYear();
	Year findYearByName(String name);
	void deleteYear(Year year);
	void deleteYearInBatch(List<Year> yearList);
	void deleteYear(long id);
}
