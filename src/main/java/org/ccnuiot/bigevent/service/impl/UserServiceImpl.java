package org.ccnuiot.bigevent.service.impl;

import org.ccnuiot.bigevent.mapper.UserMapper;
import org.ccnuiot.bigevent.pojo.User;
import org.ccnuiot.bigevent.service.UserService;
import org.ccnuiot.bigevent.utils.Md5Util;
import org.ccnuiot.bigevent.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User u = userMapper.findByUsername(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        //加密
        String md5String = Md5Util.getMD5String(password);
        //添加
        userMapper.add(username, md5String);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    @Override
    public void updatePassword(String newPassword) {
        Map<String, Object> map = ThreadLocalUtil.get();
        //获取当前用户ID
        Integer id = (Integer) map.get("id");
        userMapper.updatePassword(Md5Util.getMD5String(newPassword), id);
    }
}
