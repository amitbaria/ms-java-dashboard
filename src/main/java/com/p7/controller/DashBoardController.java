package com.p7.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;


import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p7.dashboard.dao.entity.*;


import com.p7.dashboard.service.serviceImp.*;
import com.p7.exception.dashboardException.DashBoardNotFoundException;
import com.p7.dashboard.service.*;

@RestController
@RequestMapping("/api")
public class DashBoardController {
	
	 @Autowired
	 private DashBoardService dashBoardService;
	 
     @GetMapping("/dashboard")
	 public  ResponseEntity   getAllDashboardData()	{
	
	  Map<String,DashBoardEntity> dashboardRecords =dashBoardService.showAllDashBoardRecords();
	  if(dashboardRecords.size()>0)
	  {
		
		return  new ResponseEntity(dashBoardService.showAllDashBoardRecords(), HttpStatus.OK);
	      
	  }
		else
	  {
		return   new ResponseEntity("Record not Found", HttpStatus.OK); 
	  }
	}
     
     
     @PostMapping(value="/dashboard", consumes="application/json")
     public  ResponseEntity<DashBoardEntity>   addSingleRecordInDashBoard(@RequestBody DashBoardEntity DashBoardEntity)
     { 	
    	 
    	
    	 DashBoardEntity.setCreatedOn(new Date());
    	 DashBoardEntity.setModifiedOn(new Date());
    	 
    	
    	 if(DashBoardEntity.getIsDefault()==null ||DashBoardEntity.getIsDefault()=="".trim())
    		   DashBoardEntity.setIsDefault("0");
    	 else
	           DashBoardEntity.setIsDefault(DashBoardEntity.getIsDefault());
    	       long generatedNewPrimaryKey =  dashBoardService.addOneRecord(DashBoardEntity);
    	 
    	
    	  if(generatedNewPrimaryKey!=0)
    	  {  
    		  return   new ResponseEntity(generatedNewPrimaryKey  + "   Saved  Successfully", HttpStatus.OK); 
    	  }
    	  else
    	  {
    		  return   new ResponseEntity("Record not  Saved", HttpStatus.OK); 
    	  }
     }
     
     //  Fetch Single DashBoard Record
     @GetMapping(value="/dashboard/{dashboardId}")
     public  ResponseEntity  getDashBoardById(@PathVariable("dashboardId") int dashboardId)
     {
    	 
          Optional<DashBoardEntity>	record= dashBoardService.showSingleRecordById(dashboardId);
    
          // LOGGER.info("Record Available......"+record.isPresent()); 
    	  if(record.isPresent())
    	  {
    		     
    		 Map<String,DashBoardEntity> map=new HashMap();
    		 map.put("data",record.get());
    		 return new ResponseEntity(map,HttpStatus.OK);
    	   }
    	  else
    	        throw new DashBoardNotFoundException();
      }
     
     
     //  Edit DashBoard Record
     @PutMapping(value="/dashboard/{dashboardId}", consumes="application/json")
     public  ResponseEntity<DashBoardEntity>   editDashBoardById(@PathVariable("dashboardId") int dashboardId,
    		                                                      @RequestBody DashBoardEntity  DashBoardEntity
    		                                                       )
     	{
		      long pk	= dashBoardService.editDashBoardById(dashboardId, DashBoardEntity);
		      if(pk!=0)
		    	  return new ResponseEntity(pk  +  "    Updated Successfully",HttpStatus.OK);
		      else
		    	  return new ResponseEntity("DashBoard Not found",HttpStatus.OK);
        }
     
     
     @DeleteMapping(value="/dashboard/{dashboardId}")
     public  ResponseEntity<DashBoardEntity>   deleteDashBoardById(@PathVariable("dashboardId") int dashboardId)
    		 {
    	                if(dashBoardService.deleteDashBoardById(dashboardId)!=0)
    	               	   return new ResponseEntity(dashboardId  +  "    Deleted Successfully",HttpStatus.OK);
    	                else
  	       		    	   return new ResponseEntity("DashBoard Id Not found",HttpStatus.OK);
    	      }
}
