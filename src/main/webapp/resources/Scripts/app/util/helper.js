define("helper", [], function () {
    var isString = function (value) {
        return (typeof value === "string");
    };
    var isDefined = function (value) {
        return (typeof value !== "undefined");
    };
    var isNull = function (value) {
        return (typeof value == null);
    };

    var isEmpty = function(value, trimWhitespaces) {
        if(!isDefined(value) || isNull(value)){
            return true;
        }
        if(isString(value)){
            if(trimWhitespaces === true){
                value = value.trim(); 
            }
            return value === "";
        }
        return false;
    };

    if (typeof String.prototype.trim !== "function") {
        String.prototype.trim = function () {
            return this.replace(/^\s\s*/, "").replace(/\s\s*$/, "");
        };
    }

    if (typeof String.isNullOrEmpty !== "function") {
        String.isNullOrEmpty = function (value) {
            if (!isString(value)) return false;
            return isEmpty(value);
        };
    }

    if (typeof String.isNullOrWhiteSpace !== "function") {
        String.isNullOrWhiteSpace = function (value) {
            if (!isString(value)) return false;
            return isEmpty(value, true);
        };
    }

    if (typeof String.prototype.equalsIgnoreCase !== "function") {
        String.prototype.equalsIgnoreCase = function (stringToCompare) {
            return (this.toUpperCase() == stringToCompare.toUpperCase());
        };
    }

    if (typeof Array.prototype.removeAt !== "function") {
        Array.prototype.removeAt = function (index) {
            if(index < 0 || index >= this.length){
                return [];
            }
            return this.splice(index, 1);
        };
    }

    function joinPaths() {
        var parts = arguments;
        if (parts.length == 0)
            return "";

        var separator = "/";
        var path = parts[0];
        for (var i = 1; i < parts.length; i++) {
            var part = parts[i], p1 = path.charAt(path.length - 1) == separator, p2 = part.charAt(0) == separator;
            path += (p1 && p2) ? part.substr(1) : ((p1 || p2) ? part : (separator + part));
        }
        return path;
    }

    var helper = {
        joinPaths: joinPaths,
        isEmpty: isEmpty
    };
    return helper;
});