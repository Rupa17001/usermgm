package com.usermgm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
@Entity
public class User {
	@Id
	private int userId;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userPassword;

}
