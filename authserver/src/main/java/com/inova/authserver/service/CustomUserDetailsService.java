/**
 * 
 */
package com.inova.authserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inova.authserver.dao.OAuthDAOService;
import com.inova.authserver.model.CustomUser;
import com.inova.authserver.model.UserEntity;

/**
 * @author Piyumal
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	OAuthDAOService oAuthDAOService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = null;

		try {
			userEntity = oAuthDAOService.getUserDetails(username);

			if (userEntity != null && userEntity.getId() != null && !"".equalsIgnoreCase(userEntity.getId())) {
				CustomUser customUser = new CustomUser(userEntity);
				return customUser;
			} else {
				throw new UsernameNotFoundException("User " + username + " was not found in the database");
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
	}

}
