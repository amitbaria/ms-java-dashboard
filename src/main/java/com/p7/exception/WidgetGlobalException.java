package com.p7.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.p7.exception.dashboardException.DashBoardNotFoundException;
import com.p7.exception.widgetException.WidgetCategoryNotFoundException;
@ControllerAdvice
public class WidgetGlobalException extends ResponseEntityExceptionHandler  {

       private static final Logger LOGGER = Logger.getLogger(WidgetGlobalException.class);
	   @ExceptionHandler(WidgetCategoryNotFoundException.class)
	   public ResponseEntity<Object>  widgetCategoryNotFound(WidgetCategoryNotFoundException ex, WebRequest request)
	   {
		   
		   Map<String, Object> body = new LinkedHashMap<>();
	       body.put("timestamp", LocalDateTime.now());
	       body.put("message", "Widget Categories not found");   
	       return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
	   }

}
