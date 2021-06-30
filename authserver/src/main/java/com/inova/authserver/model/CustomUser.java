/**
 * 
 */
package com.inova.authserver.model;

import org.springframework.security.core.userdetails.User;

/**
 * @author Piyumal
 *
 */
public class CustomUser extends User {
	
	private String id;
	private String name;
	
	public CustomUser(UserEntity userEntity ) {
		super(userEntity.getEmailId(), userEntity.getPassword(), userEntity.getGrantedAuthoritiesList());
		this.id = userEntity.getId();
		this.name = userEntity.getName();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
