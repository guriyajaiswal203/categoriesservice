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
		
	}

	
	

}
