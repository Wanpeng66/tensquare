package com.wp.service;

import com.wp.pojo.Label;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: wp
 * @Title: LabelService
 * @Description: TODO
 * @date 2019/12/5 20:40
 */
public interface LabelService {

    List<Label> findAll();

    Label findById( String labelId );

    Label save( Label label );

    Label update( Label label );

    void deleteById( String labelId );

    List<Label> findSearch( Label label );

    Page<Label> findSearchAndPage( Label label, Integer page, Integer size );
}
