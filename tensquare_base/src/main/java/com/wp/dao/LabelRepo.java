package com.wp.dao;

import com.wp.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: wp
 * @Title: LabelRepo
 * @Description: TODO
 * @date 2019/12/5 20:39
 */
@Repository
public interface LabelRepo extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {

}
