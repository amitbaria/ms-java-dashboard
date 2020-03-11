package com.p7.widget.dao.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="p7_widget_filters")
public class WidgetFiltersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long widgetFiltersId;
	
	@Column(name="FILTER_NAME")
	private String filterName;
	
	
	@OneToMany(mappedBy="WidgetFilters")
	private Set<WidgetCategoryFiltersEntity>  widgetCategoryFiltersEntity;
	
	

	
	
	
}
