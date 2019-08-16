package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.bean.Admin;


public interface SignUpAdminDAO extends JpaRepository<Admin, Integer>{

	@Query("SELECT a FROM ADMIN a where a.emailId=?1")
	public Admin adminExists(String emailId); 

}
