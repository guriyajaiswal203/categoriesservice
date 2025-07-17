package com.barclays.categories.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CategoriesDao;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;

@Component
public class CategoriesDaoImpl implements  ICategoriesDao {

	@Override
	public CategoriesDaoResponse getCategories(CategoriesDaoRequest categoriesReq) throws BusinessException,SystemException {
		

		CategoriesDaoResponse daoResp = new CategoriesDaoResponse();
		System.out.println("entered into Dao");
		
		// TODO : write the dao code to communicate with database and get the list of categories
		
		//prepare the 	request for database and call db and get the response
		
		try {
			String dbRespCode="102";
			String dbRespMsg="database timeout";
			
			if("0".equals(dbRespCode)) {
				
			
			daoResp.setDbrespCode("dbRespCode");
			daoResp.setDbrespMsg(" dbRespMsg");
			
			List<CategoriesDao> categoriesDaoList = new ArrayList<CategoriesDao>();
			
			CategoriesDao  categoriesDao1 = new CategoriesDao();		
				categoriesDao1.setId("111");
				categoriesDao1.setName("Electronics");
				categoriesDao1.setType("cat001");
				categoriesDao1.setStatus("active");
				categoriesDao1.setExpDate("31/12/2025");
				categoriesDao1.setDesc("good");
			

			CategoriesDao  categoriesDao2 = new CategoriesDao();		
				categoriesDao2.setId("222");
				categoriesDao2.setName("lifestyle");
				categoriesDao2.setType("cat002");
				categoriesDao2.setStatus("active");
				categoriesDao2.setExpDate("31/12/2025");
				categoriesDao2.setDesc("good");
							

			CategoriesDao  categoriesDao3 = new CategoriesDao();		
				categoriesDao3.setId("333");
				categoriesDao3.setName("Entertainment");			
				categoriesDao3.setType("cat003");
				categoriesDao3.setStatus("active");
				categoriesDao3.setExpDate("31/12/2025");
				categoriesDao3.setDesc("good");

			CategoriesDao  categoriesDao4 = new CategoriesDao();		
				categoriesDao4.setId("444");
				categoriesDao4.setName("jewel");			 
				categoriesDao4.setType("cat004");
				categoriesDao4.setStatus("active");	
				categoriesDao4.setExpDate("31/12/2025");
				categoriesDao4.setDesc("good");

			CategoriesDao  categoriesDao5 = new CategoriesDao();		
				categoriesDao5.setId("555");
				categoriesDao5.setName("travel");			
				categoriesDao5.setType("cat005");
				categoriesDao5.setStatus("active");
				categoriesDao5.setExpDate("31/12/2025");
				categoriesDao5.setDesc("good");
				
				categoriesDaoList.add(categoriesDao1);	
				categoriesDaoList.add(categoriesDao2);
				categoriesDaoList.add(categoriesDao3);
				categoriesDaoList.add(categoriesDao4);
				categoriesDaoList.add(categoriesDao5);
			
				
			
			daoResp.setCategoriesDao(categoriesDaoList);
			}else if("100".equals(dbRespCode) ||"101".equals(dbRespCode)|| "102".equals(dbRespCode) ) {
				throw new BusinessException(dbRespCode, dbRespMsg);
			}
			
			else if("333".equals(dbRespCode) ||"444".equals(dbRespCode)|| "555".equals(dbRespCode) ) {
				throw new SystemException(dbRespCode, dbRespMsg);
			}
		} catch (BusinessException be) {			
			throw be ;
		}
		catch (SystemException se) {			
			throw se ;
		}
		
		System.out.println("exit from Dao");
		return daoResp;
	}

	

}
