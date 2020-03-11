package com.p7.dashboard.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p7.dashboard.dao.entity.*;

@Repository
public interface  DashBoardRepository  extends JpaRepository<DashBoardEntity,Long> {
	
	
	
}