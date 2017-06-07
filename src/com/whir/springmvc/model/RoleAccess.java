package com.whir.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role_access")
public class RoleAccess implements java.io.Serializable{

	private Integer id ;
	private Integer roleId ;
	private Integer accessId ;
	private Date createdTime ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id",unique=true)  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="role_id")
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	@Column(name="access_id")
	public Integer getAccessId() {
		return accessId;
	}
	public void setAccessId(Integer accessId) {
		this.accessId = accessId;
	}
	
	@Column(name="created_time")
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	
}
