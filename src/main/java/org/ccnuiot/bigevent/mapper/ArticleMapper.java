package org.ccnuiot.bigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.ccnuiot.bigevent.pojo.Article;

@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO article (title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "VALUES (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Article article);
}
