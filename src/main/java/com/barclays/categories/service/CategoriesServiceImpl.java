package com.barclays.categories.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.categories.dao.ICategoriesDao;
import com.barclays.categories.model.CardServiceClientReq;
import com.barclays.categories.model.CardServiceClientRes;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;
import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.serviceclient.ICardVerifyServiceClient;

@Component
public class CategoriesServiceImpl implements ICategoriesService {
	
	@Autowired
	ICardVerifyServiceClient cardVerifySvcClient;
	
	@Autowired
	ICategoriesDao categoriesDao;

	@Override
	public CategoriesResponse getCategories(CategoriesRequest categoriesReq) {
		
		// 1. get the request from controller
	    // 2. prepare the request for integration layer - 1 cardVerifyService
		    CardServiceClientReq request = new CardServiceClientReq();
		
	    // 3. call cardVerifyService
		    CardServiceClientRes cardVerifyResp = cardVerifySvcClient.cardVerify(request);
		    
	   // 4. apply the business logic on cardVerifyResp
		    
	  // 5. prepare the request for integration layer - 2. categories dao
		    
		    CategoriesDaoRequest categoriesDaoReq = new CategoriesDaoRequest();
		    
	  // 6. call dao and get the response 
		    CategoriesDaoResponse categoriesDaoResp = categoriesDao.getCategories(categoriesDaoReq);
		    
	 // 7. prepare  the categories response - with the help of service client and dao
		    
		
		return null;
	}

}
