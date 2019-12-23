package com.wp.web;

import com.wp.entity.PageResult;
import com.wp.entity.Result;
import com.wp.entity.StatusCode;
import com.wp.pojo.Article;
import com.wp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wp
 * @Title: ArticleController
 * @Description: TODO
 * @date 2019/12/19 20:45
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PostMapping
    public Result save( @RequestBody Article article ){
        articleService.save( article );
        return new Result( true, StatusCode.OK.getStatus(),"添加成功",null );
    }

    @GetMapping("/{key}/{page}/{size}")
    public Result findByKey(@PathVariable String key,@PathVariable int page,@PathVariable int size){
        Page<Article> pageData =  articleService.findByKey(key,page,size);
        return new Result( true,StatusCode.OK.getStatus(),"查询成功",
                new PageResult<Article>( pageData.getTotalElements(),pageData.getContent() ) );
    }
}
