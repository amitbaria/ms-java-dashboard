package com.p7.widget.service;

import java.util.List;
import com.p7.widget.dao.entity.WidgetCategoriesEntity;
import com.p7.widget.service.model.responsemodel.WidgetCategoriesResponse;



public interface WidgetCategoriesService {
	
	public List<WidgetCategoriesEntity> getAllWidgetCategories();
    public long addp7WidgetCategory(WidgetCategoriesEntity p7WidgetCategoriesPojo);
    public  List<String>  getAllWidgetCategoryCodes();
    public WidgetCategoriesResponse  getCategoryResponse();

}
