package com.barclays.categories.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.barclays.categories.model.CardServiceClientRes;
import com.barclays.categories.model.Categories;
import com.barclays.categories.model.CategoriesDao;
import com.barclays.categories.model.CategoriesDaoResponse;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.model.StatusBlock;

@Component
public class CategoriesResposneBuilder {
      /**Description : this method  is used to build categories success response with the 
       *               help of dao response and cardservice response
       * @param categoriesdaoResp
       * @param cardVerifyResp
       * @return categoriesResponse 
	  */
	public CategoriesResponse buildCategoriesResp(CategoriesDaoResponse categoriesdaoResp,
			CardServiceClientRes cardVerifyResp) {
		
		CategoriesResponse categoriesResp = new CategoriesResponse();

		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(categoriesdaoResp.getDbrespCode());
		statusBlock.setRespMsg(categoriesdaoResp.getDbrespMsg());

		categoriesResp.setStatus(statusBlock);

		List<Categories> categoriesList = new ArrayList<Categories>();

		// get the list of categories from dao and assign to service categories
		for (CategoriesDao catDao : categoriesdaoResp.getCategoriesDao()) {

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
		return categoriesResp;
	}
	
	/*  Description : this method is used to build the categories error  response
	   * @param respcode
       * @param respmsg
       * @return categoriesResponse 
	 */
	
	public CategoriesResponse buildCategoriesResp(String Respcode, String RespMsg) {

		CategoriesResponse categoriesResp = new CategoriesResponse();
		StatusBlock status = new StatusBlock();
		status.setRespCode(Respcode);
		status.setRespMsg(RespMsg);

		categoriesResp.setStatus(status);
		return categoriesResp;
	}
		
	}



