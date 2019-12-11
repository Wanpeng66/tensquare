package com.wp.web;

import com.wp.entity.Result;
import com.wp.entity.StatusCode;
import com.wp.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wp
 * @Title: SpitController
 * @Description: TODO
 * @date 2019/12/10 21:30
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    SpitService spitService;

    @GetMapping
    public Result findAll(){
        return new Result( true, StatusCode.OK.getStatus(),"查询成功",spitService.findAll() );
    }

    @GetMapping("/thumbup/{spitId}")
    public Result thumbup(@PathVariable("spitId") String id){
        StatusCode result = spitService.thumbup(Long.valueOf( id ));
        return new Result( true,result.getStatus(),result.getText(),null );
    }


}
