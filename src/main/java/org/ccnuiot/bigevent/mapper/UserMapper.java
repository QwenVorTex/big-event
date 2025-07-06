package org.ccnuiot.bigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Update("UPDATE user SET nickname = #{nickname}, email = #{email}, update_time = #{updateTime}" +
            "WHERE id = #{id}")
    void update(User user);

    @Update("UPDATE user SET user_pic = #{avatarUrl}, update_time = now() WHERE id = #{id}")
    void updateAvatar(String avatarUrl, Integer id);

    @Update("UPDATE user SET password = #{md5String}, update_time = now() WHERE id = #{id}")
    void updatePassword(String md5String, Integer id);
}
