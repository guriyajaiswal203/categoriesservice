package com.barclays.categories.exception;

import lombok.Data;

@Data
public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1637513848509885594L;
	
	
	public String respcode;
	public String respMsg;
	public BusinessException(String respcode, String respMsg) {
		
		this.respcode = respcode;
		this.respMsg = respMsg;
	}
	
}
