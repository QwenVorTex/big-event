package org.ccnuiot.bigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ccnuiot.bigevent.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("INSERT INTO category (category_name, category_alias, create_user, create_time, update_time) " +
            "VALUES (#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Category category);

    @Select("SELECT * FROM category WHERE create_user = #{userId}")
    List<Category> list(Integer userId);
}
