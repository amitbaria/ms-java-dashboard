package com.p7.widget.service.convertor;

import java.util.Date;

import org.apache.log4j.Logger;

import com.p7.widget.dao.entity.WidgetCategoriesEntity;
import com.p7.widget.service.model.WidgetCategories;

public class WidgetCategoriesConvertor {
	

    private static final Logger LOGGER = Logger.getLogger(WidgetCategoriesConvertor.class);
	public  static WidgetCategoriesEntity   toWidgetCategoriesEntity(final WidgetCategories widgetCategories)
	{
		WidgetCategoriesEntity  entity=new WidgetCategoriesEntity();
		
		 entity.setWidgetCategoryId(Long.valueOf(widgetCategories.getId()));
		 entity.setCode(widgetCategories.getCode());
		 entity.setType(widgetCategories.getType());
		 entity.setLabel(widgetCategories.getLabel());
		 entity.setHeight(Integer.valueOf(widgetCategories.getHeight()));
		 entity.setWidth(Integer.valueOf(widgetCategories.getWidth()));
		 entity.setBarchart((Integer.valueOf(widgetCategories.getBar_chart())));
		 entity.setColumnchart((Integer.valueOf(widgetCategories.getColumn_chart())));
		 entity.setLinechart((Integer.valueOf(widgetCategories.getLine_chart())));
		 entity.setPiechart((Integer.valueOf(widgetCategories.getPie_chart())));
		 entity.setAreachart((Integer.valueOf(widgetCategories.getArea_chart())));
		 entity.setIslive((Integer.valueOf(widgetCategories.getIs_live())));
		
		return entity;
	}
	
	public static WidgetCategories toWidgetCategories(final WidgetCategoriesEntity widgetCategoriesEntity)
	{
		 WidgetCategories  widgetCategories=new WidgetCategories();
		 
		 widgetCategories.setId(String.valueOf(widgetCategoriesEntity.getWidgetCategoryId()));
		 widgetCategories.setCode(widgetCategoriesEntity.getCode());
		 widgetCategories.setType(widgetCategoriesEntity.getType());
		 widgetCategories.setLabel(widgetCategoriesEntity.getLabel());
		 widgetCategories.setHeight(String.valueOf(widgetCategoriesEntity.getHeight()));
		 widgetCategories.setWidth(String.valueOf(widgetCategoriesEntity.getHeight()));
		 widgetCategories.setBar_chart((String.valueOf(widgetCategoriesEntity.getBarchart())));
		 widgetCategories.setColumn_chart((String.valueOf(widgetCategoriesEntity.getColumnchart())));
		 widgetCategories.setLine_chart((String.valueOf(widgetCategoriesEntity.getLinechart())));
		 widgetCategories.setPie_chart((String.valueOf(widgetCategoriesEntity.getPiechart())));
		 widgetCategories.setArea_chart((String.valueOf(widgetCategoriesEntity.getAreachart())));
		 widgetCategories.setIs_live((String.valueOf(widgetCategoriesEntity.getIslive())));
		
		        
		 return widgetCategories;
	}
	
	

}

