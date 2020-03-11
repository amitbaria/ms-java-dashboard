package com.p7.dashboard.dao.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;

import com.p7.widget.dao.entity.WidgetEntity;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="p7_dashboard")
public class DashBoardEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="ID")
  	 private long dashboardId; 
     
     @Column(name="NAME")
     @NotEmpty(message = "first name must not be empty")
	 private String name;
     @Column(name="CODE")
	 private String 	code;
     @Column(name="IS_PRIMARY")
	 private String 	isPrimary;
     @Column(name="USER_ID")
	 private String 	userId;
     @Column(name="IS_DELETED")
	 private int	isDeleted;
     
     @Column(name="CREATED_ON")
	 private Date 	createdOn;
     @Column(name="MODIFIED_ON")
	 private Date	modifiedOn;
     @Column(name="IS_DEFAULT")
	 private String isDefault;
     
	 @OneToMany(mappedBy = "dashboard")
	 private Set<WidgetEntity> widgetentity; 
}


