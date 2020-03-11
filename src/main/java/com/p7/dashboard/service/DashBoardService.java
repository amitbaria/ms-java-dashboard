package com.p7.dashboard.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.p7.dashboard.dao.entity.*;


public interface DashBoardService {
	
	 public Map<String,DashBoardEntity>  showAllDashBoardRecords();
	 public long addOneRecord(DashBoardEntity   record);
	 public void setMultipleRecord(List<DashBoardEntity>  records);
	 public Optional<DashBoardEntity> showSingleRecordById(long id);
	 public long editDashBoardById(long id,DashBoardEntity DashBoardPojo);
	 public long deleteDashBoardById(long id);
	 
}