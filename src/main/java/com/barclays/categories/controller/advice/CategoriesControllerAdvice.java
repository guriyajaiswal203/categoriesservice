package com.barclays.categories.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.CategoriesRequestInvalidException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.model.StatusBlock;

@ControllerAdvice
public class CategoriesControllerAdvice {

	@ExceptionHandler(value = CategoriesRequestInvalidException.class)
	@ResponseBody
	public CategoriesResponse handleException(CategoriesRequestInvalidException exception) {

		CategoriesResponse categoriesResp = buildStatusBlock(exception.getRespcode(), exception.getRespMsg());

		return categoriesResp;

	}

	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public CategoriesResponse handleDataError(BusinessException exception) {

		return buildStatusBlock(exception.getRespcode(), exception.getRespMsg());

	}

	@ExceptionHandler(value = SystemException.class)
	@ResponseBody
	public CategoriesResponse handleException(SystemException exception) {

		return buildStatusBlock(exception.getRespcode(), exception.getRespMsg());
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public CategoriesResponse handleGenericException(Exception exception) {

		return buildStatusBlock("8888", "unknown error from service");
	}

	private CategoriesResponse buildStatusBlock(String Respcode, String RespMsg) {

		CategoriesResponse categoriesResp = new CategoriesResponse();
		StatusBlock status = new StatusBlock();
		status.setRespCode(Respcode);
		status.setRespMsg(RespMsg);

		categoriesResp.setStatus(status);
		return categoriesResp;
	}
}
