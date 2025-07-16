package com.barclays.categories.exception;

import lombok.Data;

@Data
public class CategoriesRequestInvalidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2374093529784543783L;
	public String respcode;
	public String respMsg;
	public CategoriesRequestInvalidException(String respcode, String respMsg) {
		
		this.respcode = respcode;
		this.respMsg = respMsg;
	}
	
	
	
	
}
