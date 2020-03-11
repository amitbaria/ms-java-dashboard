package com.p7.widget.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p7.widget.dao.entity.WidgetFiltersEntity;

@Repository
public interface WidgetFiltersRepository extends JpaRepository<WidgetFiltersEntity,Long> {

}
