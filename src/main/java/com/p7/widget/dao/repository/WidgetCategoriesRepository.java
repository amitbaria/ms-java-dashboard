package com.p7.widget.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.p7.dashboard.dao.entity.*;
import com.p7.widget.dao.entity.WidgetCategoriesEntity;



@Repository
public interface WidgetCategoriesRepository  extends JpaRepository<WidgetCategoriesEntity,Long> {
	
	   @Query("select distinct widgetcategory.code from WidgetCategoriesEntity widgetcategory")
	   public List<String> findWidgetCategoryCodes(); 
	
}
