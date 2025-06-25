package com.barclays.categories.serviceclient;

import org.springframework.stereotype.Component;

import com.barclays.categories.model.CardServiceClientReq;
import com.barclays.categories.model.CardServiceClientRes;

@Component
public class CardVerifyServiceClientImpl implements ICardVerifyServiceClient {

	@Override
	public CardServiceClientRes cardVerify(CardServiceClientReq request) {
		
		// TODO : write the rest client code to call card verify service
		
		CardServiceClientRes cardServiceClientResp = new CardServiceClientRes(); 
		
		cardServiceClientResp.setRespCode("0");
		cardServiceClientResp.setRespMsg("success");
		cardServiceClientResp.setStatus("active");
		
		return cardServiceClientResp;
	}

}
