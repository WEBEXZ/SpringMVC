package com.webexz.springmvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class User {
	private String userName;
	@Pattern(regexp="^\\d+$", message="Only numbers")
	@NotNull(message="is required")
	@Size(min=5, message="is required")
	private String password;
	private String role;
	private String status;
	private String[] uses;
	@NotNull(message="is required")
	@Min(value=1, message="must be greater than or equal to one")
	@Max(value=3, message="must be less than or equal to three")
	private Integer numberSessions;
	private LinkedHashMap<String, String> roles;
	private LinkedHashMap<String, String> statusOptions;
	private LinkedHashMap<String, String> useOptions;
	
	public User() {
		roles = new LinkedHashMap<>();
		statusOptions = new LinkedHashMap<>();
		useOptions = new LinkedHashMap<>();
		roles.put("Administrator", "Administrator");
		roles.put("Viewer", "Viewer");
		statusOptions.put("yes", "yes");
		statusOptions.put("no", "no");
		useOptions.put("However", "However");
		useOptions.put("Practice", "Practice");
		useOptions.put("Nothing", "Nothing");
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LinkedHashMap<String, String> getRoles() {
		return roles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LinkedHashMap<String, String> getStatusOptions() {
		return statusOptions;
	}

	public String[] getUses() {
		return uses;
	}

	public void setUses(String[] uses) {
		this.uses = uses;
	}

	public LinkedHashMap<String, String> getUseOptions() {
		return useOptions;
	}

	public Integer getNumberSessions() {
		return numberSessions;
	}

	public void setNumberSessions(Integer numberSessions) {
		this.numberSessions = numberSessions;
	}
}