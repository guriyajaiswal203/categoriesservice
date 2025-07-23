package com.barclays.categories.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.categories.builder.CategoriesRequestBuilder;
import com.barclays.categories.builder.CategoriesResposneBuilder;
import com.barclays.categories.dao.ICategoriesDao;
import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.SystemException;
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
	@Autowired
	CategoriesRequestBuilder requestBuilder;
	@Autowired
	CategoriesResposneBuilder respBuilder;

	@Override
	public CategoriesResponse getCategories(CategoriesRequest categoriesReq) throws BusinessException, SystemException {

		System.out.println("Entered into service");

		// 1. get the request from controller
		// 2. call request Builder for cardserviceclient request preparation

		CardServiceClientReq cardSvcClientRequest = requestBuilder.buildCardSvcClientRequest(categoriesReq);

		// 3. call cardVerifyService
		CardServiceClientRes cardVerifyResp = cardVerifySvcClient.cardVerify(cardSvcClientRequest);

		// 4. apply the business logic on cardVerifyResp

		CategoriesDaoResponse categoriesdaoResp = null;

		if ("active".equals(cardVerifyResp.getStatus())) {
			// 5. call request Builder for categories dao request preparation

			CategoriesDaoRequest categoriesDaoRequest = requestBuilder.buildDaoRequest(categoriesReq);

			// 6. call dao and get the response
			categoriesdaoResp = categoriesDao.getCategories(categoriesDaoRequest);
		}

		// 7. call responseBuilder to build categories  dao response
		CategoriesResponse categoriesResp = respBuilder.buildCategoriesResp(categoriesdaoResp, cardVerifyResp);

		System.out.println("Exit from service");

		return categoriesResp;
	}

}
