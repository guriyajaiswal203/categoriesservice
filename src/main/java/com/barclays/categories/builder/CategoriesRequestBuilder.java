package com.barclays.categories.builder;

import org.springframework.stereotype.Component;

import com.barclays.categories.model.CardServiceClientReq;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.model.CategoriesResponse;

@Component
public class CategoriesRequestBuilder {

	public CardServiceClientReq buildCardSvcClientRequest(CategoriesRequest categoriesReq) {		
		
		 CardServiceClientReq cardSvcClientRequest = new CardServiceClientReq();
		 cardSvcClientRequest.setCardNum(categoriesReq.getCardNum());
		 cardSvcClientRequest.setClientId(categoriesReq.getClientId());		   
		 cardSvcClientRequest.setReqId(categoriesReq.getReqId()); 
		 cardSvcClientRequest.setMsgTs(categoriesReq.getMsgTs());
		    
		return cardSvcClientRequest;
	}

	public CategoriesDaoRequest buildDaoRequest(CategoriesRequest categoriesReq) {
		
		 CategoriesDaoRequest categoriesDaoReq = new CategoriesDaoRequest();
		    categoriesDaoReq.setCardNum(categoriesReq.getCardNum());
		    categoriesDaoReq.setClientId(categoriesReq.getClientId());
		
		return categoriesDaoReq;
	}

	

}
