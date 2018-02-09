package com.springboot.test.service.Impl;

import com.springboot.test.domain.User;
import com.springboot.test.repository.UserRepository;
import com.springboot.test.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Owen Zhao
 * @Description:
 * @Date: Created in 2018/2/6 14:14
 */
@Service
public class UserServiceImpl implements UserService{

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User insertByUser(User user) {
        LOGGER.info("新增用户："+user.toString());
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        LOGGER.info("更新用户："+user.toString());
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);

        LOGGER.info("删除用户："+user.toString());
        return user;
    }

    @Override
    public User findById(Long id) {
        LOGGER.info("获取用户ID："+id);
        return userRepository.findById(id).get();
    }
}
