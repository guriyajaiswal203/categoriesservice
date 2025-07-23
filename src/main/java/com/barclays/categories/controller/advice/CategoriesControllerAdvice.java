package com.barclays.categories.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barclays.categories.builder.CategoriesRequestBuilder;
import com.barclays.categories.builder.CategoriesResposneBuilder;
import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.CategoriesRequestInvalidException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.model.StatusBlock;
import com.barclays.categories.util.CategoriesConstant;

@ControllerAdvice
public class CategoriesControllerAdvice {
 
	@Autowired
	CategoriesResposneBuilder respBuilder;
	
	@ExceptionHandler(value = CategoriesRequestInvalidException.class)
	@ResponseBody
	public CategoriesResponse handleException(CategoriesRequestInvalidException exception) {

		
		return respBuilder.buildCategoriesResp(exception.getRespcode(), exception.getMessage());

	}

	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public CategoriesResponse handleDataError(BusinessException exception) {

		return respBuilder.buildCategoriesResp(exception.getRespcode(), exception.getRespMsg());

	}

	@ExceptionHandler(value = SystemException.class)
	@ResponseBody
	public CategoriesResponse handleException(SystemException exception) {

		return respBuilder.buildCategoriesResp(exception.getRespcode(), exception.getRespMsg());
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public CategoriesResponse handleGenericException(Exception exception) {

		return respBuilder.buildCategoriesResp(CategoriesConstant.GEN_ERROR_CODE, CategoriesConstant.GEN_ERROR_MSG);
	}

	
}
