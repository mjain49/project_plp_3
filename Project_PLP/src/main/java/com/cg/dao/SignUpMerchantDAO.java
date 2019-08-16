package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bean.Merchant;



public interface SignUpMerchantDAO extends JpaRepository<Merchant, Integer>{

	@Query("SELECT m FROM MERCHANT m where m.emailId=?1")
	public Merchant merchantExists(String emailId); 

}
