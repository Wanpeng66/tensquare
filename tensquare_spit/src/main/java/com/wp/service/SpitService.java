package com.wp.service;

import com.mongodb.client.result.UpdateResult;
import com.wp.dao.SpitDao;
import com.wp.entity.StatusCode;
import com.wp.pojo.Spit;
import com.wp.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: wp
 * @Title: SpitService
 * @Description: TODO
 * @date 2019/12/10 21:25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SpitService {
    @Autowired
    SpitDao spitDao;
    @Autowired
    IdWorker idWorker;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    public List<Spit> findAll(){
        return spitDao.findAll();
    }

    public Spit findById(String id){
        return spitDao.findById( id ).get();
    }

    public Spit save(Spit spit){
        spit.set_id( idWorker.nextId()+"" );
        Spit save = spitDao.save( spit );
        return save;
    }

    public Spit update(Spit spit){
        Spit save = spitDao.save( spit );
        return save;
    }

    public void removeById(String id ){
        spitDao.deleteById( id );
    }

    public StatusCode thumbup( Long id ) {
        SetOperations setOperations = redisTemplate.opsForSet();
        Boolean member = setOperations.isMember( "spit-thumbup-userid", id );
        if(!member){
            Query query = new Query(  );
            query.addCriteria( Criteria.where( "_id" ).is( id ) );
            Update update = new Update();
            update.inc( "thumbup",1 );
            UpdateResult spit = mongoTemplate.updateFirst( query, update, "spit" );
            setOperations.add( "spit-thumbup-userid", id );
            return StatusCode.OK;
        }
        return StatusCode.REPERROR;
    }
}
