package com.wp.FeignClients;

import com.wp.entity.Result;
import com.wp.entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author: wp
 * @Title: BaseClientFallBack
 * @Description: TODO
 * @date 2019/12/25 20:59
 */
@Component
public class BaseClientFallBack implements  BaseClient{
    @Override
    public Result getAll() {
        return new Result( true, StatusCode.REMOTEERROR.getStatus(),StatusCode.REMOTEERROR.getText(),null );
    }
}
