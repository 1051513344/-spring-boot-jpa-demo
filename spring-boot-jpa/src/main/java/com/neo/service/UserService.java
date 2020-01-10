package com.neo.service;

import com.neo.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User getUserByExample();
    List<User> getAllUserByPage();
    List<User> getUserByLessId(Long maxId);
    List<User> getUserByMaxId();
    void updateUserNameById(Long id);
    User getUserById(Long id);
}
