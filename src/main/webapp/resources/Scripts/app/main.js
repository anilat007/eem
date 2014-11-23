require.config({
	paths:{
		'angular' :  '../lib/angular/angular',//'../lib/angular/angular.min',
		'ngAnimate': '../lib/angular/angular-animate',//'../lib/angular/angular-animate.min',
		'ngRoute':   '../lib/angular/angular-route', //'../lib/angular/angular-route.min',
		'ngSanitize':'../lib/angular/angular-sanitize',//'../lib/angular/angular-sanitize.min',
		'ngResource':'../lib/angular/angular-resource',
		
		'jquery' : '../lib/jquery/jquery-1.7.1',//'../lib/jquery/jquery-1.7.1.min',		
		'bootstrapUI': '../lib/angular/others/ui-bootstrap-0.11.0.min',
		'once': '../lib/angular/others/once',
		
		'i18n' : '../lib/i18next/i18next.amd-1.7.3',

		'mainModule' : './kb.module.main',
		'kbDirectives' : './directives/kbDirectives',
		'kbFactory' : './factories/kbFactory',
		'RepositoryFactory' : './factories/RepositoryFactory',
		'ModalProvider': './factories/ModalProvider',
		'kbCommonProviders': './factories/kbCommonProviders',
		
		'helper' : './util/helper',
		'kbconfig' : './util/kbconfig',
		
		'RepositoryCtrlHelper' : './domain/RepositoryCtrlHelper',
		'RRModel' : './domain/RequestResponseModel'
	},

	shim:{
		'angular' : {
			exports : 'angular'
		},
		'ngAnimate':{
			deps: ['angular'],
			exports: 'ngAnimate'
		},
		'ngRoute':{
			deps: ['angular'],
			exports: 'ngRoute'
		},
		'ngResource':{
			deps: ['angular'],
			exports: 'ngResource'
		},		
		'bootstrapUI':{
			deps: ['angular'],
			exports: 'bootstrapUI'
		},		
		'once':{
			deps: ['angular'],
			exports: 'once'
		},
		'kbCommonProviders':{
			deps: ['angular'],
			exports: 'kbCommonProviders'	
		}
	}
});

// Load jQuery here before angular to override jqLite
require(['i18n', 'kbconfig', 'jquery'], function (i18n, kbconfig, $) {
	i18n.init({
        lng: "en",
        fallbackLng : false,
        ns : "menu",
        //useLocalStorage: true,
        //localStorageExpirationTime: 86400000 // in ms, default 1 week
        resGetPath: (kbconfig.framework.appRoot + "/js/app/locales/__lng__/__ns__.json")
        //dynamicLoad: true
    }, function(){
    	i18n.loadNamespace("common", function(){
    		startApp();
    	});
    });
});

function startApp(){
	// Load mainModule
	require(['mainModule']);
}