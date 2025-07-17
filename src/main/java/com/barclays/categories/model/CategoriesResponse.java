package com.barclays.categories.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class CategoriesResponse {
	
	private StatusBlock	 status;
	private List<Categories> categories;
	
	
	

}
