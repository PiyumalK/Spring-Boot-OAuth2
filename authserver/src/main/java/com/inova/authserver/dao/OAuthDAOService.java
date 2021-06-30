/**
 * 
 */
package com.inova.authserver.dao;

import com.inova.authserver.model.UserEntity;

/**
 * @author Piyumal
 *
 */
public interface OAuthDAOService {
	
	public UserEntity getUserDetails(String emailId);

}
