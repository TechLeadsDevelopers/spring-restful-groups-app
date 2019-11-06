package com.spring.restful.groups.app.validator;

import java.util.List;

public class ApiInputError {
	private String code;
	private List<ApiFieldError> errors;
	public ApiInputError() {
	}
	public ApiInputError(String code, List<ApiFieldError> errors) {
		this.code = code;
		this.errors = errors;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<ApiFieldError> getErrors() {
		return errors;
	}
	public void setErrors(List<ApiFieldError> errors) {
		this.errors = errors;
	}
	

}
