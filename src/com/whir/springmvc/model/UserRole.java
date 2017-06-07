package com.whir.springmvc.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole implements java.io.Serializable{
 
	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	private Integer uid ;
	private Integer role_id ;
	private Date createTime ;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="id",unique=true)  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="created_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="uid")
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	@Column(name="role_id")
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	
	/*@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="role_id",nullable=true) 
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="uid",nullable=true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
}
