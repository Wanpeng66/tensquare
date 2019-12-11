package com.wp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wp.pojo.Channel;
import org.springframework.stereotype.Repository;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
@Repository
public interface ChannelDao extends JpaRepository<Channel,String>,JpaSpecificationExecutor<Channel>{
	
}
