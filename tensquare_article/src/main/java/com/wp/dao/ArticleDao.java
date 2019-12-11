package com.wp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wp.pojo.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
@Repository
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{
	@Query(nativeQuery = true,
            value = " UPDATE tb_article SET state = 1 WHERE id = :id ")
    public void updateState( @Param("id") String id);

	@Query(nativeQuery = true,
            value = " UPDATE tb_article SET thumbup=thumbup+1 WHERE id = :id ")
	public void incrGood(@Param("id") String id);
}
