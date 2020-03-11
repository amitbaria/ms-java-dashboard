package com.p7.widget.service.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

public class WidgetUtil {
	// put Unique Code in set Collection....

        private static final Logger LOGGER = Logger.getLogger(WidgetUtil.class);
		public  static Set<String>  getAllCodesFromWidgetCategories(final List<String> widgetcodes)
		{
		      Set<String> set=new HashSet<>();
		      for(String  code:widgetcodes)
		    	  set.add(toUpperCase(getCode( code)));
			  return set;
		}
		
		// Seperate the WidgetCategory code from '_'
		public static String getCode(final String code)
		{
			 int index= code.trim().indexOf('_');
	         if(index==0||index==-1)	
	        	 return code;
	         else
			  {
				  String codeName=code.substring(0,index);
				  return codeName;
			  }
		}
		
		public static String toLowerCase(String msg) {
		      return msg.toLowerCase();}
		
		public static String toUpperCase(String msg) {
		    return msg.toUpperCase();}
		
}
