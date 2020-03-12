package com.p7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import org.junit.runners.MethodSorters;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.aspectj.weaver.Checker;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.p7.controller.WidgetController;
import com.p7.widget.dao.entity.WidgetCategoriesEntity;
import com.p7.widget.dao.repository.WidgetCategoriesRepository;
import com.p7.widget.service.WidgetCategoriesService;
import com.p7.widget.service.model.WidgetCategories;
import com.p7.widget.service.model.responsemodel.WidgetCategoriesResponse;
import com.p7.widget.service.serviceImp.WidgetCategoriesServiceImp;

import ch.qos.logback.core.boolex.Matcher;

import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)   
@SpringBootTest
public class MainTest {
	
	 private static final Logger LOGGER = Logger.getLogger(MainTest.class);
	
	
public	MainTest()
	{}

	  @MockBean
	  private WidgetCategoriesRepository widgetCategoriesRepository;
	 
	  @MockBean
	  private  WidgetCategoriesResponse  response;
	 
	  @Autowired
	  private WidgetCategoriesServiceImp messageService;

	  private List<String>  expectedResult=null;
	   
	  private WidgetCategoriesResponse expectedResponse=null;
	   
	  private  Map<String,List<WidgetCategories>>  apiTest=null;
	 private    List<WidgetCategoriesEntity> data=null;
	   
	   
	   
	   @Before
	   public void mockwidgetCategoryPresentation()
	   {
		   expectedResult =Arrays.asList("Index","alerts","Health");
	   }
	   
	   @Before
	   public void mockwidgetCagegoriesDataPresentation()
	   {
		 data=new ArrayList<>();
		 for(int i=1;i<=6;i++)
		 {
			 WidgetCategoriesEntity categories=new WidgetCategoriesEntity();
			 
			 if(i<=3)
			 {
			     categories.setCode("index");
			 }
			 else
			 {
				 categories.setCode("health");
			 }   
			     categories.setWidgetCategoryId(i);
			     categories.setType("type");
			     categories.setLabel("label");
			     categories.setHeight(2);
			     categories.setWidth(44);
			     categories.setBarchart(2);
			     categories.setBarchart(1);
			     categories.setLinechart(6);
			     categories.setAreachart(7);
			     categories.setPiechart(7);
			     categories.setIslive(9);
			     data.add(categories); 
			 }
			 expectedResponse=new WidgetCategoriesResponse();
			 apiTest=new HashMap<String,List<WidgetCategories>>();
		     List<WidgetCategories>  index=new ArrayList<WidgetCategories>();
		     List<WidgetCategories>  health=new ArrayList<WidgetCategories>();
		     
		     
		     for(int i=1;i<=6;i++)
			 {
				 WidgetCategories categories=new WidgetCategories();
				 
				 if(i<=3)
				 {
				     categories.setCode("index");
				     categories.setId(String.valueOf(i));
				     categories.setType("type");
				     categories.setLabel("label");
				     categories.setHeight("2");
				     categories.setWidth("44");
				     categories.setBar_chart("barchart");
				     categories.setBar_chart("Column_Chart");
				     categories.setLine_chart("line_Chart");
				     categories.setArea_chart("area chart");
				     categories.setPie_chart("Pi chart");
				     categories.setIs_live("1");
				     index.add(categories); 
				 }
				 else
				  {
					 categories.setCode("health");
					 categories.setId(String.valueOf(i));
				     categories.setType("type");
				     categories.setLabel("label");
				     categories.setHeight("2");
				     categories.setWidth("44");
				     categories.setBar_chart("barchart");
				     categories.setBar_chart("Column_Chart");
				     categories.setLine_chart("line_Chart");
				     categories.setArea_chart("area chart");
				     categories.setPie_chart("Pi chart");
				     categories.setIs_live("1");
				     health.add(categories); 
				   }   
				     
				 }
				   apiTest.put("index",index);
				   apiTest.put("health",health); 
		           expectedResponse.setData(apiTest);
		   
	   }
	   
	  @Test
	  public void testAllWidgetCategoryCodes() {
		  	// Step1  Data Presentation....
	        //  Data Structure presentation for Mock Repository......
		    when(widgetCategoriesRepository.findWidgetCategoryCodes()).thenReturn(expectedResult);
		      // Step 2
		    // Business Logic Service Method Call
		    List<String>  actualResult    = messageService.getAllWidgetCategoryCodes();
		    
		    //  Step 3. Verify Method...
		    verify(widgetCategoriesRepository, times(1)).findWidgetCategoryCodes();  
		    assertNotNull(actualResult);
		    assertEquals(3, actualResult.size());
		    assertEquals(expectedResult,actualResult);
	   }
	 
	 @Test
     public void testWidgetCategoriesAPIData() throws Exception
     {

				// when(response.widgetCategoriesResponse(  expectedResult,  
//				 org.mockito.Matchers.any(List.class),  org.mockito.Matchers.any(List.class))).thenReturn(apiTest);
//		     
		     /*    List<WidgetCategoriesEntity> entity=new ArrayList<>(); */
				  
				  
		  /*   when(response.widgetCategoriesResponse(expectedResult, data)).thenReturn(apiTest);
				    
		     
              // Business Logic Service Method Call
	        WidgetCategoriesResponse actualResult  = messageService.getCategoryResponse();
	        
	        LOGGER.info("actual Result is"+actualResult);
	        assertThat(actualResult).isNotNull();
	        
		    if(actualResult!=null)
		    {
		    	 LOGGER.info("passed.......");
		    	// assertEquals(expectedResponse,actualResult);
		    }
		    else
		    {
		    	 LOGGER.info(actualResult);
		    	
		    }
		   */
		    
		    
		      // when(WidgetCategoriesResponse.Test(Mockito.<String>anyList())).thenReturn("test");
		    
			    List<String>  list=Arrays.asList("abc","pqr");
			    String expected="abcpqr";
	       	    when(response.Test(list)).thenReturn(expected);
			    String actual =messageService.calltest(list);
			    LOGGER.info(actual+" ..........................................");
			    Assertions.assertEquals(expected, actual);
     }		
}


