package com.wp.dao;

import com.wp.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: wp
 * @Title: SpitDao
 * @Description: TODO
 * @date 2019/12/10 21:19
 */
@Repository
public interface SpitDao extends MongoRepository<Spit,String> {
}
