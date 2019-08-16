package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Admin;
import com.cg.bean.Merchant;
import com.cg.bean.SecurityAns;
import com.cg.bean.User1;
import com.cg.dao.SecurityAnswerDAO;
import com.cg.dao.SignUpAdminDAO;
import com.cg.dao.SignUpMerchantDAO;
import com.cg.dao.SignUpUserDAO;

@Service
@Transactional
public class SignUpServiceImpl implements SignUpService{

	@Autowired
	private SignUpUserDAO userDAO;
	
	@Autowired
	private SecurityAnswerDAO securityAns;
	
	@Autowired
	private SignUpAdminDAO adminDAO;
	
	@Autowired
	private SignUpMerchantDAO merchantDAO;
	
	@Transactional(readOnly=true)
	public boolean userExists(String emailId) {
		
		if(userDAO.userExists(emailId)!=null)
			return true;
		else
			return false;
	}

	@Transactional(readOnly=true)
	public boolean merchantExists(String emailId) {
		if(merchantDAO.merchantExists(emailId)!=null)
			return true;
		else
			return false;
	}

	@Transactional(readOnly=true)
	public boolean adminExists(String emailId) {
		if(adminDAO.adminExists(emailId)!=null)
			return true;
		else
			return false;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addUser(User1 user) {
		try {
		userDAO.save(user);
		return true;
		}catch(Exception e) {
		return false;
		}
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addAdmin(Admin admin) {
		try {
		adminDAO.save(admin);
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addMerchant(Merchant merchant) {
		try {
		merchantDAO.save(merchant);
		return true;
		}catch(Exception e) {
		return false;
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addSecurityAns(SecurityAns security) {
		try {
			securityAns.save(security);
		return true;
		}catch(Exception e) {
		return false;
		}
	}

}
