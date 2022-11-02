package com.usermgm.repository;

import com.usermgm.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>  {
	//user defined query to retrive user basedon user id;
		@Query(value="select * from user where user_id=?1", nativeQuery=true)
		User findByUserId(int id);
}
