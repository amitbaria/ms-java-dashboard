package com.p7.widget.service.serviceImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p7.controller.WidgetController;
import com.p7.dashboard.dao.entity.*;
import com.p7.dashboard.service.*;
import com.p7.widget.dao.entity.WidgetCategoriesEntity;
import com.p7.widget.service.WidgetCategoriesService;
import com.p7.widget.service.convertor.WidgetCategoriesConvertor;
import com.p7.widget.service.model.WidgetUtil;
import com.p7.widget.service.model.WidgetCategories;
import com.p7.widget.service.model.responsemodel.WidgetCategoriesResponse;
import com.p7.widget.dao.repository.*;
import com.p7.widget.service.*;

@Service
public class WidgetCategoriesServiceImp implements  WidgetCategoriesService {

	private static final Logger LOGGER = Logger.getLogger(WidgetCategoriesServiceImp.class);
	@Autowired
	private WidgetCategoriesRepository WidgetCategoriesRepositoty;
	 
	@Override
	public List<WidgetCategoriesEntity> getAllWidgetCategories() {
	    List<WidgetCategoriesEntity>  categories	=WidgetCategoriesRepositoty.findAll();
		return categories;
	}

	@Override
	public long addp7WidgetCategory(WidgetCategoriesEntity WidgetCategoriesPojo) {
		  WidgetCategoriesPojo =	WidgetCategoriesRepositoty.save(WidgetCategoriesPojo);
		  if(WidgetCategoriesPojo.getWidgetCategoryId()>0)
			  return WidgetCategoriesPojo.getWidgetCategoryId();
		  else
		      return 0;
	}

	@Override
	public List<String> getAllWidgetCategoryCodes() {
		
		LOGGER.info("1");
	    List<String>   codes	=WidgetCategoriesRepositoty.findWidgetCategoryCodes();
	       
	    LOGGER.info("2"+codes);
		return codes;
	}
	
	@Override
	public  WidgetCategoriesResponse getCategoryResponse()
	{
		
		    WidgetCategoriesResponse response =null;
		    Map<String, List<WidgetCategories>>  categories=new WidgetCategoriesResponse().widgetCategoriesResponse(getAllWidgetCategoryCodes(),getAllWidgetCategories());  
		    
		    LOGGER.info("yes here................1");
		    
		    if(categories!=null && categories.size()>0)
		    {
		    	LOGGER.info("yes here................2");
		    	response=  new WidgetCategoriesResponse();
			    response.setData(categories);
		    }
		    return response;
			
	}
	
	
	
	
	public String calltest()
	{
		
	   
	    
	    
		return new WidgetCategoriesResponse().Test(getAllWidgetCategoryCodes());
	}
	
}
