package org.ccnuiot.bigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ccnuiot.bigevent.pojo.User;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    // 添加用户
    @Insert("INSERT INTO user (username, password, create_time, update_time) " +
            "VALUES (#{username}, #{password}, now(), now())")
    void add(String username, String password);
}
