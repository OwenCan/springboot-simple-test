package com.springboot.test.service;

import com.springboot.test.domain.User;

import java.util.List;

/**
 * @Author Owen Zhao
 * @Description:
 * @Date: Created in 2018/2/6 14:13
 */
public interface UserService {

    List<User> findAll();

    User insertByUser(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);
}
