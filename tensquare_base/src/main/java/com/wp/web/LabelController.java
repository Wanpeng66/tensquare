package com.wp.web;

import com.wp.entity.PageResult;
import com.wp.entity.Result;
import com.wp.entity.StatusCode;
import com.wp.pojo.Label;
import com.wp.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: wp
 * @Title: LabelController
 * @Description: TODO
 * @date 2019/12/5 20:05
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    LabelService labelService;

    @GetMapping
    public Result getAll() throws InterruptedException {
        List<Label> all = labelService.findAll();
        //TimeUnit.SECONDS.sleep( 4 );
        return new Result(true, StatusCode.OK.getStatus(),"查询成功...",all );
    }

    @GetMapping("/{labelId}")
    public Result findById(@PathVariable String labelId){
        Label label = labelService.findById(labelId);
        return new Result(true, StatusCode.OK.getStatus(),"查询成功...",label );
    }

    @PostMapping
    public Result saveLabel( @RequestBody Label label ){
        Label save = labelService.save( label );
        return new Result(true, StatusCode.OK.getStatus(),"保存成功...",null);
    }

    @PutMapping("/{labelId}")
    public Result updateById(@PathVariable String labelId,@RequestBody Label label){
        label.setId( labelId );
        labelService.update(label);
        return new Result(true, StatusCode.OK.getStatus(),"更新成功...",null);
    }

    @DeleteMapping("/{labelId}")
    public Result deleteById(@PathVariable String labelId){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK.getStatus(),"删除成功...",null);
    }

    @PostMapping("/search")
    public Result findSearch(@RequestBody Label label){
        List<Label> list = labelService.findSearch(label);
        return new Result(true, StatusCode.OK.getStatus(),"查询成功...",list);
    }

    @PostMapping("/search/{page}/{size}")
    public Result findSearchAndPage(@RequestBody Label label,@PathVariable Integer page,@PathVariable Integer size){
        Page<Label> res = labelService.findSearchAndPage(label,page,size);
        return new Result(true, StatusCode.OK.getStatus(),"查询成功...",
                new PageResult<Label>( res.getTotalElements(),res.getContent() ) );
    }
}
