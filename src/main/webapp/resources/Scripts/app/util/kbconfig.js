define('kbconfig', function(){
	var appRoot = '/eem';
	var apiRoot = appRoot + '/api/';
	var viewRoot = appRoot + '/js/app/domain/views/';
	
	var kbconfig = {
		framework : {
			appRoot: appRoot,
			imgRoot: appRoot + '/img/',
			jsRoot: appRoot + '/js/'
		},
		
		ng : {
			mainModuleName: 'kb.module.main'
		},
		api:{
			root: apiRoot,
			config:{
				student:{
					root: apiRoot + 'config/student/',
					admissionCategory : 'admissionCategory',
					admissionType: 'admissionType',
					bloodGroup: 'bloodGroup',
					boardExam: 'boardExam',
					caste: 'caste',					
					course: 'course',					
					documents: 'documents',					
					nationality: 'nationality',					
					occupation: 'occupation',					
					previousInstitute: 'previousInstitute',					
					qualifiedExam: 'qualifiedExam',					
					religion: 'religion',
					state: 'state',
					scheme: 'scheme',
					year: 'year'
				},
				receipt:{
					root: apiRoot + 'config/receipt/',
					receiptType: 'receiptType',
					headAccount: 'headAccount'
				}
			},
			student:{
				studentAdmissionConfigurations: {
					root: apiRoot + 'student/configuration/',
					admissionType: 'admissionType',
					bloodGroup: 'bloodGroup',
					boardExam: 'boardExam',
					caste: 'caste',
					category : 'category',					
					course: 'course',					
					documents: 'documents',					
					nationality: 'nationality',					
					occupation: 'occupation',					
					previousInstitute: 'previousInstitute',					
					qualifiedExam: 'qualifiedExam',					
					religion: 'religion',
					state: 'state',
					scheme: 'scheme',
					year: 'year'
				},			
				studentManagement: {
					root: apiRoot + 'student/management/',
					admissionConfig: 'admission/config'
				}
			},
			receipt:{
				receiptConfigurations: {
					root: apiRoot + 'config/receipt/',
					receiptType: 'receiptType',
					headAccount: 'headAccount'
				}
			}
		},
		view:{
			root: viewRoot,
			config:{
				student: viewRoot + 'configurations/studentAdmission/',
				receipt: viewRoot + 'configurations/receipt/'
			},
			student:{
				studentManagement: viewRoot + 'student/studentManagement/',
				studentAdmissionConfigurations: viewRoot + 'student/studentAdmissionConfigurations/'
			},
			receipt:{
				receiptConfigurations: viewRoot + 'receipt/receiptConfigurations/'
			}
		}
	};
	return kbconfig;
});