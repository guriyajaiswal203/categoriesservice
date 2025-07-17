package com.barclays.categories.dao;

import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;
import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.model.CategoriesResponse;

public interface ICategoriesDao {
	
	public CategoriesDaoResponse getCategories(CategoriesDaoRequest categoriesDaoReq) throws BusinessException, SystemException;

}
