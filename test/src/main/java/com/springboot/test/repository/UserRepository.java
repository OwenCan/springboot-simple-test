package com.springboot.test.repository;

import com.springboot.test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Owen Zhao
 * @Description:
 * @Date: Created in 2018/2/6 14:58
 */
public interface UserRepository extends JpaRepository<User,Long>{

}
