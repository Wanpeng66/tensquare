package com.wp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wp.pojo.Column;
import org.springframework.stereotype.Repository;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
@Repository
public interface ColumnDao extends JpaRepository<Column,String>,JpaSpecificationExecutor<Column>{
	
}
