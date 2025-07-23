package com.barclays.categories.util;

import lombok.Getter;

@Getter
public enum CategoriesErrorEnum {
	
	clientIdInvalid("100","invalid client id", "data error"),
	cardnumInvalid("101","invalid card number", "data error"),
	cardnumberNotMappedCvv("102","invalid card number", "data error"),
	DatabaseTimeout("333","database timeout","system error"),
	DatabaseDown("444","database down","system error");
	
	
	
	
	private  String  errorCode;
	private  String  errorMsg;
	private  String  typesOfError;
	
	CategoriesErrorEnum(String errorCode, String errorMsg, String typesOfError){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.typesOfError =typesOfError;
		 
	}
	
	public static boolean checkErrorCode(String errorCode, String errorType ) {
		
		boolean flag = false;
		for(CategoriesErrorEnum catEnum : CategoriesErrorEnum.values()) {
			
			if(catEnum.equals(catEnum.getErrorCode()) && errorType.equals(catEnum.getTypesOfError())) {
				flag= true;
			}
		}
		return false;
		
	}
	

}
