package com.wp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: wp
 * @Title: Spit
 * @Description: TODO
 * @date 2019/12/10 21:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spit implements Serializable {
    @Id
    private String _id;
    private String content;
    private Date publishTime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentid;


}
