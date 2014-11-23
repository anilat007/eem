package com.kbit.eem.webapi.student;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.kbit.eem.constants.ApiPaths;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;
import com.kbit.eem.service.student.StudentConfigurationService;

@Controller
public class AdmissionConfigurationApi {
	static Logger logger = Logger.getLogger(AdmissionConfigurationApi.class);

	@Autowired
	StudentConfigurationService studentConfigurationService;

	@RequestMapping(value = ApiPaths.Student.Configuration.admissionType, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllAdmissionType() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllAdmissionType()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.admissionType
			+ "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAdmissionType(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAdmissionType(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.admissionType
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieAdmissionType() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieAdmissionType()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.admissionType, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveAdmissionType(@RequestBody AdmissionType admissionType) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService
							.saveAdmissionType(admissionType)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.admissionType, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteAdmissionType(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteAdmissionType(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.boardExam, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllBoardExam() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllBoardExam()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.boardExam + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findBoardExam(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findBoardExam(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.boardExam
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieBoardExam() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieBoardExam()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.boardExam, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveBoardExam(@RequestBody BoardExam boardExam) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveBoardExam(boardExam)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.boardExam, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteBoardExam(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteBoardExam(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.caste, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllCaste() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllCaste()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.caste + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findCaste(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findCaste(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.caste
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieCaste() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieCaste()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.caste, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveCaste(@RequestBody Caste caste) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveCaste(caste)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.caste, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteCaste(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteCaste(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.category, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllCategory(@RequestParam(value="activeOnly", required=false) boolean activeOnly) {
		try {
			List<Category> list = activeOnly ? studentConfigurationService.findAllActieCategory() :studentConfigurationService.findAllCategory(); 
			return new JSonResponse(new JsonSuccessModel(list));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.category + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findCategory(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findCategory(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.category, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveCategory(@RequestBody Category category) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveCategory(category)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.category + "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteCategory(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteCategory(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.course, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllCourse() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllCourse()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.course + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findCourse(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findCourse(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.course
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieCourse() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieCourse()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.course, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveCourse(@RequestBody Course course) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveCourse(course)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.course, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteCourse(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteCourse(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.document, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllDocument() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllDocument()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.document + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findDocument(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findDocument(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.document
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieDocument() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieDocument()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.document, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveDocument(@RequestBody Document document) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveDocument(document)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.document, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteDocument(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteDocument(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.language, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllLanguage() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllLanguage()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.language + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findLanguage(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findLanguage(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.language
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieLanguage() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieLanguage()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.language, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveLanguage(@RequestBody Language language) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveLanguage(language)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.language, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteLanguage(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteLanguage(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.nationality, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllNationality() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllNationality()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.nationality
			+ "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findNationality(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findNationality(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.nationality
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieNationality() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieNationality()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.nationality, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveNationality(@RequestBody Nationality nationality) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveNationality(nationality)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.nationality, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteNationality(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteNationality(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.occupation, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllOccupation() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllOccupation()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.occupation + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findOccupation(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findOccupation(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.occupation
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieOccupation() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieOccupation()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.occupation, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveOccupation(@RequestBody Occupation occupation) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveOccupation(occupation)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.occupation, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteOccupation(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteOccupation(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.previousInstitute, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllPreviousInstitute() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllPreviousInstitute()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.previousInstitute
			+ "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findPreviousInstitute(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findPreviousInstitute(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.previousInstitute
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActiePreviousInstitute() {
		try {
			return new JSonResponse(
					new JsonSuccessModel(
							studentConfigurationService
									.findAllActiePreviousInstitute()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.previousInstitute, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse savePreviousInstitute(
			@RequestBody PreviousInstitute previousInstitute) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService
							.savePreviousInstitute(previousInstitute)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.previousInstitute, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deletePreviousInstitute(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deletePreviousInstitute(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.qualifiedExam, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllQualifiedExam() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllQualifiedExam()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.qualifiedExam
			+ "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findQualifiedExam(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findQualifiedExam(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.qualifiedExam
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieQualifiedExam() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieQualifiedExam()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.qualifiedExam, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveQualifiedExam(@RequestBody QualifiedExam qualifiedExam) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService
							.saveQualifiedExam(qualifiedExam)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.qualifiedExam, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteQualifiedExam(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteQualifiedExam(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.religion, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllReligion() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllReligion()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.religion + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findReligion(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findReligion(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.religion
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieReligion() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieReligion()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.religion, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveReligion(@RequestBody Religion religion) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveReligion(religion)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.religion, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteReligion(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteReligion(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.scheme, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllScheme() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllScheme()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.scheme + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findScheme(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findScheme(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.scheme
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieScheme() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieScheme()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.scheme, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveScheme(@RequestBody Scheme scheme) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveScheme(scheme)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.scheme, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteScheme(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteScheme(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.year, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllYear() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllYear()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.year + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findYear(@PathVariable("id") Long id) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findYear(id)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.year
			+ ApiPaths.active, method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse findAllActieYear() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieYear()));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.year, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse saveYear(@RequestBody Year year) {
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveYear(year)));
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.Student.Configuration.year, method = RequestMethod.DELETE)
	public @ResponseBody
	JSonResponse deleteYear(@PathVariable("id") Long id) {
		try {
			studentConfigurationService.deleteYear(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			return new JSonResponse(e);
		}
	}
}