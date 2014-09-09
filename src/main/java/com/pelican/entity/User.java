//
//package com.pelican.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name="users.auth")
//@Data
//public class User
//{
//	@Id @GeneratedValue(strategy=GenerationType.AUTO)
//	private int id;
//	private String name;
//	@Column(nullable=false, unique=true)
//	private String email;
//	@Column(nullable=false)
//	private String password;
//
//	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id")
//	private Set<Role> roles = new HashSet<>();
//
//
//}
