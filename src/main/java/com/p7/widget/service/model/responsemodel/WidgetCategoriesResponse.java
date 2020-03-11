package com.p7.widget.service.model.responsemodel;




/* Amit
   24/2/2020
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.p7.widget.dao.entity.WidgetCategoriesEntity;

import com.p7.widget.service.convertor.WidgetCategoriesConvertor;
import com.p7.widget.service.model.WidgetUtil;
import com.p7.widget.service.serviceImp.WidgetCategoriesServiceImp;
import com.p7.widget.service.model.WidgetCategories;


import lombok.Getter;
import lombok.Setter;

public  class WidgetCategoriesResponse {
	
	private static final Logger LOGGER = Logger.getLogger(WidgetCategoriesResponse.class);
	private Map<String, List<WidgetCategories>> data;
	public  Map<String, List<WidgetCategories>> getData() {
		return data;
	}
	public void setData(Map<String, List<WidgetCategories>>  data) {
		this.data=data;
	}

	/**
	 * @param widgetCategoriesCodes
	 * @param allCategoriesRecords
	 * @return
	 */
	public   Map<String, List<WidgetCategories>> widgetCategoriesResponse(List<String> widgetCategoriesCodes,List<WidgetCategoriesEntity> allCategoriesRecords)
	{
		    
		widgetCategoriesCodes.forEach(n->{System.out.println("................................"+n);});
		
	    Map<String, List<WidgetCategories>>  categories=new HashMap<>();
	    Set<String> uniqueCodes	=WidgetUtil.getAllCodesFromWidgetCategories(widgetCategoriesCodes);
	    uniqueCodes.forEach(uniqueCode->{
	    	   //   Category Filtered
	           List<WidgetCategoriesEntity> codes =  allCategoriesRecords.stream().filter(category_Code->
	           WidgetUtil.toUpperCase( WidgetUtil.getCode(category_Code.getCode().trim())).equals(uniqueCode.trim())
	           ).collect(Collectors.toList());
	    	   if(codes.size()>0)
			    {
	    		   List<WidgetCategories> cat=new ArrayList<>();
	    		   codes.forEach(widgetCategoryEntity->{
	    		   WidgetCategories category=WidgetCategoriesConvertor.toWidgetCategories(widgetCategoryEntity);
	    		   cat.add(category);
	    		  });
	    		   if(cat.size()>0)
	    		   {  categories.put(WidgetUtil.toLowerCase(uniqueCode.trim()),cat);
	    		   }
			    }
	    	});
	   return categories;
	}
	
	
	
	public  String Test(List<String> list)
	{  
		 
		return list.get(0)+list.get(1);
	}
	
	
	
}



