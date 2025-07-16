package com.barclays.categories.exception;

import lombok.Data;

@Data
public class SystemException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2426587469095762748L;
	public String respcode;
	public String respMsg;
	public SystemException(String respcode, String respMsg) {
		
		this.respcode = respcode;
		this.respMsg = respMsg;
	}
	

}
