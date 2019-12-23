package com.wp.service;

import com.wp.dao.ArticelDao;
import com.wp.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author: wp
 * @Title: ArticleService
 * @Description: TODO
 * @date 2019/12/19 20:43
 */
@Service
public class ArticleService {

    @Autowired
    ArticelDao articelDao;


    public void save( Article article ){
        articelDao.save( article );
    }

    public Page<Article> findByKey( String key, int page, int size ) {
        Page<Article> byTitleOrContent = articelDao.findByTitleOrContent( key, key, PageRequest.of( page - 1, size ) );
        return byTitleOrContent;
    }
}
