package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bean.User1;

public interface SignUpUserDAO extends JpaRepository<User1, Integer>{

	@Query("SELECT u FROM USER1 u where u.emailId=?1")
	public User1 userExists(String emailId); 
}
