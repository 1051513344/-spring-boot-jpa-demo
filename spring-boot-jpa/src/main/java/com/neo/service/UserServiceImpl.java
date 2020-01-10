package com.neo.service;

import com.neo.model.User;
import com.neo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        //查询所有数据
        return userRepository.findAll();
    }

    @Override
    public User getUserByExample() {
        //根据条件查询
        User user = new User();
        user.setId(1L);
        Example<User> example = Example.of(user);
        return userRepository.findOne(example).get();
    }

    @Override
    public List<User> getAllUserByPage() {
        //分页+排序查询演示：
        //Pageable pageable = new PageRequest(page, size);//2.0版本后,该方法以过时
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 5, sort);
        Page<User> users = userRepository.findAll(pageable);
        return users.getContent();
    }

    @Override
    public List<User> getUserByLessId(Long maxId) {
        return userRepository.findAllByIdLessThan(maxId);
    }

    @Override
    public List<User> getUserByMaxId() {
        return userRepository.getAllUserByMaxId();
    }


    @Override
    public void updateUserNameById(Long id) {
        userRepository.updateUserNameById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
}
