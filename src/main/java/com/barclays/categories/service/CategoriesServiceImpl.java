package com.barclays.categories.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.categories.dao.ICategoriesDao;
import com.barclays.categories.model.CardServiceClientReq;
import com.barclays.categories.model.CardServiceClientRes;
import com.barclays.categories.model.Categories;
import com.barclays.categories.model.CategoriesDao;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;
import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.model.StatusBlock;
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
		    request.setCardNum(categoriesReq.getCardNum());
		    request.setClientId(categoriesReq.getClientId());		   
		    request.setReqId(categoriesReq.getReqId()); 
		    request.setMsgTs(categoriesReq.getMsgTs());
		
	    // 3. call cardVerifyService
		    CardServiceClientRes cardVerifyResp = cardVerifySvcClient.cardVerify(request);
		    
	   // 4. apply the business logic on cardVerifyResp
		    
		    CategoriesDaoResponse categoriesdaoResp = null;	
		    
		    if("active".equals(cardVerifyResp.getStatus())) {		    
	        // 5. prepare the request for integration layer - 2. categories dao		    
		    CategoriesDaoRequest categoriesDaoReq = new CategoriesDaoRequest();
		    categoriesDaoReq.setCardNum(categoriesReq.getCardNum());
		    categoriesDaoReq.setClientId(categoriesReq.getClientId());
		    
	  // 6. call dao and get the response 
		  categoriesdaoResp = categoriesDao.getCategories(categoriesDaoReq);		    
		    }
		    
	 // 7. prepare  the categories response - with the help of service client and dao		    
		    CategoriesResponse categoriesResp = new CategoriesResponse();
		    
		    StatusBlock statusBlock = new StatusBlock();
		    statusBlock.setRespCode(categoriesdaoResp.getDbrespCode());
		    statusBlock.setRespMsg(categoriesdaoResp.getDbrespMsg());	
		    
		    categoriesResp.setStatus(statusBlock);	
		   
		    List<Categories> categoriesList = new ArrayList<Categories>();
		    
		    //get the list of categories from dao  and assign  to service categories
		    for(CategoriesDao catDao : categoriesdaoResp.getCategoriesDao() ) {
		    	
		    	Categories categories = new Categories();
		    	categories.setId(catDao.getId());
		    	categories.setName(catDao.getName());
		    	categories.setStatus(catDao.getStatus());
		    	categories.setType(catDao.getType());
		    	categories.setExpDate(catDao.getExpDate());
		    	categories.setDesc(catDao.getDesc());
		    	categoriesList.add(categories);    	
		    	
		    }	
		    
		    		    
		    categoriesResp.setCategories(categoriesList);    
		
		    return  categoriesResp;
	}

}
