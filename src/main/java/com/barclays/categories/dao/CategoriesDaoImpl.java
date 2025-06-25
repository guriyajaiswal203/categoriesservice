package com.barclays.categories.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.barclays.categories.model.CategoriesDao;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;

@Component
public class CategoriesDaoImpl implements  ICategoriesDao {

	@Override
	public CategoriesDaoResponse getCategories(CategoriesDaoRequest categoriesReq) {
		
		System.out.println("entered into Dao");
		
		// TODO : write the dao code to communicate with database and get the list of categories
		
		CategoriesDaoResponse daoResp = new CategoriesDaoResponse();
		
		daoResp.setDbrespCode("0");
		daoResp.setDbrespMsg("success");
		
		List<CategoriesDao> categoriesDaoList = new ArrayList<CategoriesDao>();
		
		CategoriesDao  categoriesDao1 = new CategoriesDao();		
			categoriesDao1.setId("111");
			categoriesDao1.setName("Electronics");
			categoriesDao1.setDesc("good");
			categoriesDao1.setExpDate("31/12/2025");
			categoriesDao1.setType("cat001");
			categoriesDao1.setStatus("active");

		CategoriesDao  categoriesDao2 = new CategoriesDao();		
			categoriesDao2.setId("222");
			categoriesDao2.setName("lifestyle");
			categoriesDao2.setDesc("good");
			categoriesDao2.setExpDate("31/12/2025");
			categoriesDao2.setType("cat002");
			categoriesDao2.setStatus("active");				

		CategoriesDao  categoriesDao3 = new CategoriesDao();		
			categoriesDao3.setId("333");
			categoriesDao3.setName("Entertainment");
			categoriesDao3.setDesc("good");
			categoriesDao3.setExpDate("31/12/2025");
			categoriesDao3.setType("cat003");
			categoriesDao3.setStatus("active");

		CategoriesDao  categoriesDao4 = new CategoriesDao();		
			categoriesDao4.setId("444");
			categoriesDao4.setName("jewel");
			categoriesDao4.setDesc("good");
			categoriesDao4.setExpDate("31/12/2025");
			categoriesDao4.setType("cat004");
			categoriesDao4.setStatus("active");			

		CategoriesDao  categoriesDao5 = new CategoriesDao();		
			categoriesDao5.setId("555");
			categoriesDao5.setName("travel");
			categoriesDao5.setDesc("good");
			categoriesDao5.setExpDate("31/12/2025");
			categoriesDao5.setType("cat005");
			categoriesDao5.setStatus("active");
			
			categoriesDaoList.add(categoriesDao1);	
			categoriesDaoList.add(categoriesDao2);
			categoriesDaoList.add(categoriesDao3);
			categoriesDaoList.add(categoriesDao4);
			categoriesDaoList.add(categoriesDao5);
		
			
		
		daoResp.setCategoriesDao(categoriesDaoList);
		System.out.println("exit from Dao");
		return daoResp;
	}

	

}
