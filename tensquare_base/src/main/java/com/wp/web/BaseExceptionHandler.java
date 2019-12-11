package com.wp.web;

import com.wp.entity.Result;
import com.wp.entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wp
 * @Title: BaseExceptionHandler
 * @Description: TODO
 * @date 2019/12/6 19:36
 */
@ControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        log.error( "发生异常。。。。",e );
        return new Result( true, StatusCode.ERROR.getStatus(),e.getMessage(),null );
    }
}
