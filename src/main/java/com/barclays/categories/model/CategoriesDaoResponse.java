package com.barclays.categories.model;

import java.util.List;

import lombok.Data;

@Data
public class CategoriesDaoResponse {
	
		private String dbrespCode;
		private String dbrespMsg;
		
		
		private List<CategoriesDao> categoriesDao;
		
		
		
	

}
