package com.p7.widget.dao.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GeneratorType;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name="p7_widget_categories")
public class WidgetCategoriesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long widgetCategoryId;
	
	  @Column(name="CODE")
	  private String code;
	  @Column(name="LABEL")
	  private String label;
	  @Column(name="TYPE")
	  private String type;
	  @Column(name="HEIGHT")
	  private int height;
	  @Column(name="WIDTH")
	  private int width;
	  @Column(name="BAR_CHART")
	  private int barchart;
	  @Column(name="COLUMN_CHART")
	  private int columnchart;
	  @Column(name="LINE_CHART")
	  private int linechart;
	  @Column(name="PIE_CHART")
	  private int piechart;
	  @Column(name="AREA_CHART")
	  private int areachart;
	  @Column(name="IS_LIVE")
	  private int islive;
	  @ColumnDefault("0")
	  @Column(name="STATUS")
	  private int status;
	  
	  @OneToMany(mappedBy="widgetCategoriesEntity")
	  private Set<WidgetEntity> widgetEntity;
	  
	  
	  @OneToMany(mappedBy="widgetCategoriesEntity")
	  private Set<WidgetCategoryFiltersEntity>  widgetCategoryFiltersEntity;
	  
	  

}
