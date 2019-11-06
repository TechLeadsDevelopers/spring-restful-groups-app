package com.spring.restful.groups.app.validator;

import java.util.Arrays;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GroupValidator {
	private ApiInputError apiInputError;
	ApiFieldError apiFieldError;
	
	@ExceptionHandler(value=NumberFormatException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public @ResponseBody ApiInputError validateNumberFormatException(NumberFormatException nfe) {
		apiFieldError=new ApiFieldError("id", "Please enter postive integer value");
		 apiInputError=new ApiInputError("400-123", Arrays.asList(apiFieldError));
		 return apiInputError;
	}

	@ExceptionHandler(value=EmptyResultDataAccessException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public @ResponseBody ApiInputError validateEmptyResultDataException(EmptyResultDataAccessException erdae) {
		apiFieldError=new ApiFieldError("id", "Resource is not found");
		apiInputError=new ApiInputError("401-123", Arrays.asList(apiFieldError));
		return apiInputError;
	}
	
	@ExceptionHandler(value=Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiError handleAnyOtherException(Exception e){
		ApiError apiError=new ApiError("500-123", Arrays.asList(e.getLocalizedMessage()));
		return apiError;
	}
}
