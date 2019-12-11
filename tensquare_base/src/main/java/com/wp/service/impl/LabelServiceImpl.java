package com.wp.service.impl;

import com.wp.dao.LabelRepo;
import com.wp.pojo.Label;
import com.wp.service.LabelService;
import com.wp.util.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wp
 * @Title: LabelServiceImpl
 * @Description: TODO
 * @date 2019/12/5 20:40
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class LabelServiceImpl implements LabelService {
    @Autowired
    IdWorker idWorker;
    @Autowired
    LabelRepo labelRepo;


    @Override
    public List<Label> findAll() {
        return labelRepo.findAll( );
    }

    @Override
    public Label findById( String labelId ) {
        return labelRepo.findById( labelId ).get();
    }

    @Override
    public Label save( Label label ) {
        label.setId( idWorker.nextId()+"" );
        Label save = labelRepo.save( label );
        return save;
    }

    @Override
    public Label update( Label label ) {
        Label save = labelRepo.save( label );
        return label;
    }

    @Override
    public void deleteById( String labelId ) {
        labelRepo.deleteById( labelId );
    }

    @Override
    public List<Label> findSearch( Label label ) {
       return  labelRepo.findAll( new Specification<Label>() {
            @Override
            public Predicate toPredicate( Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb ) {
                List<Predicate> lists = new ArrayList<>(  );
                if(StringUtils.isNotBlank( label.getLabelname() )){
                    Predicate labelname = cb.like( root.get( "labelname" ).as( String.class ), "%" + label.getLabelname() + "%" );
                    lists.add( labelname );
                }
                if(StringUtils.isNotBlank( label.getState() )){
                    Predicate state = cb.equal( root.get( "state" ).as( String.class ), label.getState() );
                    lists.add( state );
                }
                if(null!=label.getCount()){
                    Predicate count = cb.equal( root.get( "count" ).as( Long.class ), label.getCount() );
                    lists.add( count );
                }
                if(null!=label.getFans()){
                    Predicate fans = cb.equal( root.get( "fans" ).as( Long.class ), label.getFans() );
                    lists.add( fans );
                }
                if(StringUtils.isNotBlank( label.getRecommend() )){
                    Predicate recommend = cb.like( root.get( "recommend" ).as( String.class ), "%" + label.getRecommend() + "%" );
                    lists.add( recommend );
                }
                return cb.and( lists.toArray( new Predicate[lists.size()] ) );
            }
        } );
    }

    @Override
    public Page<Label> findSearchAndPage( Label label, Integer page, Integer size ) {
        return  labelRepo.findAll( new Specification<Label>() {
            @Override
            public Predicate toPredicate( Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb ) {
                List<Predicate> lists = new ArrayList<>(  );
                if(StringUtils.isNotBlank( label.getLabelname() )){
                    Predicate labelname = cb.like( root.get( "labelname" ).as( String.class ), "%" + label.getLabelname() + "%" );
                    lists.add( labelname );
                }
                if(StringUtils.isNotBlank( label.getState() )){
                    Predicate state = cb.equal( root.get( "state" ).as( String.class ), label.getState() );
                    lists.add( state );
                }
                if(null!=label.getCount()){
                    Predicate count = cb.equal( root.get( "count" ).as( Long.class ), label.getCount() );
                    lists.add( count );
                }
                if(null!=label.getFans()){
                    Predicate fans = cb.equal( root.get( "fans" ).as( Long.class ), label.getFans() );
                    lists.add( fans );
                }
                if(StringUtils.isNotBlank( label.getRecommend() )){
                    Predicate recommend = cb.like( root.get( "recommend" ).as( String.class ), "%" + label.getRecommend() + "%" );
                    lists.add( recommend );
                }
                return cb.and( lists.toArray( new Predicate[lists.size()] ) );
            }
        },PageRequest.of( page.intValue()-1,size.intValue() ) );
    }
}
