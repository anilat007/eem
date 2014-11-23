define(['i18n', 'angular','bootstrapUI'], function (i18n) {
	angular.module('kbDirectives', ['kbButtonModule','kbIconModule','kbPlaceholderModule','kbIntegerInputModule','kbCalenderModule', 'kbToggleSwitchModule']);

    angular.module('kbButtonModule', []).directive('kbButton', function () {
        var templates = {
            "submit": { template: '<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-flash"></span>{{text}}</button>', text: i18n.t('common:sumbit') },
            "add": { template: '<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus-sign"></span> {{text}}</button>', text: i18n.t('common:add') },
            "addandnew": { template: '<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus-sign"></span> {{text}}</button>', text: i18n.t('common:addAndNew') },
            "save": { template: '<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-floppy-save"></span> {{text}}</button>', text: i18n.t('common:save') },
            "edit": { template: '<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span> {{text}}</button>', text: i18n.t('common:edit') },
            "update": { template: '<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-floppy-save"></span> {{text}}</button>', text: i18n.t('common:update') },
            "delete": { template: '<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span> {{text}}</button>', text: i18n.t('common:delete') },
            "reset": { template: '<button type="button" class="btn btn-default">{{text}}</button>', text: i18n.t('common:reset') },
            "ok": { template: '<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span> {{text}}</button>', text: i18n.t('common:ok') },
            "cancel": { template: '<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove-sign"></span> {{text}}</button>', text: i18n.t('common:cancel') },
            "refresh": { template: '<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-refresh"></span> {{text}}</button>', text: i18n.t('common:refresh') },
            "default": { template: '<button type="button" class="btn btn-default">{{text}}</button>', text: 'Text not set' }
        };

        return {
            restrict: 'E',
            replace: true,
            template: function (elem, attrs) {
                var btntype = (attrs["btntype"] || "default").toLowerCase();
                var currTemplate = templates[btntype];
                var text = attrs["text"] || currTemplate.text;
                return currTemplate.template.replace("{{text}}", text);
            }
        };
    });

    angular.module('kbIconModule', []).directive('kbIcon', function () {
        var templates = {
    		"add": { template: '<span class="kb-icon text-info glyphicon glyphicon-plus-sign" title="{{title}}"></span>', title: i18n.t('common:add') },
            "edit": { template: '<span class="kb-icon text-info glyphicon glyphicon-pencil" title="{{title}}"></span>', title: i18n.t('common:edit') },
            "delete": { template: '<span class="kb-icon text-danger glyphicon glyphicon-remove" title="{{title}}"></span>', title: i18n.t('common:delete') }
        };

        return {
            restrict: 'E',
            replace: true,
            template: function (elem, attrs) {
                var icontype = (attrs["icontype"] || "default").toLowerCase();
                var currTemplate = templates[icontype];
                var title = attrs["title"] || currTemplate.title;
                return currTemplate.template.replace("{{title}}", title);
            }
        };
    });

    angular.module('kbPlaceholderModule', []).directive("kbPlaceholder", function () {
        return {
            restrict: 'A',
            scope: {
                kbPlaceholder: "@kbPlaceholder",
            },

            link: function (scope, element) {
                var ph = scope.kbPlaceholder;
                element.attr('placeholder', ph);
            }
        };
    });
    
    angular.module('kbIntegerInputModule', []).directive('input', function () {
    	return {
            restrict: 'E',
            require: 'ngModel',
            link: function (scope, element, attr, ctrl) {
                if (attr.type !== 'integer')
                    return;

                var min = parseInt(attr.min, 10), max = parseInt(attr.max, 10);
                var rxInteger = /^[-]?\d+$/;
                var validate = function (validationType, value, isValid) {
                    if (isValid) {
                        ctrl.$setValidity(validationType, true);
                        return value === '' ? null : (ctrl.$isEmpty(value) ? value : parseInt(value, 10));
                    } else {
                        ctrl.$setValidity(validationType, false);
                        return undefined;
                    }
                };

                ctrl.$parsers.push(function (value) {
                    return validate('integer', value, ctrl.$isEmpty(value) || rxInteger.test(value));
                });
                ctrl.$formatters.push(function (value) {
                    return ctrl.$isEmpty(value) ? '' : '' + value;
                });

                if (!isNaN(min)) {
                    var minValidator = function(value) {
                        return validate('min', value, ctrl.$isEmpty(value) || (rxInteger.test(value) && parseInt(value, 10) >= min));
                    };
                    ctrl.$parsers.push(minValidator);
                    ctrl.$formatters.push(minValidator);
                }
                if (!isNaN(max)) {
                    var maxValidator = function(value) {
                        return validate('max', value, ctrl.$isEmpty(value) || (rxInteger.test(value) && parseInt(value, 10) <= max));
                    };
                    ctrl.$parsers.push(maxValidator);
                    ctrl.$formatters.push(maxValidator);
                }
            }
        };
    });

    angular.module('kbCalenderModule', ['ui.bootstrap']).controller('kbCalenderController', function($scope, $attrs){//, calenderConfig){
        var $this = this;

        this.init = function (element) {
            $scope.isOpen = angular.isDefined($attrs.isOpen) ? $scope.$parent.$eval($attrs.isOpen) : false;
        }

        // Allow other directives to watch status
        this.isOpen = function() {
            return $scope.isOpen;
        };

        $scope.toggleOpen = this.toggleOpen = function($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.isOpen = !$scope.isOpen;
        };
    }).directive('kbCalender', function(){
        return {
            restrict: 'E',
            replace: true,
            scope:{
                'ngModel' : '=',
                'format' : '@',
                'maxDate':'@',
                'ngRequired':'@'
            },
            require:['ngModel','kbCalender'],
            template : function(iElm, iAttrs){
                var checkAttrs = ['id', 'name', 'disabled'];
                var strAttrs = '';
                for (var i = checkAttrs.length - 1; i >= 0; i--) {
                    if(iAttrs[checkAttrs[i]]){
                        strAttrs += checkAttrs[i] + '="' + iAttrs[checkAttrs[i]]  + '" ';
                    }
                };

                var t =
                    '<div class="input-group">' + 
                        '<input type="text" ' + strAttrs + ' ng-model="ngModel" ng-required="{{ngRequired}}" class="form-control" style="background-color:#ffffff !important" ' +
                            'datepicker-popup="{{format}}" max-date="{{maxDate}}" placeholder="{{format}}" datepicker-options="dateOptions" is-open="isOpen" />' +
                        '<span class="input-group-btn">' +
                            '<button class="btn btn-default" ng-click="toggleOpen($event)">' +
                                '<i class="glyphicon glyphicon-calendar"></i>' +
                            '</button>' +
                        '</span>' + 
                    '</div>';
                return t;
            },

            controller: 'kbCalenderController',

            link: function($scope, iElm, iAttrs, ctrls) {
                ctrls[1].init();
            },

            compile: function (iElm, iAttrs) {
                if(!iAttrs.format){
                    var dateFormat = i18n.t('common:date.format');
                    iAttrs.format = iAttrs.placeholder = dateFormat;
                }
            }
        };
    });

    angular.module('kbToggleSwitchModule', []).directive('kbToggleSwitch', function(){
        var uid = (function(){
            var counter = 0;
            var currentId;

            return{
                next : function() {
                    ++counter;
                    currentId = 'kbToggleSwitch' + counter;
                    return currentId;
                },

                current : function() {
                    if(!currentId)
                        uid.next();

                    return currentId;
                }
            };
        })();
        
        var linker = function (scope, iElm, iAttrs) {
            var id = iAttrs.id ? iAttrs.id + '_container' : '';
            var name = iAttrs.name ? iAttrs.name + '_container' : '';
            iElm.attr({'id': id, 'name':name});
        };

        var getTemplate = function (iElm, iAttrs) {
            var id = iAttrs['id'] || uid.next();
            var name = iAttrs['name'];
            var attrs = 'id="' + id + '"';
            if(name) attrs += ' name="' + name + '"';

            var t =
                '<span class="kb-switch">' + 
                    '<input type="checkbox" ' + attrs + ' ng-model="ngModel" ng-disabled="isDisabled">' + 
                    '<label for="' + id + '" class="kb-switch-widget">' + 
                        '<span class="kb-switch-button"></span>' + 
                        '<span class="kb-switch-text">' + 
                            '<span class="kb-switch-text-on" ng-bind="textOn"></span>' + 
                            '<span class="kb-switch-text-off" ng-bind="textOff"></span>' + 
                        '</span>' + 
                    '</label>' + 
                '</span>';
                    
            if(iAttrs.textLabel){
                var textLabel = '<label for="' + id + '" ng-bind="textLabel"></label>';
                if(iAttrs.labelPosition && iAttrs.labelPosition == 'before')
                    t = textLabel + t;
                else
                    t += textLabel;
            }
            t = '<span class="kb-switch-container">' + t + '</span>';
            return t;
        };

        return {
            restrict: 'E',
            replace: true,
            require:'ngModel',
            scope: {
                ngModel: '=',
                textOn: '@',
                textOff : '@',
                textLabel : '@',
                isDisabled: '@'
            },
            template: getTemplate,
            link: linker
        };
    });
});