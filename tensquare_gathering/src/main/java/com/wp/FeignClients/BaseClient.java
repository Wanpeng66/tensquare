package com.wp.FeignClients;

import com.wp.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wp
 * @Title: BaseClient
 * @Description: TODO
 * @date 2019/12/25 20:58
 */
@FeignClient(value = "tensquare-base",fallback = BaseClientFallBack.class)
public interface BaseClient {

    @GetMapping("/label")
    public Result getAll();
}
