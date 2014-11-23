define('RRModel', function() {
	function KBResponse(response) {
		this.httpStatus = response.status || null;
		this.isSuccess = response.success;
		//this.errors = null;
		//this.data = null;
		//this.exception = response.exception;

		if (response.errors && response.errors.length > 0) {
			this.errors = [];
			for ( var i in response.errors) {
				var errorModel = new KBErrorModel(response.errors[i]);
				this.errors.push(errorModel);
			}
		}
		if(response.success){
			if(response.model){
				this.data = new KBSuccessModel(response.model);
			}
		}else if( response.exception){
			this.exception = new KBErrorModel(response.exception);
		}
	}

	KBResponse.prototype.getData = function() {
		if(this.data && this.data.model){
			return this.data.model;
		}
		return null;
	};

	function KBErrorModel(error) {
		this.code = error.code || null;
		this.message = error.message || null;
		this.field = error.field || null;
	}
	
	function KBSuccessModel(success){
		this.message = success.message || null;
		this.redirectTo = success.redirectTo || null;
		this.model = success.data;
	}
	
	return {
		KBResponse : KBResponse
	};
});