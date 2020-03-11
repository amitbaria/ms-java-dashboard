package com.p7.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.p7.exception.dashboardException.DashBoardNotFoundException;

@ControllerAdvice
class DashBoardGlobalException extends ResponseEntityExceptionHandler 
{
	
   @ExceptionHandler(DashBoardNotFoundException.class)
   public ResponseEntity<Object>  dashBoardNotFound(DashBoardNotFoundException ex, WebRequest request)
   {
	   
	   Map<String, Object> body = new LinkedHashMap<>();
       body.put("timestamp", LocalDateTime.now());
       body.put("message", "Dashboard Id not found");   return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
   }

}
