package com.wp.dao;

import com.wp.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: wp
 * @Title: ArticelDao
 * @Description: TODO
 * @date 2019/12/19 20:30
 */
@Repository
public interface ArticelDao extends ElasticsearchRepository<Article,String> {
    public Page<Article> findByTitleOrContent( String title, String content, Pageable pageable );
}
