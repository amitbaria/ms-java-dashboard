package com.p7.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p7.dashboard.service.*;
import com.p7.exception.widgetException.WidgetCategoryNotFoundException;
import com.p7.widget.dao.entity.WidgetCategoriesEntity;
import com.p7.widget.service.WidgetCategoriesService;

import com.p7.widget.service.model.responsemodel.WidgetCategoriesResponse;
import com.p7.dashboard.dao.entity.*;

@RestController
@RequestMapping("/api")
public class WidgetController {
	
	@Autowired
	private WidgetCategoriesService widgetCategoriesService;
	

      private static final Logger LOGGER = Logger.getLogger(WidgetController.class);
	
	@GetMapping(value="/dashboard/widget-categories",produces="application/json")
	public ResponseEntity<Object>  getAllwidgetCategories()
	{
		WidgetCategoriesResponse response=  widgetCategoriesService.getCategoryResponse();	
		
		  if(response!=null)
		  {
			  
			 LOGGER.info("Response is not Null");
			 return new ResponseEntity<Object>(response,HttpStatus.OK);
		  }
		  else
			 throw new WidgetCategoryNotFoundException();
		
	}
	
	@PostMapping(value="/dashboard/widget-categories")
	public ResponseEntity<Object>  addp7WidgetCategory(@RequestBody WidgetCategoriesEntity WidgetCategoriesPojo)
	 {
		long pk=widgetCategoriesService.addp7WidgetCategory(WidgetCategoriesPojo);
		  if(pk!=0)
		  {
			 return new ResponseEntity<Object>(pk+ " Category added Successfully",HttpStatus.OK);
		  }
		  else
			 return new ResponseEntity<Object>("Not added ......",HttpStatus.OK);
		
	  }
	

}
