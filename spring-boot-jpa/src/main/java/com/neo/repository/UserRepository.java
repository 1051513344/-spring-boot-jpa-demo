package com.neo.repository;

import com.neo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


   List<User> findAllByIdLessThan(Long maxId);

   @Query(value="select * from `user` where id < 50", nativeQuery=true)
   List<User> getAllUserByMaxId();

   @Query(value = "update `user` set user_name='张老三' where id = ?1", nativeQuery = true)
   @Modifying
   @Transactional
   void updateUserNameById(Long id);


}