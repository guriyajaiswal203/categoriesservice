package com.barclays.categories.validator;

import org.springframework.stereotype.Component;

import com.barclays.categories.exception.CategoriesRequestInvalidException;
import com.barclays.categories.model.CategoriesRequest;

//import com.barclays.categories.model.CategoriesRequest;

@Component
public class CategoriesRequestValidator {

	public void validateRequest(CategoriesRequest categoriesReq) throws CategoriesRequestInvalidException {
		// TODO Auto-generated method stub
		
		if(categoriesReq == null) {
			throw new CategoriesRequestInvalidException("cat001","Invalid request object");
		}
		
		if(categoriesReq.getCardNum() == null || " ".equals(categoriesReq.getCardNum()) || 
				categoriesReq.getCardNum().length() < 16) {
			throw new CategoriesRequestInvalidException("cat002", "invalid card number");
		}
		
		if(categoriesReq.getClientId() == null || " ".equals(categoriesReq.getClientId())){
			throw new CategoriesRequestInvalidException("cat003", "invalid client Id");
		}
		
		if(categoriesReq.getChannelId() == null || " ".equals(categoriesReq.getChannelId())){
			throw new CategoriesRequestInvalidException("cat004", "invalid channel Id");
		}
		
		
	}

	
	

}
