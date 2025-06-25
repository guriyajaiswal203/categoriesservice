package com.barclays.categories.model;

import java.util.List;

public class CategoriesDaoResponse {
	
		private String dbrespCode;
		private String dbrespMsg;
		
		
		private List<CategoriesDao> categoriesDao;
		public String getDbrespCode() {
			return dbrespCode;
		}
		public void setDbrespCode(String dbrespCode) {
			this.dbrespCode = dbrespCode;
		}
		public String getDbrespMsg() {
			return dbrespMsg;
		}
		public void setDbrespMsg(String dbrespMsg) {
			this.dbrespMsg = dbrespMsg;
		}
		public List<CategoriesDao> getCategoriesDao() {
			return categoriesDao;
		}
		public void setCategoriesDao(List<CategoriesDao> categoriesDao) {
			this.categoriesDao = categoriesDao;
		}
		
		
	

}
