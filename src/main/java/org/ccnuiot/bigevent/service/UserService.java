package org.ccnuiot.bigevent.service;

import org.ccnuiot.bigevent.pojo.User;

public interface UserService {
    //根据用户名查询用户
    User findByUsername(String username);

    //注册用户
    void register(String username, String password);

    //更新用户信息
    void update(User user);

    void updateAvatar(String avatarUrl);
}
