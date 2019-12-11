package com.wp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wp
 * @Title: Result
 * @Description: TODO
 * @date 2019/12/3 21:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Boolean flag;
    private Integer code;
    private String message;
    private Object data;


}
