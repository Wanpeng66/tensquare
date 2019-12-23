package com.wp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author: wp
 * @Title: Article
 * @Description: TODO
 * @date 2019/12/19 20:23
 */
@Document( indexName = "tensquare_article",type = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private String id;

    @Field(type = FieldType.Keyword,
            analyzer = "ik_max_words",searchAnalyzer = "ik_max_words")
    private String title;

    @Field(type = FieldType.Text,
            analyzer = "ik_max_words",searchAnalyzer = "ik_max_words")
    private String content;

    private String state;



}
