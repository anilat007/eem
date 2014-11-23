package com.kbit.eem.constants;

public class ApiPaths {
	public static final String root = "/api";
	public static final String add = "/add";
	public static final String remove = "/remove";
	public static final String update = "/update";
	public static final String active = "/active";

	public class Config {
		public static final String root = ApiPaths.root + "/config";

		public class Student {
			public static final String root = Config.root + "/student";
			public static final String admissionCategory = root + "/admissionCategory";
			public static final String admissionType = root + "/admissionType";			
			public static final String bloodGroup = root + "/bloodGroup";
			public static final String boardExam = root + "/boardExam";			
			public static final String caste = root + "/caste";
			public static final String course = root + "/course";
			public static final String documents = root + "/documents";
			public static final String nationality = root + "/nationality";
			public static final String occupation = root + "/occupation";
			public static final String previousInstitute = root + "/previousInstitute";
			public static final String qualifiedExam = root + "/qualifiedExam";
			public static final String religion = root + "/religion";
			public static final String state = root + "/state";
			public static final String scheme = root + "/scheme";
			public static final String year = root + "/year";
		}
		
		public class Receipt {
			public static final String root = Config.root + "/receipt";
			public static final String receiptType = root + "/receiptType";
			public static final String headAccount = root + "/headAccount";
		}
	}
	
	public class Student{
		public static final String root = ApiPaths.root + "/student";
		
		public class Configuration{
			public static final String root = Student.root + "/configuration";
			
			public static final String admissionType = root + "/admissionType";			
			public static final String bloodGroup = root + "/bloodGroup";
			public static final String boardExam = root + "/boardExam";			
			public static final String caste = root + "/caste";
			public static final String category = root + "/category";
			public static final String course = root + "/course";
			public static final String document = root + "/document";
			public static final String language = root + "/language";
			public static final String nationality = root + "/nationality";
			public static final String occupation = root + "/occupation";
			public static final String previousInstitute = root + "/previousInstitute";
			public static final String qualifiedExam = root + "/qualifiedExam";
			public static final String religion = root + "/religion";
			public static final String state = root + "/state";
			public static final String scheme = root + "/scheme";
			public static final String year = root + "/year";
		}
		
		public class Management {
			public static final String root = Student.root + "/management";
			public static final String admission = Management.root + "/admission";	
		}
	}
}
