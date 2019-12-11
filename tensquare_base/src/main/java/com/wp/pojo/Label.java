package com.wp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: wp
 * @Title: Label
 * @Description: TODO
 * @date 2019/12/5 20:11
 */
@Data
@Table(name="tb_label")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Label implements Serializable {

    @Id
    private String id;
    private String labelname;
    private String state;
    private Long count;
    private Long fans;
    private String recommend;

}
