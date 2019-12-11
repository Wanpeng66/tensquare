package com.wp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wp.pojo.Problem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
@Repository
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    @Query(nativeQuery = true,
            value = "SELECT * from tb_problem p,tb_pl pl where p.id = pl.problemid and pl.labelid = :labelId ORDER BY p.replytime desc ")
    public Page<Problem> newList( @Param( "labelId" ) String labelId, Pageable page );

    @Query(nativeQuery = true,
            value = "SELECT * from tb_problem p,tb_pl pl where p.id = pl.problemid and pl.labelid = :labelId ORDER BY p.reply desc ")
    public Page<Problem> hotList(@Param( "labelId" ) String labelId, Pageable page);

    @Query(nativeQuery = true,
            value = "SELECT * from tb_problem p,tb_pl pl where p.id = pl.problemid and pl.labelid = :labelId and p.reply = 0 ORDER BY p.createtime desc ")
    public Page<Problem> waitList(@Param( "labelId" ) String labelId, Pageable page);
}
