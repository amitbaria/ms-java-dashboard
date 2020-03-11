package com.p7.dashboard.service.serviceImp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p7.dashboard.dao.entity.*;
import com.p7.dashboard.service.*;
import com.p7.dashboard.dao.repository.*;

@Service
public class DashBoardServiceImp  implements DashBoardService {

	
	@Autowired 
	private  DashBoardRepository    dashBoardRepository;
	
	// private final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(this.getClass());
	 
	@Override
	public Map<String,DashBoardEntity> showAllDashBoardRecords() {
		
		//show all records from p7 dashboard table......
		
	    Map p=	new HashMap();
	    p.put("data", dashBoardRepository.findAll());
	    return p;
	}


	@Override
	public long addOneRecord(DashBoardEntity record) {
		DashBoardEntity DashBoardPojo =dashBoardRepository.save(record);
		long primarykey= (DashBoardPojo!=null)?DashBoardPojo.getDashboardId():0 ;
		return primarykey;
		 
	}


	@Override
	public void setMultipleRecord(List<DashBoardEntity> records) {
		// TODO Auto-generated method stub
		
		
	}



	@Override
	public Optional<DashBoardEntity> showSingleRecordById(long id) {
		return  dashBoardRepository.findById(id);
		
	}


	@Override
	public long editDashBoardById(long id, DashBoardEntity DashBoardPojo) {
		Optional<DashBoardEntity>  existingEntity=	showSingleRecordById(id);
		if(existingEntity.isPresent())
		{
			
			DashBoardEntity	existingEntityNeedsToUpdate=existingEntity.get();
			existingEntityNeedsToUpdate.setName(DashBoardPojo.getName());
			existingEntityNeedsToUpdate.setCode(DashBoardPojo.getCode());
			existingEntityNeedsToUpdate.setIsPrimary(DashBoardPojo.getIsPrimary());  
			existingEntityNeedsToUpdate.setIsDefault(DashBoardPojo.getIsDefault());
			existingEntityNeedsToUpdate.setIsDeleted(DashBoardPojo.getIsDeleted());  
			existingEntityNeedsToUpdate.setModifiedOn(new Date());
           
            existingEntityNeedsToUpdate = dashBoardRepository.save(existingEntityNeedsToUpdate);
			
            return   existingEntityNeedsToUpdate.getDashboardId();
		}
		
		
		return 0;
	}


	@Override
	public long deleteDashBoardById(long id) {
		Optional<DashBoardEntity>  existingEntity=	showSingleRecordById(id);
		if(existingEntity.isPresent())
		{
		
		      dashBoardRepository.deleteById(id);
		      return 1;
		}
		else
		return 0;
		
	}


	
		    
		
		
	}
	
	

