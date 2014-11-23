package com.kbit.eem.models.ui.student.management;

import java.util.List;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.AdmissionCategory;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.AdmissionType;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.BloodGroup;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.BoardExam;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Caste;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Course;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Occupation;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.PreviousInstitute;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.QualifiedExam;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Religion;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Scheme;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.State;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Year;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Language;

public class AdmissionConfigLists {
	List<AdmissionType> admissionTypeList;
	List<Course> courseList;
	List<Year> yearList;
	List<BloodGroup> bloodGroupList;
	List<Religion> religionList;
	List<Caste> casteList;
	List<AdmissionCategory> admissionCategoryList;
	List<Scheme> schemeList;
	
	List<BoardExam> boardExamList;
	List<QualifiedExam> qualifiedExamList;
	List<State> stateList;	
	List<PreviousInstitute> previousInstituteList;
	List<Language> mediumList;
	List<Language> languageList;
	
	List<Occupation> occupationList;
	
	public List<AdmissionType> getAdmissionTypeList() {
		return admissionTypeList;
	}
	public void setAdmissionTypeList(List<AdmissionType> admissionTypeList) {
		this.admissionTypeList = admissionTypeList;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public List<Year> getYearList() {
		return yearList;
	}
	public void setYearList(List<Year> yearList) {
		this.yearList = yearList;
	}
	public List<BloodGroup> getBloodGroupList() {
		return bloodGroupList;
	}
	public void setBloodGroupList(List<BloodGroup> bloodGroupList) {
		this.bloodGroupList = bloodGroupList;
	}
	public List<Religion> getReligionList() {
		return religionList;
	}
	public void setReligionList(List<Religion> religionList) {
		this.religionList = religionList;
	}
	public List<Caste> getCasteList() {
		return casteList;
	}
	public void setCasteList(List<Caste> casteList) {
		this.casteList = casteList;
	}
	public List<AdmissionCategory> getAdmissionCategoryList() {
		return admissionCategoryList;
	}
	public void setAdmissionCategoryList(
			List<AdmissionCategory> admissionCategoryList) {
		this.admissionCategoryList = admissionCategoryList;
	}
	public List<Scheme> getSchemeList() {
		return schemeList;
	}
	public void setSchemeList(List<Scheme> schemeList) {
		this.schemeList = schemeList;
	}
	public List<BoardExam> getBoardExamList() {
		return boardExamList;
	}
	public void setBoardExamList(List<BoardExam> boardExamList) {
		this.boardExamList = boardExamList;
	}
	public List<QualifiedExam> getQualifiedExamList() {
		return qualifiedExamList;
	}
	public void setQualifiedExamList(List<QualifiedExam> qualifiedExamList) {
		this.qualifiedExamList = qualifiedExamList;
	}
	public List<State> getStateList() {
		return stateList;
	}
	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}
	public List<PreviousInstitute> getPreviousInstituteList() {
		return previousInstituteList;
	}
	public void setPreviousInstituteList(
			List<PreviousInstitute> previousInstituteList) {
		this.previousInstituteList = previousInstituteList;
	}
	public List<Language> getMediumList() {
		return mediumList;
	}
	public void setMediumList(List<Language> mediumList) {
		this.mediumList = mediumList;
	}
	public List<Language> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(List<Language> languageList) {
		this.languageList = languageList;
	}
	public List<Occupation> getOccupationList() {
		return occupationList;
	}
	public void setOccupationList(List<Occupation> occupationList) {
		this.occupationList = occupationList;
	}	
}
