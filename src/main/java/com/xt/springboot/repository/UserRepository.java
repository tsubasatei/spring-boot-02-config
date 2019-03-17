package com.xt.springboot.repository;

import com.xt.springboot.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xt
 * @date 2019/3/17 - 6:33
 * @description
 */
public interface UserRepository extends JpaRepository<User, Integer>{
}
