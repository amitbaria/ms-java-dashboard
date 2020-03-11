package com.p7.widget.dao.entity;

import javax.persistence.*;

import lombok.*;


@Setter
@Getter
@Entity
@Table(name="p7_widget_category_filters")
public class WidgetCategoryFiltersEntity {
	
	@Id
    @Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long widgetFilterCategoryId;
	
	
	
	@ManyToOne
	@JoinColumn(name="WIDGET_FILTERS_ID")  
	private WidgetFiltersEntity  WidgetFilters;
	
	
	
	 @ManyToOne
	 @JoinColumn(name="WIDGET_CATEGORY_ID")
	 private WidgetCategoriesEntity widgetCategoriesEntity;
	 
	 @Column(name="REQUIRED")
	 private int required;
		
		
		
	
	

}


