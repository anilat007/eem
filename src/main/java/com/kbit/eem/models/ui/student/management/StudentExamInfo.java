package com.kbit.eem.models.ui.student.management;

public class StudentExamInfo {
	private boolean isFresher;
	private long examDetailId;
	private String admissionNo;
	private String quaExamRegNo;
	private int quaExamId;
	private String quaExamPassingYear;
	private int quaExamBoardId;
	private int quaExamStateId;
	private int previousInstituteId;
	private int totalMarks;
	private int scoredMarks;
	private float scoredPercentage;
	private String medium;
	private String firstLanguage;
	private String secondLanguage;
	
	public boolean isFresher() {
		return isFresher;
	}
	public void setFresher(boolean isFresher) {
		this.isFresher = isFresher;
	}
	public long getExamDetailId() {
		return examDetailId;
	}
	public void setExamDetailId(long examDetailId) {
		this.examDetailId = examDetailId;
	}
	public String getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	public String getQuaExamRegNo() {
		return quaExamRegNo;
	}
	public void setQuaExamRegNo(String quaExamRegNo) {
		this.quaExamRegNo = quaExamRegNo;
	}
	public int getQuaExamId() {
		return quaExamId;
	}
	public void setQuaExamId(int quaExamId) {
		this.quaExamId = quaExamId;
	}
	public String getQuaExamPassingYear() {
		return quaExamPassingYear;
	}
	public void setQuaExamPassingYear(String quaExamPassingYear) {
		this.quaExamPassingYear = quaExamPassingYear;
	}
	public int getQuaExamBoardId() {
		return quaExamBoardId;
	}
	public void setQuaExamBoardId(int quaExamBoardId) {
		this.quaExamBoardId = quaExamBoardId;
	}
	public int getQuaExamStateId() {
		return quaExamStateId;
	}
	public void setQuaExamStateId(int quaExamStateId) {
		this.quaExamStateId = quaExamStateId;
	}
	public int getPreviousInstituteId() {
		return previousInstituteId;
	}
	public void setPreviousInstituteId(int previousInstituteId) {
		this.previousInstituteId = previousInstituteId;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getScoredMarks() {
		return scoredMarks;
	}
	public void setScoredMarks(int scoredMarks) {
		this.scoredMarks = scoredMarks;
	}
	public float getScoredPercentage() {
		return scoredPercentage;
	}
	public void setScoredPercentage(float scoredPercentage) {
		this.scoredPercentage = scoredPercentage;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getFirstLanguage() {
		return firstLanguage;
	}
	public void setFirstLanguage(String firstLanguage) {
		this.firstLanguage = firstLanguage;
	}
	public String getSecondLanguage() {
		return secondLanguage;
	}
	public void setSecondLanguage(String secondLanguage) {
		this.secondLanguage = secondLanguage;
	}
}
