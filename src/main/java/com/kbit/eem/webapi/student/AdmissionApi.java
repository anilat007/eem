package com.kbit.eem.webapi.student;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kbit.eem.DBModel.Category;
import com.kbit.eem.constants.ApiPaths;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;
import com.kbit.eem.service.student.StudentConfigurationService;
import com.kbit.eem.utils.DBException;
import com.kbit.eem.utils.Helper;

@Controller
@RequestMapping(ApiPaths.Student.Management.admission)
public class AdmissionApi {
	static Logger logger = Logger.getLogger(AdmissionApi.class);

	@Autowired
	StudentConfigurationService studentConfigurationService;
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public @ResponseBody JSonResponse get(){
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllCategory()));
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}
	
	@RequestMapping(value="/getActive", method=RequestMethod.GET)
	public @ResponseBody JSonResponse getActive(){
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findAllActieCategory()));
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}
	
	@RequestMapping(value="/getByName", method=RequestMethod.GET)
	public @ResponseBody JSonResponse getByName(@RequestBody String name){
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.findCategoryByName(name)));
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody JSonResponse save(@RequestBody Category category){
		try {
			return new JSonResponse(new JsonSuccessModel(
					studentConfigurationService.saveCategory(category)));
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public @ResponseBody JSonResponse delete(@RequestBody Category category){
		try {
			studentConfigurationService.deleteCategory(category);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}
	
	@RequestMapping(value="/deleteById", method=RequestMethod.DELETE)
	public @ResponseBody JSonResponse deleteById(@RequestBody long id){
		try {
			studentConfigurationService.deleteCategory(id);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse getAdmissionConfig() {
		try {
			//return new JSonResponse(new JsonSuccessModel(getAdmssionConfigLists()));
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}

	/*private AdmissionConfigLists getAdmssionConfigLists() throws DBException,
			IllegalAccessException, InvocationTargetException, Exception {
		AdmissionConfigLists lists = new AdmissionConfigLists();

		// Student Details Lists
		List<AdmissionType> admissionTypeList = new ArrayList<AdmissionType>();
		for (AdmissionTypeSO so : studentConfigurationService
				.GetAdmissionTypeList()) {
			AdmissionType uo = new AdmissionType();
			BeanUtils.copyProperties(uo, so);
			admissionTypeList.add(uo);
		}
		lists.setAdmissionTypeList(admissionTypeList);

		List<Course> courseList = new ArrayList<Course>();
		for (CourseSO so : studentConfigurationService.GetCourseList()) {
			Course uo = new Course();
			BeanUtils.copyProperties(uo, so);
			courseList.add(uo);
		}
		lists.setCourseList(courseList);

		List<Year> yearList = new ArrayList<Year>();
		for (YearSO so : studentConfigurationService.GetYearList()) {
			Year uo = new Year();
			BeanUtils.copyProperties(uo, so);
			yearList.add(uo);
		}
		lists.setYearList(yearList);

		List<BloodGroup> bloodGroupList = new ArrayList<BloodGroup>();
		for (BloodGroupSO so : studentConfigurationService.GetBloodGroupList()) {
			BloodGroup uo = new BloodGroup();
			BeanUtils.copyProperties(uo, so);
			bloodGroupList.add(uo);
		}
		lists.setBloodGroupList(bloodGroupList);

		List<Religion> religionList = new ArrayList<Religion>();
		for (ReligionSO so : studentConfigurationService.GetReligionList()) {
			Religion uo = new Religion();
			BeanUtils.copyProperties(uo, so);
			religionList.add(uo);
		}
		lists.setReligionList(religionList);

		List<Caste> casteList = new ArrayList<Caste>();
		for (CasteSO so : studentConfigurationService.GetCasteList()) {
			Caste uo = new Caste();
			BeanUtils.copyProperties(uo, so);
			casteList.add(uo);
		}
		lists.setCasteList(casteList);

		List<AdmissionCategory> admissionCategoryList = new ArrayList<AdmissionCategory>();
		for (AdmissionCategorySO so : studentConfigurationService
				.GetAdmissionCategoryList()) {
			AdmissionCategory uo = new AdmissionCategory();
			BeanUtils.copyProperties(uo, so);
			admissionCategoryList.add(uo);
		}
		lists.setAdmissionCategoryList(admissionCategoryList);

		List<Scheme> schemeList = new ArrayList<Scheme>();
		for (SchemSO so : SchemeService.Get_Items()) {
			Scheme uo = new Scheme();
			BeanUtils.copyProperties(uo, so);
			schemeList.add(uo);
		}
		lists.setSchemeList(schemeList);

		// Exam Details Lists
		List<BoardExam> boardExamList = new ArrayList<BoardExam>();
		for (BoardExamSO boardExamSO : studentConfigurationService
				.GetBoardExamList()) {
			BoardExam boardExam = new BoardExam();
			BeanUtils.copyProperties(boardExam, boardExamSO);
			boardExamList.add(boardExam);
		}
		lists.setBoardExamList(boardExamList);

		List<QualifiedExam> qualifiedExamList = new ArrayList<QualifiedExam>();
		for (QualifiedExamSO so : studentConfigurationService
				.GetQualifiedExamList()) {
			QualifiedExam uo = new QualifiedExam();
			BeanUtils.copyProperties(uo, so);
			qualifiedExamList.add(uo);
		}
		lists.setQualifiedExamList(qualifiedExamList);

		List<State> stateList = new ArrayList<State>();
		for (StateSO so : studentConfigurationService.GetStateList()) {
			State uo = new State();
			BeanUtils.copyProperties(uo, so);
			stateList.add(uo);
		}
		lists.setStateList(stateList);

		List<PreviousInstitute> previousInstituteList = new ArrayList<PreviousInstitute>();
		for (PreviousInstituteSO so : studentConfigurationService
				.GetPreviousInstituteList()) {
			PreviousInstitute uo = new PreviousInstitute();
			BeanUtils.copyProperties(uo, so);
			previousInstituteList.add(uo);
		}
		lists.setPreviousInstituteList(previousInstituteList);

		List<Language> languageList = new ArrayList<Language>();
		for (LanguageSO so : studentConfigurationService.GetLanguageList()) {
			Language uo = new Language();
			BeanUtils.copyProperties(uo, so);
			languageList.add(uo);
		}
		lists.setLanguageList(languageList);
		lists.setMediumList(languageList);
		lists.setLanguageList(languageList);

		// Family Details Lists
		List<Occupation> occupationList = new ArrayList<Occupation>();
		for (OccupationSO so : studentConfigurationService.GetOccupationList()) {
			Occupation uo = new Occupation();
			BeanUtils.copyProperties(uo, so);
			occupationList.add(uo);
		}
		lists.setOccupationList(occupationList);

		return lists;
	}
*/
}
