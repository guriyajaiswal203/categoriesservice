package com.barclays.categories.model;

import java.util.List;

import lombok.Data;

@Data
public class CategoriesResponse {
	
	private StatusBlock	 status;
	private List<Categories> categories;
	
	
	

}
