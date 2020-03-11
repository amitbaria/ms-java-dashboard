package com.p7.widget.dao.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.p7.dashboard.dao.entity.DashBoardEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "P7_WIDGET")
public class WidgetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long widgetId;

	

	@Column(name = "X_POS")
	private double xPos;

	@Column(name = "Y_POS")
	private double yPos;

	@Column(name = "HEIGHT")
	private double height;

	@Column(name = "WIDTH")
	private double width;

	@Column(name = "LABEL_NAME")
	private String labelName;

	@Column(name = "IS_DELETED")
	private int isDeleted;

	@Column(name = "GRAPH_TYPE")
	private String graphType;

	@Column(name = "DRAGANDDROP")
	private int dragAndDrop;
	@Column(name = "RESIZABLE")
	private int resizable;

	@Column(name = "REFRESH_INTERVAL")
	private int refreshInterval;

	@Column(name = "BILLING_ACCOUNT_UUID")
	private String billingAccountuuid;
	
	@ManyToOne
	@JoinColumn(name = "DASHBOARD_ID")
	private DashBoardEntity dashboard;
	
	
	@OneToMany(mappedBy="widgetEntity")
	private Set<WidgetPayloadEntity> widgetPayloadEntity;
	

	@ManyToOne
	@JoinColumn(name="WIDGET_CATEGORY_ID")
	private WidgetCategoriesEntity  widgetCategoriesEntity;
	
	
}
