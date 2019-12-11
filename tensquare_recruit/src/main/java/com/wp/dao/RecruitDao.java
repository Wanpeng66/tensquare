package com.wp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wp.pojo.Recruit;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
@Repository
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
	public List<Recruit> findTop6ByStateIsorderbOrderByCreatetimeDesc(String state);


    public List<Recruit> findTop6ByStateIsNotorderbOrderByCreatetimeDesc(String state);
}
