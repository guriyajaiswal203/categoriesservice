package com.barclays.categories.model;

import java.util.List;

public class CategoriesResponse {
	
	private StatusBlock	 status;
	private List<Categories> categories;
	
	public StatusBlock getStatus() {
		return status;
	}
	public void setStatus(StatusBlock status) {
		this.status = status;
	}
	public List<Categories> getCategories() {
		return categories;
	}
	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}
	
	

}
