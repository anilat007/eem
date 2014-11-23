package com.kbit.eem.service.student;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.kbit.eem.repository.student.AdmissionTypeRepository;
import com.kbit.eem.repository.student.BloodGroupRepository;
import com.kbit.eem.repository.student.BoardExamRepository;
import com.kbit.eem.repository.student.CasteRepository;
import com.kbit.eem.repository.student.CategoryRepository;
import com.kbit.eem.repository.student.CourseRepository;
import com.kbit.eem.repository.student.DocumentRepository;
import com.kbit.eem.repository.student.LanguageRepository;
import com.kbit.eem.repository.student.NationalityRepository;
import com.kbit.eem.repository.student.OccupationRepository;
import com.kbit.eem.repository.student.PreviousInstituteRepository;
import com.kbit.eem.repository.student.QualifiedExamRepository;
import com.kbit.eem.repository.student.ReligionRepository;
import com.kbit.eem.repository.student.SchemeRepository;
import com.kbit.eem.repository.student.StateRepository;
import com.kbit.eem.repository.student.YearRepository;
import com.kbit.eem.service.BaseService;

@Service("studentConfigurationService2")
public class StudentConfigurationServiceImpl extends BaseService implements
		StudentConfigurationService {

	static Logger logger = Logger
			.getLogger(StudentConfigurationServiceImpl.class);

	@Autowired
	private AdmissionTypeRepository admissionTypeRepository;

	@Autowired
	private BloodGroupRepository bloodGroupRepository;

	@Autowired
	private BoardExamRepository boardExamRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CasteRepository casteRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private NationalityRepository nationalityRepository;

	@Autowired
	private OccupationRepository occupationRepository;

	@Autowired
	private PreviousInstituteRepository previousInstituteRepository;

	@Autowired
	private QualifiedExamRepository qualifiedExamRepository;

	@Autowired
	private ReligionRepository religionRepository;

	@Autowired
	private SchemeRepository schemeRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private YearRepository yearRepository;

	public AdmissionType saveAdmissionType(AdmissionType admissionType) {
		this.setAuditDetails(admissionType);
		return admissionTypeRepository.save(admissionType);
	}

	public AdmissionType findAdmissionType(Long id) {
		return admissionTypeRepository.findOne(id);
	}

	public AdmissionType findAdmissionTypeByName(String name) {
		return admissionTypeRepository.findByName(name);
	}

	public List<AdmissionType> findAllAdmissionType() {
		return admissionTypeRepository.findAll();
	}

	public List<AdmissionType> findAllActieAdmissionType() {
		return admissionTypeRepository.findByActiveTrue();
	}

	public void deleteAdmissionType(AdmissionType admissionType) {
		admissionTypeRepository.delete(admissionType);
	}

	public void deleteAdmissionTypeInBatch(List<AdmissionType> admissionTypeList) {
		admissionTypeRepository.deleteInBatch(admissionTypeList);
	}

	public void deleteAdmissionType(long id) {
		admissionTypeRepository.delete(id);
	}

	public BoardExam saveBoardExam(BoardExam boardExam) {
		this.setAuditDetails(boardExam);
		return boardExamRepository.save(boardExam);
	}

	public BoardExam findBoardExam(Long id) {
		return boardExamRepository.findOne(id);
	}

	public BoardExam findBoardExamByName(String name) {
		return boardExamRepository.findByName(name);
	}

	public List<BoardExam> findAllBoardExam() {
		return boardExamRepository.findAll();
	}

	public List<BoardExam> findAllActieBoardExam() {
		return boardExamRepository.findByActiveTrue();
	}

	public void deleteBoardExam(BoardExam boardExam) {
		boardExamRepository.delete(boardExam);
	}

	public void deleteBoardExamInBatch(List<BoardExam> boardExamList) {
		boardExamRepository.deleteInBatch(boardExamList);
	}

	public void deleteBoardExam(long id) {
		boardExamRepository.delete(id);
	}

	public Caste saveCaste(Caste caste) {
		this.setAuditDetails(caste);
		return casteRepository.save(caste);
	}

	public Caste findCaste(Long id) {
		return casteRepository.findOne(id);
	}

	public Caste findCasteByName(String name) {
		return casteRepository.findByName(name);
	}

	public List<Caste> findAllCaste() {
		return casteRepository.findAll();
	}

	public List<Caste> findAllActieCaste() {
		return casteRepository.findByActiveTrue();
	}

	public void deleteCaste(Caste caste) {
		casteRepository.delete(caste);
	}

	public void deleteCasteInBatch(List<Caste> casteList) {
		casteRepository.deleteInBatch(casteList);
	}

	public void deleteCaste(long id) {
		casteRepository.delete(id);
	}

	public Category saveCategory(Category category) {
		this.setAuditDetails(category);
		return categoryRepository.save(category);
	}

	public Category findCategory(Long id) {
		return categoryRepository.findOne(id);
	}

	public Category findCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}

	public List<Category> findAllCategory() {
		return categoryRepository.findAll();
	}

	public List<Category> findAllActieCategory() {
		return categoryRepository.findByActiveTrue();
	}

	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}

	public void deleteCategoryInBatch(List<Category> categoryList) {
		categoryRepository.deleteInBatch(categoryList);
	}

	public void deleteCategory(long id) {
		categoryRepository.delete(id);
	}

	public Course saveCourse(Course course) {
		this.setAuditDetails(course);
		return courseRepository.save(course);
	}

	public Course findCourse(Long id) {
		return courseRepository.findOne(id);
	}

	public Course findCourseByName(String name) {
		return courseRepository.findByName(name);
	}

	public List<Course> findAllCourse() {
		return courseRepository.findAll();
	}

	public List<Course> findAllActieCourse() {
		return courseRepository.findByActiveTrue();
	}

	public void deleteCourse(Course course) {
		courseRepository.delete(course);
	}

	public void deleteCourseInBatch(List<Course> courseList) {
		courseRepository.deleteInBatch(courseList);
	}

	public void deleteCourse(long id) {
		courseRepository.delete(id);
	}

	public Document saveDocument(Document document) {
		this.setAuditDetails(document);
		return documentRepository.save(document);
	}

	public Document findDocument(Long id) {
		return documentRepository.findOne(id);
	}

	public Document findDocumentByName(String name) {
		return documentRepository.findByName(name);
	}

	public List<Document> findAllDocument() {
		return documentRepository.findAll();
	}

	public List<Document> findAllActieDocument() {
		return documentRepository.findByActiveTrue();
	}

	public void deleteDocument(Document document) {
		documentRepository.delete(document);
	}

	public void deleteDocumentInBatch(List<Document> documentList) {
		documentRepository.deleteInBatch(documentList);
	}

	public void deleteDocument(long id) {
		documentRepository.delete(id);
	}

	public Language saveLanguage(Language language) {
		this.setAuditDetails(language);
		return languageRepository.save(language);
	}

	public Language findLanguage(Long id) {
		return languageRepository.findOne(id);
	}

	public Language findLanguageByName(String name) {
		return languageRepository.findByName(name);
	}

	public List<Language> findAllLanguage() {
		return languageRepository.findAll();
	}

	public List<Language> findAllActieLanguage() {
		return languageRepository.findByActiveTrue();
	}

	public void deleteLanguage(Language language) {
		languageRepository.delete(language);
	}

	public void deleteLanguageInBatch(List<Language> languageList) {
		languageRepository.deleteInBatch(languageList);
	}

	public void deleteLanguage(long id) {
		languageRepository.delete(id);
	}

	public Nationality saveNationality(Nationality nationality) {
		this.setAuditDetails(nationality);
		return nationalityRepository.save(nationality);
	}

	public Nationality findNationality(Long id) {
		return nationalityRepository.findOne(id);
	}

	public Nationality findNationalityByName(String name) {
		return nationalityRepository.findByName(name);
	}

	public List<Nationality> findAllNationality() {
		return nationalityRepository.findAll();
	}

	public List<Nationality> findAllActieNationality() {
		return nationalityRepository.findByActiveTrue();
	}

	public void deleteNationality(Nationality nationality) {
		nationalityRepository.delete(nationality);
	}

	public void deleteNationalityInBatch(List<Nationality> nationalityList) {
		nationalityRepository.deleteInBatch(nationalityList);
	}

	public void deleteNationality(long id) {
		nationalityRepository.delete(id);
	}

	public Occupation saveOccupation(Occupation occupation) {
		this.setAuditDetails(occupation);
		return occupationRepository.save(occupation);
	}

	public Occupation findOccupation(Long id) {
		return occupationRepository.findOne(id);
	}

	public Occupation findOccupationByName(String name) {
		return occupationRepository.findByName(name);
	}

	public List<Occupation> findAllOccupation() {
		return occupationRepository.findAll();
	}

	public List<Occupation> findAllActieOccupation() {
		return occupationRepository.findByActiveTrue();
	}

	public void deleteOccupation(Occupation occupation) {
		occupationRepository.delete(occupation);
	}

	public void deleteOccupationInBatch(List<Occupation> occupationList) {
		occupationRepository.deleteInBatch(occupationList);
	}

	public void deleteOccupation(long id) {
		occupationRepository.delete(id);
	}

	public PreviousInstitute savePreviousInstitute(
			PreviousInstitute previousInstitute) {
		this.setAuditDetails(previousInstitute);
		return previousInstituteRepository.save(previousInstitute);
	}

	public PreviousInstitute findPreviousInstitute(Long id) {
		return previousInstituteRepository.findOne(id);
	}

	public PreviousInstitute findPreviousInstituteByName(String name) {
		return previousInstituteRepository.findByName(name);
	}

	public List<PreviousInstitute> findAllPreviousInstitute() {
		return previousInstituteRepository.findAll();
	}

	public List<PreviousInstitute> findAllActiePreviousInstitute() {
		return previousInstituteRepository.findByActiveTrue();
	}

	public void deletePreviousInstitute(PreviousInstitute previousInstitute) {
		previousInstituteRepository.delete(previousInstitute);
	}

	public void deletePreviousInstituteInBatch(
			List<PreviousInstitute> previousInstituteList) {
		previousInstituteRepository.deleteInBatch(previousInstituteList);
	}

	public void deletePreviousInstitute(long id) {
		previousInstituteRepository.delete(id);
	}

	public QualifiedExam saveQualifiedExam(QualifiedExam qualifiedExam) {
		this.setAuditDetails(qualifiedExam);
		return qualifiedExamRepository.save(qualifiedExam);
	}

	public QualifiedExam findQualifiedExam(Long id) {
		return qualifiedExamRepository.findOne(id);
	}

	public QualifiedExam findQualifiedExamByName(String name) {
		return qualifiedExamRepository.findByName(name);
	}

	public List<QualifiedExam> findAllQualifiedExam() {
		return qualifiedExamRepository.findAll();
	}

	public List<QualifiedExam> findAllActieQualifiedExam() {
		return qualifiedExamRepository.findByActiveTrue();
	}

	public void deleteQualifiedExam(QualifiedExam qualifiedExam) {
		qualifiedExamRepository.delete(qualifiedExam);
	}

	public void deleteQualifiedExamInBatch(List<QualifiedExam> qualifiedExamList) {
		qualifiedExamRepository.deleteInBatch(qualifiedExamList);
	}

	public void deleteQualifiedExam(long id) {
		qualifiedExamRepository.delete(id);
	}

	public Religion saveReligion(Religion religion) {
		this.setAuditDetails(religion);
		return religionRepository.save(religion);
	}

	public Religion findReligion(Long id) {
		return religionRepository.findOne(id);
	}

	public Religion findReligionByName(String name) {
		return religionRepository.findByName(name);
	}

	public List<Religion> findAllReligion() {
		return religionRepository.findAll();
	}

	public List<Religion> findAllActieReligion() {
		return religionRepository.findByActiveTrue();
	}

	public void deleteReligion(Religion religion) {
		religionRepository.delete(religion);
	}

	public void deleteReligionInBatch(List<Religion> religionList) {
		religionRepository.deleteInBatch(religionList);
	}

	public void deleteReligion(long id) {
		religionRepository.delete(id);
	}

	public Scheme saveScheme(Scheme scheme) {
		this.setAuditDetails(scheme);
		return schemeRepository.save(scheme);
	}

	public Scheme findScheme(Long id) {
		return schemeRepository.findOne(id);
	}

	public Scheme findSchemeByName(String name) {
		return schemeRepository.findByName(name);
	}

	public List<Scheme> findAllScheme() {
		return schemeRepository.findAll();
	}

	public List<Scheme> findAllActieScheme() {
		return schemeRepository.findByActiveTrue();
	}

	public void deleteScheme(Scheme scheme) {
		schemeRepository.delete(scheme);
	}

	public void deleteSchemeInBatch(List<Scheme> schemeList) {
		schemeRepository.deleteInBatch(schemeList);
	}

	public void deleteScheme(long id) {
		schemeRepository.delete(id);
	}

	public Year saveYear(Year year) {
		this.setAuditDetails(year);
		return yearRepository.save(year);
	}

	public Year findYear(Long id) {
		return yearRepository.findOne(id);
	}

	public Year findYearByName(String name) {
		return yearRepository.findByName(name);
	}

	public List<Year> findAllYear() {
		return yearRepository.findAll();
	}

	public List<Year> findAllActieYear() {
		return yearRepository.findByActiveTrue();
	}

	public void deleteYear(Year year) {
		yearRepository.delete(year);
	}

	public void deleteYearInBatch(List<Year> yearList) {
		yearRepository.deleteInBatch(yearList);
	}

	public void deleteYear(long id) {
		yearRepository.delete(id);
	}
}
