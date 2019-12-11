package com.wp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wp.pojo.Enterprise;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
@Repository
public interface EnterpriseDao extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise>{
	public List<Enterprise> findByIshotOrderByIdDesc(String ishot);


}
